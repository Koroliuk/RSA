package com.company;

public class Key {
    private final long firstNum;
    private final long secondNum;

    public Key(final long firstNum, final long secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public long getFirstNum() {
        return firstNum;
    }

    public long getSecondNum() {
        return secondNum;
    }
}