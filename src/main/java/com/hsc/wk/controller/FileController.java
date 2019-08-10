package com.hsc.wk.controller;

import com.hsc.wk.model.ComResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api")
public class FileController {

    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public ComResult uploadFile(HttpServletRequest request, @RequestParam("file") MultipartFile file) {

        try {
            String uploadDir = System.getProperty("user.dir");
            String pathUrl = uploadDir + System.getProperty("file.separator") + "uploadFile"+System.getProperty("file.separator");
            log.info("upload path = {}", pathUrl);

            File dir = new File(pathUrl);
            if (!dir.exists()) {
                dir.mkdir();
            }
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String fileName = UUID.randomUUID() + suffix;
            log.info("fileName  = {}", fileName);
            log.info("serverFile path = {}", pathUrl+fileName);
            File serverFile = new File(pathUrl + fileName);
            file.transferTo(serverFile);
        }catch (Exception e){
            log.info("Exception = {}",e);

            return ComResult.errorOf(400,e.toString(),"");
        }
        return ComResult.sucessOf("");
    }

}
