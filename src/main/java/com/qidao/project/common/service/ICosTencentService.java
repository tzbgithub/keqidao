package com.qidao.project.common.service;

import com.qcloud.cos.model.UploadResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface ICosTencentService {
    /**
     * 获取图片下载路径
     * @param buckedName
     * @return
     */
    String getDownPath(String buckedName);
    /**
     * 文件上传
     * @param buckedName
     * @param file
     * @param maxSize
     */
    UploadResult upload(String buckedName, MultipartFile file,long maxSize);
}
