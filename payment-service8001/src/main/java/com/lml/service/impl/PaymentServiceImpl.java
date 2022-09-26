package com.lml.service.impl;

import com.lml.entity.Payment;
import com.lml.mapper.PaymentDao;
import com.lml.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：limaolin
 * @date ：Created in 2022/8/29 14:39
 * @description：付款服务实现类
 * @modified By：
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int addPayment(Payment payment) {
        return paymentDao.addPayment(payment);
    }

    @Override
    public List<Payment> queryPayments() {
        return paymentDao.queryPayments();
    }

    @Override
    public Payment queryPayment(Long id) {
        return paymentDao.queryPayment(id);
    }
}
