package com.jjou.util;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;

/**
 * Description: 二维码工具类
 *
 * @Author ojj
 * @Date 2024-02-21 14:09
 * @Version 1.0
 */
public class QRCodeUtils {
    /**
     * 二维码生成base64字符串
     * @param content 跳转地址(即扫码后跳转的地址,可以是后端项目地址,用户扫码后填写数据提交到后台)
     * @param imageType 图片类型
     */
    public static String generateBase64(String content,String imageType) {
        if(content.isEmpty()){
            return null;
        }

        //二维码配置类
        QrConfig qrConfig = new QrConfig();

        return QrCodeUtil.generateAsBase64(content, qrConfig, imageType);
    }
}
