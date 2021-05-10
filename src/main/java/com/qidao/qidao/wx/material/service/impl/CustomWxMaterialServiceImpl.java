package com.qidao.qidao.wx.material.service.impl;

import com.qidao.qidao.wx.constant.Env;
import com.qidao.qidao.wx.material.service.CustomWxMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import weixin.popular.api.MaterialAPI;
import weixin.popular.api.MediaAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.material.MaterialGetResult;
import weixin.popular.bean.media.MediaGetResult;
import weixin.popular.bean.media.MediaType;
import weixin.popular.bean.message.Article;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.List;

public class CustomWxMaterialServiceImpl implements CustomWxMaterialService {
    @Autowired
    Env env;

    @Override
    public BaseResult mediaUpload( MediaType mediaType, File filePath) {
        return MediaAPI.mediaUpload(env.getAccessToken(), mediaType, filePath);
    }

    @Override
    public BaseResult mediaUpload( MediaType mediaType, URI url) {
        return MediaAPI.mediaUpload(env.getAccessToken(), mediaType, url);
    }

    @Override
    public BaseResult mediaGet( String mediaId) {
        return MediaAPI.mediaGet(env.getAccessToken(), mediaId);
    }

    @Override
    public BaseResult addMaterial( MediaType mediaType, File filePath) {
        return MaterialAPI.add_material(env.getAccessToken(), mediaType, filePath, null);
    }

    @Override
    public BaseResult addMaterial( MediaType mediaType, URI url) {
        return MaterialAPI.add_material(env.getAccessToken(), mediaType, url, null);
    }

    @Override
    public BaseResult getMaterial( String mediaId) {
        return MaterialAPI.get_material(env.getAccessToken(), mediaId);
    }

    @Override
    public BaseResult deleteMaterial( String mediaId) {
        return MaterialAPI.del_material(env.getAccessToken(), mediaId);
    }

    @Override
    public BaseResult updateNew( String mediaId, int index, List<Article> articles) {
        return MaterialAPI.update_news(env.getAccessToken(), mediaId, index, articles);
    }

    @Override
    public BaseResult getMaterialCount() {
        return MaterialAPI.get_materialcount(env.getAccessToken());
    }

    @Override
    public BaseResult batchgetMaterial( String type, int offset, int count) {
        return MaterialAPI.batchget_material(env.getAccessToken(), type, offset, count);
    }

    @Override
    public void downloadMaterial( String mediaId, String downloadPath, String newFileName) {
        MaterialGetResult material = MaterialAPI.get_material(env.getAccessToken(), mediaId);
        //byte数组转化为文件
        getFileByBytes(material.getBytes(), downloadPath, newFileName);
    }

    @Override
    public void downloadMedia( String mediaId, String downloadPath, String newFileName) {
        MediaGetResult mediaGetResult = MediaAPI.mediaGet(env.getAccessToken(), mediaId);
        getFileByBytes(mediaGetResult.getBytes(), downloadPath, newFileName);
    }

    //byte数组转化为文件
    public static void getFileByBytes(byte[] bytes, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {// 判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath + "\\" + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

