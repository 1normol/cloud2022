package com.lml.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：limaolin
 * @date ：Created in 2022/8/29 9:31
 * @description：支付实体
 * @modified By：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    private Long id;
    private String serial;

}
