package com.misstouch.urlencode.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hechao
 * @date create in 17:51 2019/5/11/011
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private String errorCode;

    private String errorMsg;

    private T data;

}
