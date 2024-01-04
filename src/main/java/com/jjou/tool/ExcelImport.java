package com.jjou.tool;

import com.jjou.domain.QuestionAndAnswer;
import com.jjou.util.ExcelImportUtils;
import com.jjou.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: excel表格导入到数据库
 *
 * @Author ojj
 * @Date 2024/1/4 11:43
 * @Version 1.0
 */
public class ExcelImport {
    public static void main(String[] args) {
        //在map中设置excel表头对应的属性名
        Map<String, String> map = new HashMap<>();
        map.put("一级目录", "firstContent");
        map.put("二级目录", "secondContent");
        map.put("三级目录", "thirdContent");
        map.put("四级目录", "fourthContent");
        map.put("关键词", "keyword");
        map.put("标题", "title");
        map.put("答案", "answer");
        map.put("知识有效期", "knowledgeValidity");
        map.put("来源", "source");
        map.put("问题", "question");

        try (FileInputStream fis = new FileInputStream(new File("D:\\workplace\\tmp\\test.xlsx")); //excel文件地址
             Workbook workbook = new XSSFWorkbook(fis);
             SqlSession sqlSession = MybatisUtils.getSqlSession()
        ){
            //获取第一张sheet
            Sheet sheet = workbook.getSheetAt(0);
            //获取文件数据
            List<QuestionAndAnswer> list = ExcelImportUtils.getListFromExcel(sheet, QuestionAndAnswer.class, map);

            //数据操作
//            for (QuestionAndAnswer t : list) {
//                System.out.println(t.toString());
//            }
//            System.out.println(list.size());
            String sqlId = "com.jjou.dao.QuestionAndAnswerDao.insert";
            int result = 0;
            for (QuestionAndAnswer t : list) {
                t.setCreateBy("ojj");
                t.setCreateTime(new Date());
                t.setUpdateBy("ojj");
                t.setUpdateTime(new Date());
                result += sqlSession.insert(sqlId, t);
            }
            sqlSession.commit();
            System.out.println("成功插入" + result + "条数据");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
