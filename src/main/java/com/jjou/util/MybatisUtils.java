package com.jjou.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Description:
 *
 * @Author ojj
 * @Create 2023/12/27 14:43
 * @Version 1.0
 */
public class MybatisUtils {

    public static SqlSession getSqlSession() throws IOException {
        String config = "mybatis-config.xml";
        InputStream ins = Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(ins);
        SqlSession sqlSession = factory.openSession();
        return sqlSession;
    }
}
