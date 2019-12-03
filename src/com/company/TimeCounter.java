package com.company;

import java.time.LocalTime;

public class TimeCounter implements Observer{
int counter=0;
    @Override
    public void update(LocalTime localTime) {
        counter++;
        System.out.println("You have updated me:"+ counter );
    }
}
