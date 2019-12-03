package com.company;

public class Main {

    public static void main(String[] args) {
	AtomicClock atomicClock=new AtomicClock();
	TimeKeeper timeKeeper=new TimeKeeper();
	TimeCounter timeCounter=new TimeCounter();
	atomicClock.registerObserver(timeCounter);
	atomicClock.registerObserver(timeKeeper);
	atomicClock.start();
    }
}
