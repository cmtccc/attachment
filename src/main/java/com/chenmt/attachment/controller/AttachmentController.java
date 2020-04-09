package com.chenmt.attachment.controller;

import com.chenmt.attachment.model.Attachment;
import com.chenmt.attachment.response.BaseResponse;
import com.chenmt.attachment.service.AttachmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @program springdatajpa
 * @description:
 * @author: chenmet
 * @create: 2018/12/10 10:43
 */
@RestController
@Api(tags = "文件操作")
@Slf4j
@RequestMapping("attachment")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @ApiOperation("文件保存")
    @PostMapping("addFiles")
    public BaseResponse<List<Attachment>> addFiles(@RequestParam("urls") String urls) {
        log.info("上传内容：{}",urls);
        if("".equals(urls.trim())){
            return BaseResponse.error();
        }
        String[] urlList=urls.split(",");
        List<Attachment> attachmentList=new ArrayList<>();
        for(String url:urlList){
            log.info("文件url：{}",url);
            Attachment attachment=new Attachment();

            attachment.setUrl(url);

            attachment.setAttachmentName(url.substring(url.lastIndexOf("/")+1));

            String type=url.substring(url.lastIndexOf(".")+1);

            if(type.equals("jpg")||type.equals("jpeg")||type.equals("png")){
                attachment.setType(0);
            }else if(type.equals("mp4")){
                attachment.setType(1);
            }else if(type.equals("mp3")){
                attachment.setType(2);
            }else {
                attachment.setType(3);
            }
            attachmentService.save(attachment);
            attachmentList.add(attachment);
        }
        return BaseResponse.success(attachmentList,"上传成功");
    }


    @ApiOperation("文件保存")
    @GetMapping("findAll")
    public BaseResponse<List<Attachment>> findAll(){
        List<Attachment> attachmentList=attachmentService.getAttachmentList();
        return BaseResponse.success(attachmentList);
    }

    @ApiOperation("文件删除")
    @PostMapping("del")
    public BaseResponse<List<Attachment>> del(@RequestParam("id") Long id){
        attachmentService.delete(id);
        return BaseResponse.success();
    }

}
