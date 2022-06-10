package org.mcloud.common.launch;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.Ordered;

/**
 * 公共配置接口
 *
 * @author wzc
 * @date 2022/06/09
 */
public interface LauncherService extends Ordered, Comparable<LauncherService> {

    void launcher(SpringApplicationBuilder builder, String appName, String profile);
    @Override
    default int getOrder() {
        return -2147483648;
    }
    @Override
    default int compareTo(LauncherService o) {
        return Integer.compare(this.getOrder(), o.getOrder());
    }
}
