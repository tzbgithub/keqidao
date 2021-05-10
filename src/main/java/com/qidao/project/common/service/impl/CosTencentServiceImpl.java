package com.qidao.project.common.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.UploadResult;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.transfer.TransferManager;
import com.qcloud.cos.transfer.TransferManagerConfiguration;
import com.qcloud.cos.transfer.Upload;
import com.qidao.project.common.service.ICosTencentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.SimpleFormatter;

/**
 * @author Autuan
 */
@Service
@Slf4j
public class CosTencentServiceImpl implements ICosTencentService {
    private final COSClient cosClient;
    private final String regionName;

    public CosTencentServiceImpl( @Value("${cos.secretId}")String secretId,
                                 @Value("${cos.secretKey}")String secretKey,
                                 @Value("${cos.region}")String regionName) {
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        ClientConfig clientConfig = new ClientConfig(new Region(regionName));
        cosClient = new COSClient(cred, clientConfig);
        this.regionName = regionName;
    }

    @Override
    public String getDownPath(String buckedName) {
        return StrUtil.format("http://{}.cos.{}.myqcloud.com/",buckedName,regionName);
    }

    @Override
    public UploadResult upload(String buckedName, MultipartFile file,long maxSize) {
        try (InputStream inputStream = file.getInputStream()){
            //图片名称
            String originalFilename = file.getOriginalFilename();
            //图片后缀
            String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
            //生成新的图片名称(随机数0-9999+系统当前时间+上传图片名)
            String datePrefix = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));

            String fileName = datePrefix + "/" +  RandomUtil.randomInt(10000) + System.currentTimeMillis() + suffix;


            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(file.getSize());
            objectMetadata.setContentType(file.getContentType());
            ExecutorService threadPool = Executors.newCachedThreadPool();
            TransferManager transferManager = new TransferManager(cosClient, threadPool);
            // 设置高级接口的分块上传阈值和分块大小为10MB
            TransferManagerConfiguration transferManagerConfiguration = new TransferManagerConfiguration();
            transferManagerConfiguration.setMultipartUploadThreshold(maxSize);
            transferManagerConfiguration.setMinimumUploadPartSize(maxSize);
            transferManager.setConfiguration(transferManagerConfiguration);

            PutObjectRequest putObjectRequest = new PutObjectRequest(buckedName, fileName, inputStream, objectMetadata);
            Upload upload = transferManager.upload(putObjectRequest);

            // 等待传输结束（如果想同步的等待上传结束，则调用 waitForCompletion）
            UploadResult uploadResult = upload.waitForUploadResult();
            return uploadResult;
        } catch (InterruptedException | IOException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        return null;
    }
}
