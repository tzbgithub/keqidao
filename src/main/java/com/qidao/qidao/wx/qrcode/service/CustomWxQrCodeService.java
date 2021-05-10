package com.qidao.qidao.wx.qrcode.service;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.qrcode.QrcodeTicket;

import java.awt.image.BufferedImage;

public interface CustomWxQrCodeService {

    /**
     *
     * @param expireSeconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒
     * @param sceneId 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @return
     */
    BaseResult qrcodeCreateTemp(int expireSeconds, long sceneId);

    /**
     * 创建临时二维码，带有sceneStr
     * @param expireSeconds 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为30秒
     * @param sceneStr 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
     * @return
     */
    BaseResult qrcodeCreateTemp(int expireSeconds, String sceneStr);

    /**
     * 创建永久二维码，带有sceneId
     * @param sceneId 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
     * @return
     */
    BaseResult qrcodeCreateFinal(int sceneId);

    /**
     * 创建临永久二维码，带有sceneStr
     * @param sceneStr 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
     * @return
     */
    BaseResult qrcodeCreateFinal(String sceneStr);

    /**
     * 通过ticket换取二维码
     * @param ticket 获取的二维码ticket，凭借此ticket可以在有效时间内换取二维码
     * @return
     */
    BufferedImage showqrcode(String ticket);

    /**
     *
     * @param qrcodeTicket 二维码实体类
     */
    void downloadQrCode(QrcodeTicket qrcodeTicket);



}
