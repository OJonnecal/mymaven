import com.jjou.domain.QuestionAndAnswer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * ClassName: MybatisTest
 * Description:
 *
 * @Author ojj
 * @Create 2023/12/27 13:54
 * @Version 1.0
 */
public class MybatisTest {

    @Test
    public void testSelect(){
        try {
            //访问mybatis读取user数据
            //1、定义mybatis主配置文件名称，从类路径的根开始（target/clasess）
            String config = "mybatis-config.xml";
            //2、读取config表示的文件
            InputStream in = Resources.getResourceAsStream(config);
            //3、创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //4、创建SqlSessionFactory对象
            SqlSessionFactory factory = builder.build(in);
            //5、获取SqlSession对象，从SqlSessionFactory中获取SqlSession(非自动提交事务，如果增删改需要手动提交事务)
            SqlSession sqlSession = factory.openSession();
            //6、指定要执行的SQL语句标识；sql映射文件中的 namespace + "." + 标签的id值
            String sqlId = "com.jjou.dao.QuestionAndAnswerDao.selectList";
            //7、执行sql语句，通过sqlId找到语句
            List<QuestionAndAnswer> list = sqlSession.selectList(sqlId);
            //8、输出结果
            for (QuestionAndAnswer entity : list){
                System.out.println("查询结果=" + entity);
            }
            //9、关闭SQLSession对象
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInsert(){
        try {
            //访问mybatis读取user数据
            //1、定义mybatis主配置文件名称，从类路径的根开始（target/clasess）
            String config = "mybatis-config.xml";
            //2、读取config表示的文件
            InputStream in = Resources.getResourceAsStream(config);
            //3、创建SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //4、创建SqlSessionFactory对象
            SqlSessionFactory factory = builder.build(in);
            //5、获取SqlSession对象，从SqlSessionFactory中获取SqlSession(非自动提交事务，如果增删改需要手动提交事务)
            SqlSession sqlSession = factory.openSession();
            //6、指定要执行的SQL语句标识；sql映射文件中的 namespace + "." + 标签的id值
            String sqlId = "com.jjou.dao.QuestionAndAnswerDao.insert";
            //7、执行sql语句，通过sqlId找到语句
            QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer();
            questionAndAnswer.setFirstContent("2");
            int result = sqlSession.insert(sqlId, questionAndAnswer);

            sqlSession.commit();
            System.out.println("成功插入:" + result);

            //8、关闭SQLSession对象
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
