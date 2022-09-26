package com.lml.service;

import com.lml.entity.Payment;

import java.util.List;

/**
 * @author 35541
 */
public interface PaymentService {
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
