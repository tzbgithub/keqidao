package com.qidao.project.common;

import com.qcloud.cos.model.UploadResult;
import com.qidao.framework.web.domain.AjaxResult;
import com.qidao.project.common.service.ICosTencentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Controller
@Slf4j
public class CosTencentController {
   @Autowired
   private ICosTencentService cosTencentService;

    @Value("${cos.imageBucketName}")
    String imageBucketName;
    @Value("${cos.videoBucketName}")
    String videoBucketName;

    /**
     * 上传图片
     * @param file
     * @return
     */
    @PostMapping("/cos/tencent/img")
    @ResponseBody
    AjaxResult upload(MultipartFile file){
        // todo 文件后缀校验 (Autuan)[21.1.31]
        // todo 文件大小校验 (Autuan)[21.1.31]
        UploadResult uploadResult = cosTencentService.upload(imageBucketName,file,10 * 1024 * 1024);

        AjaxResult ajax = AjaxResult.success();
        ajax.put("url", uploadResult.getKey());
        return ajax;
    }

    /**
     * 获取图片下载路径
     * @return
     */
    @ResponseBody
    @RequestMapping("/cos/tencent/imgDownPath")
    AjaxResult imgDownPath(){
        String down = cosTencentService.getDownPath(imageBucketName);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("down", down);
        return ajax;
    }
}
