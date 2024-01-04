package com.jjou.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Description: excel表格数据导入工具类
 *
 * @Author ojj
 * @Create 2023/12/27 10:42
 * @Version 1.0
 */
public class ExcelImportUtils {

    public static <T> List<T> getListFromExcel(Sheet sheet , Class cs , Map<String , String> map) throws Exception {
        T e;
        List<T> list = new ArrayList<>();
        //根据第一行获取表头对应的属性顺序
        List<String> paramsList = getMethodFromFirstRow(sheet , map);
        //根据类和属性顺序的List 获取属性对应的类型属性
        List<Class> typeClass = getParamsType(cs , paramsList);
        //遍历所有行 从第二行开始 首行是表头字段
        for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getLastRowNum(); i++) {
            //单元行
            Row row = sheet.getRow(i);
            //一行对应一个T，将对象强转为泛型
            e = (T) cs.newInstance();
            //遍历单元行的每一列 设置值给泛型e
            for (int j = 0; j < row.getLastCellNum(); j++) {
                //获取一个单元格
                Cell cell = row.getCell(j);
                //调用泛型对象的set方法设置单元格里的值 这也就是为什么我们要获取属性顺序以及其对应的类型
                cs.getMethod(getSetterMethodName(paramsList.get(j)) , typeClass.get(j))
                        .invoke(e , getValueFromType(cell , typeClass.get(j)));
            }
            list.add(e);
        }
        return list;
    }

    public static List<String> getMethodFromFirstRow(Sheet sheet, Map<String,String> map) throws Exception {
        //获取表头
        Row row = sheet.getRow(sheet.getFirstRowNum());
        //获取到的属性列表
        List<String> paramsList = new ArrayList<>();
        //遍历表头
        for(int i = row.getFirstCellNum(); i  < row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            //获取行字符串的值
            String str = cell.getStringCellValue();
            //键值对映射获取对应方法名称
            if(map.containsKey(str)) {
                //获取对应属性的set方法
                paramsList.add(map.get(str));
            } else {
                throw new Exception("请检查首行数据是否正确。");
            }
        }
        return  paramsList;
    }

    public static List<Class> getParamsType(Class cs, List<String> paramsList){
        List<Class> typeClass = new ArrayList<>();
        //对象的所有属性
        Field[] fields = cs.getDeclaredFields();
        HashMap<String, Class> map = new HashMap<>();
        for (Field field : fields) {
            map.put(field.getName(), field.getType());
        }
        for (String s : paramsList) {
            typeClass.add(map.get(s));
        }
        return typeClass;
    }

    public static String getSetterMethodName(String param){
        char[] chars = param.toCharArray();
        if(Character.isLowerCase(chars[0])){
            //属性首字母大写
            chars[0] -= 32;
        }
        return "set" + new String(chars);
    }

    public static Object getValueFromType(Cell cell, Class cs){
        //字符串类型
        if (String.class.equals(cs)) {
            //设置对应的类型
            cell.setCellType(CellType.STRING);
            return cell.getStringCellValue();
        } else if(boolean.class.equals(cs)){
            //boolean类型
            cell.setCellType(CellType.BOOLEAN);
            return cell.getBooleanCellValue();
        }else if (Date.class.equals(cs)) {
            //日期类型 此种数据并未测试
            return cell.getDateCellValue();
        } else if (int.class.equals(cs) || Integer.class.equals(cs)){
            //int类型
            cell.setCellType(CellType.NUMERIC);
            return (int)cell.getNumericCellValue();
        } else if(double.class.equals(cs) || Double.class.equals(cs)) {
            //double类型
            cell.setCellType(CellType.NUMERIC);
            return cell.getNumericCellValue();
        }
        //这里还可以填充其他类型
        else {
            //未知类型 默认为错误类型
            return cell.getErrorCellValue();
        }
    }
}
