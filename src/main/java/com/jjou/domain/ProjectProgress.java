package com.jjou.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Description:
 *
 * @Author ojj
 * @Date 2025-03-18 15:49
 * @Version 1.0
 */
@Data
@Entity
public class ProjectProgress {
    @Id
    @Column(name = "ID", length = 64)
    private String id;
    @Column(name = "PROJECT_ID", length = 64)
    private String projectId;
    @Column(name = "BEFORE_STATUS", length = 64)
    private String beforeStatus;
    @Column(name = "AFTER_STATUS", length = 64)
    private String afterStatus;
    @Column(name = "REMARK", length = 516)
    private String remark;
    @Column(name = "CREATOR", length = 32)
    private String creator;
    @Column(name = "CREATOR_NAME", length = 128)
    private String creatorName;
    @Column(name = "CREATE_TIME")
    private Date createTime;
    @Column(name = "NEXT_DATE")
    private Date nextDate;
}
