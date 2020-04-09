package com.chenmt.attachment.service;

import com.chenmt.attachment.model.Attachment;

import java.util.List;

/**
 * @program springdatajpa
 * @description: 用户业务
 * @author: chenmet
 * @create: 2018/12/10 10:28
 */
public interface AttachmentService {

    List<Attachment> getAttachmentList();

    Attachment findUserById(long id);

    void save(Attachment attachment);

    void edit(Attachment attachment);

    void delete(long id);

}
