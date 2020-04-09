package com.chenmt.attachment.dao;

import com.chenmt.attachment.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program springdatajpa
 * @description: dao
 * @author: chenmet
 * @create: 2018/12/10 10:36
 */
public interface AttachmentDao extends JpaRepository<Attachment, Long> {

}
