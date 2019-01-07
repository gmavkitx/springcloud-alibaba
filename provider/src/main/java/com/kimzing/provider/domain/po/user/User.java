package com.kimzing.provider.domain.po.user;

import com.baomidou.mybatisplus.annotation.*;
import com.kimzing.provider.domain.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * User存储实体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2018-08-07 02:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 余额
     */
    private BigDecimal balance;

    /**
     * 生日
     */
    private LocalDateTime birth;

    /**
     * 性别
     */
    private GenderEnum gender;

    /**
     * 账户状态
     */
    private Boolean locked;

    /**
     * 锁版本
     */
    @Version
    private Integer version;

    /**
     * 逻辑删除
     */
    @TableField("delete_flag")
    @TableLogic
    private Integer deleteFlag;

    /**
     * 创建人
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 操作人
     */
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;


}
