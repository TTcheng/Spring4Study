package com.wangchuncheng.aop.basexml;

import org.springframework.stereotype.Component;

public class ArithmeticCalculatorImpl implements ArithmeticCalculator {
    public int add(int i, int j) {
        int result=i+j;
        return result;
    }

    public int sub(int i, int j) {
        int result=i-j;
        return result;
    }

    public int mul(int i, int j) {
        int result=i*j;
        return result;
    }

    public int div(int i, int j) {
        int result=i/j;
        return result;
    }
}
