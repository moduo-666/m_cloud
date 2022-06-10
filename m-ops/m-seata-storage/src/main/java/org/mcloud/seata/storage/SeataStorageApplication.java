package org.mcloud.seata.storage;

import org.mcloud.common.constant.AppConstant;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Storage库存服务启动器
 *
 * @author wzc
 */
@SpringBootApplication
@MapperScan("org.mcloud.seata.storage.mapper")
@EnableFeignClients(AppConstant.BASE_PACKAGES)
public class SeataStorageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeataStorageApplication.class,args);
		// CommonApplication.run("m-seata-storage",SeataStorageApplication.class,args);
	}

}

