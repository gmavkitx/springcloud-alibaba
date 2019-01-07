package com.kimzing.provider.domain.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

import java.io.Serializable;

/**
 * 性别枚举类.
 *
 * @author KimZing - kimzing@163.com
 * @since 2018-08-07 02:02
 */
public enum GenderEnum implements IEnum {
    //女
    WOMAN(0, "女"),
    //男
    MAN(1, "男");

    private Integer code;

    private String desc;

    GenderEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 使用该方法的返回值存库，可以自定义返回值。个人推荐使用name(),使用wrapper查询时比较方便
     */
    @Override
    public Serializable getValue() {
        return this.name();
    }
}
