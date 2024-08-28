package com.jjou.domain;


import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 资产对象 assets
 *
 * @author luo
 * @date 2024-03-18
 */
@Data
public class Assets{
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 资产编码
     */
    private String assetsCode;

    /**
     * 实物编码
     */
    private String physicalCode;

    /**
     * 关联配置
     */
    private Long inspectId;

    /**
     * 关联配置名称
     */
    private String inspectName;

    /**
     * 类型
     */
    private Integer assetsType;

    /**
     * 类型名称
     */
    private String assetsTypeName;

    /**
     * 名称
     */
    private String assetsName;

    /**
     * 数量
     */
    private int assetsQuantity;

    /**
     * 品牌
     */
    private String assetsBrand;

    /**
     * 购置时间
     */
    private Date acquisitionTime;

    /**
     * 产权单位
     */
    private Long propertyUnit;

    /**
     * 产权单位名称
     */
    private String propertyUnitName;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 使用状态
     */
    private String useStatus;

    /**
     * 购买价格(元)
     */
    private BigDecimal assetsPrice;

    /**
     * 原值(元)
     */
    private BigDecimal assetsOriginPrice;

    /**
     * 规格
     */
    private String assetsSpecification;

    /**
     * 领用部门
     */
    private String dutyDeptName;

    /**
     * 领用人员
     */
    private String dutyUserName;

    /**
     * 领用时间
     */
    private Date claimTime;

    /**
     * 存放地点
     */
    private String storageLocation;

    /**
     * 图片
     */
    private String assetsImageUrl;

    /**
     * 开始使用日期
     */
    private Date beginUseTime;

    /**
     * 使用年限(月份)
     */
    private int useLife;

    /**
     * 增加方式
     */
    private String addWay;

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
