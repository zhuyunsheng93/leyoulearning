package com.leyou.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.List;

@Service
public class UploadService {
    private static final Logger logger = LoggerFactory.getLogger(UploadService.class);
    //set type of image which can upload
    private static final List<String> suffixs = Arrays.asList("image/png", "image/jpg","image/jpeg");

    public String upload(MultipartFile file) {
        try {
            String type = file.getContentType();
            // check the type of file
            if (!suffixs.contains(type)) {
                logger.info("上传文件失败，文件类型不匹配{}", type);
                return null;
            }
            //check the content of file
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null) {
                logger.info("上传失败，文件内容不符合要求");
                return null;
            }
            //save the file
            //create the dir
            File dir = new File("D:\\leyou\\upload");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            file.transferTo(new File(dir, file.getOriginalFilename()));
            String url = "http://image.leyou.com/upload/" + file.getOriginalFilename();
            logger.info(url);
            return url;
        } catch (Exception e) {
            return null;
        }

    }
}
