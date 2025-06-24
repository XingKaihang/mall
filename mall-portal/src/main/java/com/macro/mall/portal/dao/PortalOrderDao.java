package com.macro.mall.portal.dao;

import com.macro.mall.model.OmsOrderItem;
import com.macro.mall.portal.domain.OmsOrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 前台订单管理自定义Dao
 * Created by macro on 2018/9/4.
 */
public interface PortalOrderDao {
    /**
     * 获取订单及下单商品详情
     */
    OmsOrderDetail getDetail(@Param("orderId") Long orderId);

    /**
     * 修改 pms_sku_stock表的锁定库存及真实库存
     */
    int updateSkuStock(@Param("itemList") List<OmsOrderItem> orderItemList);

    /**
     * 获取超时订单
     * @param minute 超时时间（分）
     */
    List<OmsOrderDetail> getTimeOutOrders(@Param("minute") Integer minute);

    /**
     * 批量修改订单状态
     */
    int updateOrderStatus(@Param("ids") List<Long> ids,@Param("status") Integer status);

    /**
 * Releases locked stock for canceled orders based on the provided list of order items.
 *
 * @param orderItemList the list of order items for which to release locked stock
 * @return the number of affected rows
 */
    int releaseSkuStockLock(@Param("itemList") List<OmsOrderItem> orderItemList);

    /**
 * Locks a specified quantity of stock for a product SKU identified by its SKU ID.
 *
 * @param productSkuId the ID of the product SKU to lock stock for
 * @param quantity the quantity of stock to lock
 * @return the number of records updated in the stock table
 */
    int lockStockBySkuId(@Param("productSkuId")Long productSkuId,@Param("quantity") Integer quantity);

    /**
 * Decreases the actual stock quantity for a specified product SKU.
 *
 * @param productSkuId the ID of the product SKU whose stock will be reduced
 * @param quantity the number of units to deduct from the actual stock
 * @return the number of rows affected in the stock table
 */
    int reduceSkuStock(@Param("productSkuId")Long productSkuId,@Param("quantity") Integer quantity);

    /**
 * Releases a specified quantity of stock for a product SKU by its SKU ID.
 *
 * @param productSkuId the ID of the product SKU
 * @param quantity the quantity of stock to release
 * @return the number of affected rows
 */
    int releaseStockBySkuId(@Param("productSkuId")Long productSkuId,@Param("quantity") Integer quantity);
}
