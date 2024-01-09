package com.jjou.domain;

import lombok.Data;

import java.util.Date;

/**
 * Description:
 *
 * @Author ojj
 * @Create 2023/12/27 9:50
 * @Version 1.0
 */
@Data
public class QuestionAndAnswer {

    private Long id;
    private String firstContent;
    private String secondContent;
    private String thirdContent;
    private String fourthContent;
    private String fifthContent;
    private String keyword;
    private String title;
    private String answer;
    private Date knowledgeValidity;
    private String source;
    private String question;
    private String serviceCode;
    private String serviceName;
    private String createBy;
    private Date createTime;
    private String updateBy;
    private Date updateTime;
    private String remark;
    private String delFlag;

}
