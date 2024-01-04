import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Description:
 *
 * @Author ojj
 * @Date 2024/1/4 14:58
 * @Version 1.0
 */
public class IOTest {

    @Test
    public void test1(){
        File srcFile = new File("D:\\workplace\\iotest\\1.jpeg");
        File destFile = new File("D:\\workplace\\iotest\\2.jpeg");

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

//            //读取
//            byte[] bytes = new byte[1024];
//            int len;
//            while((len = fis.read(bytes)) != -1){
//                //写入
//                fos.write(bytes, 0, len);
//            }

            if (IOUtils.copy(fis, fos) == -1) {
                System.out.println("复制失败");
            } else {
                System.out.println("复制成功");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
