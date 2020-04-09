package com.chenmt.attachment.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @program springdatajpa
 * @description: 用户实体类
 * @author: chenmet
 * @create: 2018/12/10 10:24
 */
@Entity
@Table(name = "attachment")
@Data
public class Attachment {

    @Id
    @GeneratedValue
    private Long id;  //主键id

    @Column(nullable = false)
    private String url; //附件url

    @Column(nullable = false)
    private Date createTime=new Date(); //创建时间

    @Column(nullable = false)
    private String attachmentName;  //附件名

    @Column(nullable = false)
    private int type;//类型 0 图片 1 视频 2 音频 3 其他
}
