package com.qidao.qidao.wx.qrcode.service.impl;

import com.qcloud.cos.utils.IOUtils;
import com.qidao.qidao.wx.qrcode.service.CustomWxQrCodeService;
import com.qidao.qidao.wx.constant.Env;
import org.springframework.beans.factory.annotation.Autowired;
import weixin.popular.api.QrcodeAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.qrcode.QrcodeTicket;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.*;

public class CustomWxQrCodeServiceImpl implements CustomWxQrCodeService {
    @Autowired
    Env env;
    @Override
    public BaseResult qrcodeCreateTemp(int expireSeconds, long sceneId) {
        return QrcodeAPI.qrcodeCreateTemp(env.getAccessToken(), expireSeconds, sceneId);
    }

    @Override
    public BaseResult qrcodeCreateTemp(int expireSeconds, String sceneStr) {
        return QrcodeAPI.qrcodeCreateTemp(env.getAccessToken(), expireSeconds, sceneStr);
    }

    @Override
    public BaseResult qrcodeCreateFinal(int sceneId) {
        return QrcodeAPI.qrcodeCreateFinal(env.getAccessToken(), sceneId);
    }

    @Override
    public BaseResult qrcodeCreateFinal(String sceneStr) {
        return QrcodeAPI.qrcodeCreateFinal(env.getAccessToken(), sceneStr);

    }

    @Override
    public BufferedImage showqrcode(String ticket) {
        return QrcodeAPI.showqrcode(ticket);
    }

    @Override
    public void downloadQrCode(QrcodeTicket qrcodeTicket) {
        String ticket = qrcodeTicket.getTicket();
        BufferedImage image = QrcodeAPI.showqrcode(ticket);
        try {
            generateQrcodeFile(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //bufferimage转化为文件
    public void generateQrcodeFile(BufferedImage img) throws IOException {
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ImageOutputStream imOut = ImageIO.createImageOutputStream(bs);
        ImageIO.write(img, "jpg", imOut);
        InputStream inputStream = new ByteArrayInputStream(bs.toByteArray());
        OutputStream outStream = new FileOutputStream("C:\\Users\\mlllolllm\\Desktop\\test.jpg");
        IOUtils.copy(inputStream, outStream);
        inputStream.close();
        outStream.close();
    }

}
