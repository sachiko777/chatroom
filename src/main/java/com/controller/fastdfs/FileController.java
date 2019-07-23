package com.controller.fastdfs;

import com.utils.FastDFSClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileController {

    @RequestMapping(value = "uploadfile",method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(@RequestParam MultipartFile uploadfile) throws IOException {
        String fileId= FastDFSClient.uploadFile(uploadfile.getInputStream(),uploadfile.getOriginalFilename());
        if(fileId!=null&& !fileId.equals("")){
            System.out.println("上传文件成功！");
        }
//        return fileId+"---"+uploadfile.getOriginalFilename();
        return fileId;
    }




}
