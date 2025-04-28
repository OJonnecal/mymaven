/*
 *
 * date： 2018-07-23 16:51:18.972
 * author:badousoft
 */
package com.jjou.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 *	ProjectInfo类
 *
 * Copyright 2014 Company Name, badousoft
 * @author badousoft
 * @created 2018-07-23 16:51:18.972
 * @version v1.0
 * @revision
 */
@Entity
@Data
public class ProjectInfoEntity{

    @Id
    @Column(name = "ID", unique = true, nullable = false, insertable = true, updatable = true)
    private String id;

	/**
     *
     */
	@Column(name = "project_param_file", unique = false, nullable = true, insertable = true, updatable = true)
    protected String projectParamFile;
	/**
     *
     */
	@Column(name = "tender_type", unique = false, nullable = true, insertable = true, updatable = true)
    protected String tenderType;
	/**
     *
     */
	@Column(name = "project_package_num", unique = false, nullable = true, insertable = true, updatable = true)
    protected String projectPackageNum;
	/**
     *
     */
	@Column(name = "importance", unique = false, nullable = true, insertable = true, updatable = true)
    protected String importance;
	/**
     *
     */
	@Column(name = "tender_date", unique = false, nullable = true, insertable = true, updatable = true)
    protected Date tenderDate;
	/**
     *
     */
	@Column(name = "project_status", unique = false, nullable = true, insertable = true, updatable = true)
    protected String projectStatus;
	/**
     *
     */
	@Column(name = "system_code", unique = false, nullable = true, insertable = true, updatable = true)
    protected String systemCode;
	/**
     *
     */
	@Column(name = "remark", unique = false, nullable = true, insertable = true, updatable = true)
    protected String remark;
	/**
     *
     */
	@Column(name = "project_name", unique = false, nullable = true, insertable = true, updatable = true)
    protected String projectName;
	/**
     *
     */
	@Column(name = "project_category", unique = false, nullable = true, insertable = true, updatable = true)
    protected String projectCategory;
	/**
     *
     */
	@Column(name = "construct_km", unique = false, nullable = true, insertable = true, updatable = true)
    protected Float constructKm;
	/**
     *
     */
	@Column(name = "admin_phone_number", unique = false, nullable = true, insertable = true, updatable = true)
    protected String adminPhoneNumber;
	/**
     *
     */
	@Column(name = "project_admin_id", unique = false, nullable = true, insertable = true, updatable = true)
    protected String projectAdminId;
	/**
     *
     */
	@Column(name = "plan_num", unique = false, nullable = true, insertable = true, updatable = true)
    protected String planNum;
	/**
     *
     */
	@Column(name = "construct_unit_name", unique = false, nullable = true, insertable = true, updatable = true)
    protected String constructUnitName;
	/**
     *
     */
	@Column(name = "belong_org_code", unique = false, nullable = true, insertable = true, updatable = true)
    protected String belongOrgCode;
	/**
     *
     */
	@Column(name = "erp_system_status", unique = false, nullable = true, insertable = true, updatable = true)
    protected String erpSystemStatus;
	/**
     *
     */
	@Column(name = "org_name", unique = false, nullable = true, insertable = true, updatable = true)
    protected String orgName;
	/**
     *
     */
	@Column(name = "project_type_code", unique = false, nullable = true, insertable = true, updatable = true)
    protected String projectTypeCode;
	/**
     *
     */
	@Column(name = "project_param_file_code", unique = false, nullable = true, insertable = true, updatable = true)
    protected String projectParamFileCode;
	/**
     *
     */
	@Column(name = "estimated_price", unique = false, nullable = true, insertable = true, updatable = true)
    protected Float estimatedPrice;
	/**
     *
     */
	@Column(name = "project_year", unique = false, nullable = true, insertable = true, updatable = true)
    protected Integer projectYear;
	/**
     *
     */
	@Column(name = "project_type", unique = false, nullable = true, insertable = true, updatable = true)
    protected String projectType;
	/**
     *
     */
	@Column(name = "project_scale", unique = false, nullable = true, insertable = true, updatable = true)
    protected String projectScale;
	/**
     *
     */
	@Column(name = "project_admin", unique = false, nullable = true, insertable = true, updatable = true)
    protected String projectAdmin;
	/**
     *
     */
	@Column(name = "company_id", unique = false, nullable = true, insertable = true, updatable = true)
    protected String companyId;
	/**
     *
     */
	@Column(name = "extend_item", unique = false, nullable = true, insertable = true, updatable = true)
    protected String extendItem;
	/**
     *
     */
	@Column(name = "win_bid_price", unique = false, nullable = true, insertable = true, updatable = true)
    protected Float winBidPrice;
	/**
     *
     */
	@Column(name = "erp_system_code", unique = false, nullable = true, insertable = true, updatable = true)
    protected String erpSystemCode;
	/**
     *
     */
	@Column(name = "project_code", unique = false, nullable = true, insertable = true, updatable = true)
    protected String projectCode;
	/**
     *
     */
	@Column(name = "press_h", unique = false, nullable = true, insertable = true, updatable = true)
    protected Float pressH;
	/**
     *
     */
	@Column(name = "extend_num", unique = false, nullable = true, insertable = true, updatable = true)
    protected String extendNum;
	/**
     *
     */
	@Column(name = "project_location", unique = false, nullable = true, insertable = true, updatable = true)
    protected String projectLocation;
	/**
     *
     */
	@Column(name = "construct_unit_id", unique = false, nullable = true, insertable = true, updatable = true)
    protected String constructUnitId;
	/**
     *
     */
	@Column(name = "finish_km", unique = false, nullable = true, insertable = true, updatable = true)
    protected Float finishKm;
	/**
     *
     */
	@Column(name = "creater_name", unique = false, nullable = true, insertable = true, updatable = true)
    protected String createrName;
	/**
     *
     */
	@Column(name = "investor", unique = false, nullable = true, insertable = true, updatable = true)
    protected String investor;
	/**
     *
     */
	@Column(name = "system_status", unique = false, nullable = true, insertable = true, updatable = true)
    protected String systemStatus;
	/**
     *
     */
	@Column(name = "org_id", unique = false, nullable = true, insertable = true, updatable = true)
    protected String orgId;
	/**
     *
     */
	@Column(name = "press_m", unique = false, nullable = true, insertable = true, updatable = true)
    protected Float pressM;
	/**
     *
     */
	@Column(name = "company_name", unique = false, nullable = true, insertable = true, updatable = true)
    protected String companyName;
	/**
     *
     */
	@Column(name = "press_l", unique = false, nullable = true, insertable = true, updatable = true)
    protected Float pressL;
	/**
     *
     */
	@Column(name = "creater", unique = false, nullable = true, insertable = true, updatable = true)
    protected String creater;
	/**
     *
     */
	@Column(name = "drawing_num", unique = false, nullable = true, insertable = true, updatable = true)
    protected String drawingNum;
	/**
     *
     */
	@Column(name = "org_code", unique = false, nullable = true, insertable = true, updatable = true)
    protected String orgCode;
	/**
     *
     */
	@Column(name = "project_category_code", unique = false, nullable = true, insertable = true, updatable = true)
    protected String projectCategoryCode;
	/**
     *
     */
	@Column(name = "plan_type", unique = false, nullable = true, insertable = true, updatable = true)
    protected String planType;
	/**
     *
     */
	@Column(name = "modeltype", unique = false, nullable = true, insertable = true, updatable = true)
    protected String modelType;
    /**
     *
     */
	@Column(name = "budget_total_money", unique = false, nullable = true, insertable = true, updatable = true)
    protected Float budgetTotalMoney;
	/**
     * WBS预算总金额
     */
	@Column(name = "wbsbudget_total_money", unique = false, nullable = true, insertable = true, updatable = true)
    protected Float wbsBudgetTotalMoney;

	/**
     * 工程编号流水号
     */
	@Column(name = "GCBHLSH", unique = false, nullable = true, insertable = true, updatable = true)
    protected String gcbhlsh;

	/**
     * 覆盖户数
     */
	@Column(name = "COVERING_NUMBER", unique = false, nullable = true, insertable = true, updatable = true)
    protected String coveringNumber;
	/**
     * 表规格
     */
	@Column(name = "TABLE_SIZE", unique = false, nullable = true, insertable = true, updatable = true)
    protected String tableSize;
	/**
     * 用户发展员id
     */
	@Column(name = "USER_DEVELOPER", unique = false, nullable = true, insertable = true, updatable = true)
    protected String userDeveloper;
	/**
     * 用户发展员
     */
	@Column(name = "USER_DEVELOPER_NAME", unique = false, nullable = true, insertable = true, updatable = true)
    protected String userDeveloperName;
	/**
     * 用户发展员电话
     */
	@Column(name = "USER_DEVELOPER_PHONE", unique = false, nullable = true, insertable = true, updatable = true)
    protected String userDeveloperPhone;
	/**
     * 是否参与统计
     */
	@Column(name = "IS_STATISTIC", unique = false, nullable = true, insertable = true, updatable = true)
    protected String isStatistic;
	/**
     * 项目年度
     */
	@Column(name = "PROJECTYEAR_TYPE", unique = false, nullable = true, insertable = true, updatable = true)
    protected String projectyearType;
	/**
     * 是否允许修改
     */
	@Column(name = "IS_ALLOW_MODIFY", unique = false, nullable = true, insertable = true, updatable = true)
    protected String isAllowModify = "0";
	/**
     * 道路挖掘许可
     */
	@Column(name = "IS_MINING_LICENSE", unique = false, nullable = true, insertable = true, updatable = true)
    protected String isMiningLicense = "0";
	/**
     * 完成许可时间
     */
	@Column(name = "FINISH_LICENSE_DATE", unique = false, nullable = true, insertable = true, updatable = true)
    protected Date finishLicenseDate;

    /**
     * 施工单位是否在片区内
     */
    @Column(name = "UNIT_IN_THE_AREA", unique = false, nullable = true, insertable = true, updatable = true)
    protected String unitInTheArea;


    /**
     * 公司投资项目（红线外工程）立项估算（万元）
     */
    @Column(name = "project_estimation", unique = false, nullable = true, insertable = true, updatable = true)
    protected Float projectEstimation;


    /**
     * 扩展项计划流水号
     */
    @Column(name = "extend_plan_num", unique = false, nullable = true, insertable = true, updatable = true)
    protected String extendPlanNum;


    /**
     * 修改后的标识
     * "0"表示未经修改,“1”表示已经修改。
     * 默认值为“0”。
     * @return
     */
    @Column(name = "FLAG_ORG_NAME", unique = false, nullable = true, insertable = true, updatable = true)
    protected String flagOrgName= "0";

    /**
     * 是否需要报监检（0否 1是）
     */
    @Column(name = "REPORT_FLAG", unique = false, nullable = true, insertable = true, updatable = true)
    protected String reportFlag;

    /**
     * 是否已报监检（0否 1是）
     */
    @Column(name = "IS_REPORT", unique = false, nullable = true, insertable = true, updatable = true)
    protected String isReport;

    /**
     * 是否有下达整改通知（0否 1是）
     */
    @Column(name = "ISSUE_FLAG", unique = false, nullable = true, insertable = true, updatable = true)
    protected String issueFlag;

    /**
     * 第一次回复整改时间
     */
    @Column(name = "REPLY_FIRST_TIME", unique = false, nullable = true, insertable = true, updatable = true)
    protected Date replyFirstTime;

    /**
     * 第二次回复整改时间
     */
    @Column(name = "REPLY_SECOND_TIME", unique = false, nullable = true, insertable = true, updatable = true)
    protected Date replySecondTime;

    /**
     * 第三次回复整改时间
     */
    @Column(name = "REPLY_THIRD_TIME", unique = false, nullable = true, insertable = true, updatable = true)
    protected Date replyThirdTime;

    /**
     * 第四次回复整改时间
     */
    @Column(name = "REPLY_FOURTH_TIME", unique = false, nullable = true, insertable = true, updatable = true)
    protected Date replyFourthTime;

    /**
     * 报送承压院竣工资料时间
     */
    @Column(name = "COMPLETE_TIME", unique = false, nullable = true, insertable = true, updatable = true)
    protected Date completeTime;

    /**
     * 出具监检报告时间
     */
    @Column(name = "REPORT_TIME", unique = false, nullable = true, insertable = true, updatable = true)
    protected Date reportTime;

    /**
     * 开工日期
     */
    @Column(name = "BEGIN_DATE", unique = false, nullable = true, insertable = true, updatable = true)
    protected Date beginDate;

    /**
     * 完工日期
     */
    @Column(name = "END_DATE", unique = false, nullable = true, insertable = true, updatable = true)
    protected Date endDate;

    /**
     * 交工验收日期(实体验收)
     */
    @Column(name = "BEGIN_CHECK_DATE", unique = false, nullable = true, insertable = true, updatable = true)
    protected Date beginCheckDate;

    /**
     * 竣工验收日期
     */
    @Column(name = "END_CHECK_DATE", unique = false, nullable = true, insertable = true, updatable = true)
    protected Date endCheckDate;

    /**
     * 完成规划条件核实日期
     */
    @Column(name = "PLAN_DATE", unique = false, nullable = true, insertable = true, updatable = true)
    protected Date planDate;

    /**
     * 完成竣工资料移交日期
     */
    @Column(name = "COMPLETE_DATE", unique = false, nullable = true, insertable = true, updatable = true)
    protected Date completeDate;

    /**
     * 完成结算审批日期
     */
    @Column(name = "SETTLEMENT_DATE", unique = false, nullable = true, insertable = true, updatable = true)
    protected Date settlementDate;

    /**
     * 结算金额
     */
    @Column(name = "AMOUNT", precision = 16, scale = 2, unique = false, nullable = true, insertable = true, updatable = true)
    protected BigDecimal amount;


}




