package org.mcloud.seata.order.feign;

import org.mcloud.common.constant.AppConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * StorageClient
 *
 * @author wzc
 */
@FeignClient(name = AppConstant.MCLOUD_SEATA_STORAGE, fallback = StorageClientFallback.class)
public interface IStorageClient {

	/**
	 * 减库存
	 *
	 * @param commodityCode 商品代码
	 * @param count         数量
	 * @return boolean
	 */
	@GetMapping("/storage/deduct")
	int deduct(@RequestParam("commodityCode") String commodityCode, @RequestParam("count") Integer count);

}
