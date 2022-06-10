package org.mcloud.common.api;

import java.io.Serializable;

/**
 * @author wzc
 * @date 2022/06/09
 */
public interface IResultCode extends Serializable {
    String getMessage();

    int getCode();
}
