import com.jjou.domain.Assets;
import com.jjou.domain.InspectEquipment;
import com.jjou.util.ExcelImportUtils;
import com.jjou.util.MybatisUtils;
import com.mysql.cj.util.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: ExcelTest
 * Description:测试excel表格操作
 *
 * @Author ojj
 * @Create 2023/12/27 9:48
 * @Version 1.0
 */
public class ExcelTest {

    @Test
    public void test1(){
        //在map中设置excel表头对应的属性名
        Map<String, String> map = new HashMap<>();
        map.put("类别名称", "inspectName");
        map.put("固定资产名称", "assetsName");
        map.put("固定资产编号", "assetsCode");
        map.put("开始使用日期", "beginUseTime");
        map.put("使用年限(月)", "useLife");
        map.put("原值", "assetsOriginPrice");
        map.put("使用部门", "dutyDeptName");
        map.put("使用状况", "useStatus");
        map.put("增加方式", "addWay");
        map.put("保管人", "dutyUserName");
        map.put("存放地点", "storageLocation");
        map.put("规格型号", "assetsSpecification");

        try (FileInputStream fis = new FileInputStream(new File("D:\\workplace\\tmp\\import.xlsx"));
             Workbook workbook = new XSSFWorkbook(fis);
             SqlSession sqlSession = MybatisUtils.getSqlSession()
             ){
            //获取第一张sheet
            Sheet sheet = workbook.getSheetAt(0);
            //获取文件数据
            List<Assets> list = ExcelImportUtils.getListFromExcel(sheet, Assets.class, map);

            //数据操作
//            for (QuestionAndAnswer t : list) {
//                System.out.println(t.toString());
//            }
//            System.out.println(list.size());
            String sqlId = "com.jjou.dao.AssetsDao.insert";
            String sqlId2 = "com.jjou.dao.AssetsDao.insertIns";
            String sqlId3 = "com.jjou.dao.AssetsDao.selectInsCountById";
            int result = 0;
            for (Assets t : list) {
                if(StringUtils.isNullOrEmpty(t.getAssetsCode())){
                    continue;
                }
                //关联配置
                Long inspectId = null;
                String inspectName = t.getInspectName();
                if(!StringUtils.isNullOrEmpty(inspectName)){
                    InspectEquipment inspect = sqlSession.selectOne(sqlId3, inspectName);
                    if (inspect == null) {
                        InspectEquipment inspectEquipment = new InspectEquipment();
                        inspectEquipment.setEquipmentName(inspectName);
                        inspectEquipment.setDelFlag(0);
                        inspectEquipment.setCreateBy("ojj");
                        inspectEquipment.setCreateTime(new Date());
                        inspectEquipment.setUpdateBy("ojj");
                        inspectEquipment.setUpdateTime(new Date());
                        sqlSession.insert(sqlId2, inspectEquipment);
                        inspectId = inspectEquipment.getId();
                    }else{
                        inspectId = inspect.getId();
                    }
                }
                //设置状态
                String useStatus = t.getUseStatus();
                if(!StringUtils.isNullOrEmpty(useStatus)){
                    if(useStatus.equals("在用")){
                        t.setStatus(1);
                    }else if(useStatus.equals("列管资产已报废")){
                        t.setStatus(2);
                    }else if(useStatus.equals("未使用")){
                        t.setStatus(0);
                    }
                }
                t.setInspectId(inspectId);
                t.setAssetsQuantity(1);
                t.setDelFlag(0);
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

    @Test
    public void test2(){
        //在map中设置excel表头对应的属性名
        Map<String, String> map = new HashMap<>();
        map.put("资产编码", "assetsCode");
        map.put("实物编号", "physicalCode");
        map.put("类型", "assetsTypeName");
        map.put("名称", "assetsName");
        map.put("规格型号", "assetsSpecification");
        map.put("数量", "assetsQuantity");
        map.put("原值", "assetsOriginPrice");
        map.put("购置时间", "acquisitionTime");
        map.put("产权单位", "propertyUnitName");
        map.put("领用部门", "dutyDeptName");
        map.put("领用时间", "claimTime");
        map.put("存放地点", "storageLocation");
        map.put("负责人", "dutyUserName");
        map.put("备注", "remark");


        try (FileInputStream fis = new FileInputStream(new File("D:\\workplace\\tmp\\import2.xlsx"));
             Workbook workbook = new XSSFWorkbook(fis);
             SqlSession sqlSession = MybatisUtils.getSqlSession()
        ){
            //获取第一张sheet
            Sheet sheet = workbook.getSheetAt(0);
            //获取文件数据
            List<Assets> list = ExcelImportUtils.getListFromExcel(sheet, Assets.class, map);

            //数据操作
//            for (QuestionAndAnswer t : list) {
//                System.out.println(t.toString());
//            }
//            System.out.println(list.size());
            String sqlId = "com.jjou.dao.AssetsDao.update";
            int result = 0;
            for (Assets t : list) {
                if(StringUtils.isNullOrEmpty(t.getAssetsCode())){
                    continue;
                }
                //关联配置
                Long inspectId = null;

                //设置类型
                String assetsTypeName = t.getAssetsTypeName();
                if(!StringUtils.isNullOrEmpty(assetsTypeName)){
                    if(assetsTypeName.equals("固定资产")){
                        t.setAssetsType(0);
                    }else if(assetsTypeName.equals("高值办公用品")){
                        t.setAssetsType(1);
                    }else if(assetsTypeName.equals("低值易耗品")){
                        t.setAssetsType(2);
                    }
                }
                //设置产权单位
                t.setPropertyUnit(100L);

                t.setUpdateBy("ojj");
                t.setUpdateTime(new Date());
                result += sqlSession.insert(sqlId, t);
            }
            sqlSession.commit();
            System.out.println("成功修改" + result + "条数据");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
