package com.qidao.qidao.wx.material.service;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.media.MediaType;
import weixin.popular.bean.message.Article;

import java.io.File;
import java.net.URI;
import java.util.List;

public interface CustomWxMaterialService {
    /**
     * 本地上传临时素材到微信服务器
     * @param mediaType 上传的临时素材类型
     * @param filePath 本地文件的路径
     * @return
     */
    BaseResult mediaUpload( MediaType mediaType, File filePath);

    /**
     * 通过url新增临时素材到微信服务器
     * @param mediaType 临时素材的类型
     * @param url 临时素材的url
     * @return
     */
    BaseResult mediaUpload( MediaType mediaType, URI url);

    /**
     * 获取临时素材
     * @param mediaId 素材唯一标记
     * @return
     */
    BaseResult mediaGet( String mediaId);

    /**
     * 通过本地上传永久素材到微信服务器
     * @param mediaType
     * @param filePath
     * @return
     */
    BaseResult addMaterial( MediaType mediaType, File filePath);

    /*
     *
     * @param accessToken 公众号的全局唯一接口调用凭据
     * @param mediaType 上传的永久素材类型
     * @param url 永久素材的url
     * */

    /**
     * 上传永久素材
     * @param mediaType
     * @param url
     * @return
     */
    BaseResult addMaterial( MediaType mediaType, URI url);

    /**
     * 获取永久素材
     * @param mediaId 素材唯一标记
     * @return
     */
    BaseResult getMaterial( String mediaId);

    /**
     * 删除永久素材
     * @param mediaId 素材唯一标记
     * @return
     */
    BaseResult deleteMaterial( String mediaId);

    /**
     * 修改永久图文素材
     * @param mediaId 要修改的图文消息的id
     * @param index 要更新的文章在图文消息中的位置（多图文消息时，此字段才有意义），第一篇为0
     * @param articles 多个图文消息
     * @return
     */
    BaseResult updateNew( String mediaId, int index, List<Article> articles);

    /**
     * 获取素材的总数
     * @return
     */
    BaseResult getMaterialCount();

    /**
     * 获取素材的列表
     * @param type 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
     * @param offset 从全部素材的该偏移位置开始返回，0表示从第一个素材
     * @param count 返回素材的数量，取值在1到20之间
     * @return
     */
    BaseResult batchgetMaterial( String type, int offset, int count);

    /**
     *
     * @param mediaId 素材的id
     * @param downloadPath 下载到本地的路径
     * @param newFileName 下载文件名字
     */
    void downloadMaterial( String mediaId, String downloadPath, String newFileName);

    /**
     *
     * @param mediaId 素材的id
     * @param downloadPath 下载到本地的路径
     * @param newFileName 下载文件名字
     */
    void downloadMedia( String mediaId, String downloadPath, String newFileName);










}
