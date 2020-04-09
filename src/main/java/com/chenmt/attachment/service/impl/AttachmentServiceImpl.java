package com.chenmt.attachment.service.impl;

import com.chenmt.attachment.dao.AttachmentDao;
import com.chenmt.attachment.model.Attachment;
import com.chenmt.attachment.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program springdatajpa
 * @description:
 * @author: chenmet
 * @create: 2018/12/10 10:39
 */
@Service
public class AttachmentServiceImpl implements AttachmentService {


    @Autowired
    private AttachmentDao attachmentDao;

    @Override
    public List<Attachment> getAttachmentList() {
        return attachmentDao.findAll();
    }

    @Override
    public Attachment findUserById(long id) {
        return attachmentDao.getOne(id);
    }

    @Override
    public void save(Attachment attachment) {
        attachmentDao.save(attachment);
    }

    @Override
    public void edit(Attachment attachment) {
        attachmentDao.save(attachment);
    }

    @Override
    public void delete(long id) {
        attachmentDao.delete(findUserById(id));
    }

}
