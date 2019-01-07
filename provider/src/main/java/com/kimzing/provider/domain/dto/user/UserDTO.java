package com.kimzing.provider.domain.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * UserDTO数据传输对象.
 *
 * @author KimZing - kimzing@163.com
 * @since 2018-08-07 02:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "UserDTO对象", description = "用户信息")
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "生日")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime birth;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "账户状态")
    private Boolean locked;

    @ApiModelProperty(value = "锁版本")
    private Integer version;

    @ApiModelProperty(hidden = true, value = "逻辑删除")
    private Integer deleteFlag;

    @ApiModelProperty(hidden = true, value = "创建人")
    private String createBy;

    @ApiModelProperty(hidden = true, value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createTime;

    @ApiModelProperty(hidden = true, value = "操作人")
    private String updateBy;

    @ApiModelProperty(hidden = true, value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updateTime;


}
