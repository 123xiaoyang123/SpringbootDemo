package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
/*
*文件上传controller
* */
@Controller
public class FileUploadController {

    @RequestMapping("toFile")
    public String file() {
        return "fileUpload";
    }

    @RequestMapping("multiFile")
    public String multiFile() {
        return "multiFile";
    }

    @RequestMapping("file")
    public String fileDown(@RequestParam("fileName") MultipartFile file) {
        if (file.isEmpty()) {
            return "false";
        }
        String fileName = file.getOriginalFilename();
        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);
        String path = "E:\\";
        File dest = new File(path + "\\" + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);//保存文件
            return "true";
        } catch (IOException e) {
            e.printStackTrace();
            return "false";
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "false";
        }
    }

    @RequestMapping("multiFileUpload")
    public String multiFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("fileName");
        if (file().isEmpty()) {
            return "false";
        }

        String path = "E:\\";
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            int size = (int) file.getSize();
            System.out.println(fileName + "-->" + size);

             if (file.isEmpty()){
                 return "false";
             }else {
                 File dest = new File(path + "\\" + fileName);
                 if (!dest.getParentFile().exists()) {
                     dest.getParentFile().mkdir();
                 }
                 try {
                     file.transferTo(dest);//保存文件
                     return "true";
                 } catch (IOException e) {
                     e.printStackTrace();
                     return "false";
                 } catch (IllegalStateException e) {
                     e.printStackTrace();
                     return "false";
                 }
             }
        }
        return "false";
    }
}
