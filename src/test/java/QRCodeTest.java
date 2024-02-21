import com.jjou.util.QRCodeUtils;
import org.junit.Test;

/**
 * Description:
 *
 * @Author ojj
 * @Date 2024-02-21 14:12
 * @Version 1.0
 */
public class QRCodeTest {

    @Test
    public void test1(){
        // 扫码跳转地址
        String address = "https://www.baidu.com/";
        // 生成二维码的图片类型
        String imageType = "PNG";
        // 调用生成二维码方法
        String codeBase64 = QRCodeUtils.generateBase64(address, imageType);
        System.out.println("二维码内容：" + codeBase64);
    }
}
