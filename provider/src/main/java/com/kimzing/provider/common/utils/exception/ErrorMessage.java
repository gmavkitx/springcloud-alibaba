package com.kimzing.provider.common.utils.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 错误信息体.
 *
 * @author KimZing - kimzing@163.com
 * @since 2018-08-07 02:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String message;

}
