package com.lml.mapper;

import com.lml.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 35541
 */
@Mapper
public interface PaymentDao {
    /**
     *  添加付款
     * @param payment
     * @return
     */
    int addPayment(Payment payment);

    /**
     * 查询所有的付款信息
     * @return
     */
    List<Payment> queryPayments();

    /**
     * 根据ID查询付款信息
     * @param id
     * @return
     */
    Payment queryPayment(Long id);
}
