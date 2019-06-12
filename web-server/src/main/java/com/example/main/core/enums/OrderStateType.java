package com.example.main.core.enums;

/**
 * 订单状态
 */
public enum OrderStateType {
    PAID(0),            //已支付
    ALREADY_REFUND(1),  //已取消
    NOT_PAY(2);         //未支付

    private int value;

    OrderStateType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
