package com.company;

import java.time.LocalTime;

public class TimeKeeper implements Observer {

    @Override
    public void update(LocalTime localTime) {
        System.out.println("Thx for update, now is :"+localTime);
    }
}
