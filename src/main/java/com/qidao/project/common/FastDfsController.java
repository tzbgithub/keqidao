package com.qidao.project.common;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.upload.FastFile;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.qidao.framework.web.domain.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Controller
public class FastDfsController {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    @Value("${fdfs.down}")
    private String downPath;

    /**
     * fastdfs 图片上传
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/fdfs/upload")
    @ResponseBody
    public AjaxResult uploadFile(MultipartFile file) throws Exception {
        try {
            String originalFilename = file.getOriginalFilename();

            FastFile fastFile = new FastFile.Builder()
                    .withFile(file.getInputStream(),file.getSize(),originalFilename)
                    .build();

            StorePath storePath = fastFileStorageClient.uploadFile(fastFile);
            String fullUrl = downPath + storePath.getFullPath();
            String url = storePath.getFullPath();
            AjaxResult ajax = AjaxResult.success();
            ajax.put("url", url);
            ajax.put("fullUrl", fullUrl);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping("/fdfs/queryDownPath")
    public AjaxResult queryDownPath(){
        AjaxResult ajax = AjaxResult.success();
        ajax.put("down", downPath);
        return ajax;
    }
}
