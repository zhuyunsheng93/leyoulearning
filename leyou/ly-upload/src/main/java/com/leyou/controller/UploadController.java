package com.leyou.controller;

import com.leyou.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.lang3.StringUtils;

@RestController
@RequestMapping("upload")
public class UploadController {
    @Autowired
    private UploadService uploadService;

    /**
     * @param file
     * @return
     */
    @PostMapping("image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        String url = this.uploadService.upload(file);
        //判断url，如果为空，则证明上传失败
        if (StringUtils.isBlank(url)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //返回保存图片的路径
        return ResponseEntity.ok(url);
    }
    @GetMapping("getInfo")
    public ResponseEntity<String> getInfo(){
        return ResponseEntity.ok("你好");
    }
}
