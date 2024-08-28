package com.jjou.domain;


import lombok.Data;

import java.util.Date;

/**
 * 检查设备管理对象 inspect_equipment
 *
 * @author luo
 * @date 2023-10-08
 */
@Data
public class InspectEquipment{
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 设备名称
     */
    private String equipmentName;

    /**
     * 有效期(天)
     */
    private Long inDate;

    /**
     * 过期提醒(天)
     */
    private Long expirationDay;

    /**
     * 检查周期
     */
    private Integer inspectCycle;

    /**
     * 检查时间日
     */
    private Integer inspectDate;

    /**
     * 复核
     */
    private Integer checkFlag;

    /**
     * 附件
     */
    private String attachmentUrl;

    /**
     * 逻辑删除
     */
    private Integer delFlag;

    /**
     * 搜索值
     */
    private String searchValue;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

}
