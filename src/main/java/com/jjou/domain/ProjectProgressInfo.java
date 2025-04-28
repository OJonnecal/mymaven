package com.jjou.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Description:
 *
 * @Author ojj
 * @Date 2025-03-18 15:19
 * @Version 1.0
 */
@Data
@Entity
public class ProjectProgressInfo {
    @Id
    @Column(name = "ID", nullable = false, length = 64)
    private String id;

    @Column(name = "PROJECT_ID", length = 64)
    private String projectId;

    @Column(name = "BEGIN_DATE")
    private Date beginDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "BEGIN_CHECK_DATE")
    private Date beginCheckDate;

    @Column(name = "END_CHECK_DATE")
    private Date endCheckDate;

    @Column(name = "PLAN_DATE")
    private Date planDate;

    @Column(name = "COMPLETE_DATE")
    private Date completeDate;

    @Column(name = "SETTLEMENT_DATE")
    private Date settlementDate;

    @Column(name = "AMOUNT", precision = 16, scale = 2)
    private BigDecimal amount;

    @Column(name = "REMARK", length = 516)
    private String remark;

    @Column(name = "CREATOR", length = 32)
    private String creator;

    @Column(name = "CREATOR_NAME", length = 128)
    private String creatorName;

    @Column(name = "CREATE_TIME")
    private Date createTime;
}
