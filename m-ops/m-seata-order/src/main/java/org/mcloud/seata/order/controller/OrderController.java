package org.mcloud.seata.order.controller;

import lombok.AllArgsConstructor;
import org.mcloud.common.api.R;
import org.mcloud.seata.order.service.IOrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分布式事务demo  【添加订单 -> 减库存】事务
 *
 * @author wzc
 */
@RestController
@RequestMapping("order")
@AllArgsConstructor
public class OrderController {

	private IOrderService orderService;

	/**
	 * 创建订单
	 *
	 * @param userId        用户id
	 * @param commodityCode 商品代码
	 * @param count         数量
	 * @return boolean
	 */
	@RequestMapping("/create")
	public R createOrder(String userId, String commodityCode, Integer count) {
		return R.status(orderService.createOrder(userId, commodityCode, count));
	}

}
