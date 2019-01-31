package com.zym.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomProperties {

    @Value("${com.random.value}")
    private String randomStr;

    @Value("${com.random.number}")
    private int randomInt;

    @Value("${com.random.bignumber}")
    private long randLong;

    @Value("${com.random.test1}")
    private int randRange1;

    @Value("${com.random.test2}")
    private int randRange2;

    public String getRandomStr() {
        return randomStr;
    }

    public void setRandomStr(String randomStr) {
        this.randomStr = randomStr;
    }

    public int getRandomInt() {
        return randomInt;
    }

    public void setRandomInt(int randomInt) {
        this.randomInt = randomInt;
    }

    public long getRandLong() {
        return randLong;
    }

    public void setRandLong(long randLong) {
        this.randLong = randLong;
    }

    public int getRandRange1() {
        return randRange1;
    }

    public void setRandRange1(int randRange1) {
        this.randRange1 = randRange1;
    }

    public int getRandRange2() {
        return randRange2;
    }

    public void setRandRange2(int randRange2) {
        this.randRange2 = randRange2;
    }
}
