package org.mcloud.seata.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.AllArgsConstructor;
import org.mcloud.seata.order.entity.Order;
import org.mcloud.seata.order.feign.IStorageClient;
import org.mcloud.seata.order.mapper.OrderMapper;
import org.mcloud.seata.order.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * OrderServiceImpl
 *
 * @author Chill
 */
@Service
@AllArgsConstructor
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

	private IStorageClient storageClient;

	@Override
	@GlobalTransactional
	// @Transactional(rollbackFor = Exception.class)
	public boolean createOrder(String userId, String commodityCode, Integer count) {
		int maxCount = 100;
		BigDecimal orderMoney = new BigDecimal(count).multiply(new BigDecimal(5));
		Order order = new Order()
			.setUserId(userId)
			.setCommodityCode(commodityCode)
			.setCount(count)
			.setMoney(orderMoney);
		int cnt1 = baseMapper.insert(order);
		int cnt2 = storageClient.deduct(commodityCode, count);
		if (cnt2 < 0) {
			throw new RuntimeException("创建订单失败");
		} else if (count > maxCount) {
			throw new RuntimeException("超过订单最大值，创建订单失败");
		}
		return cnt1 > 0 && cnt2 > 0;
	}

}
