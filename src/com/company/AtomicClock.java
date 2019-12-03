package com.company;

import java.time.LocalTime;
import java.util.ArrayList;

public class AtomicClock implements Runnable,Observable {
    private Thread worker;
    protected volatile boolean isRunning=false;
    private int interval;
    private LocalTime localTime;
    private ArrayList<Observer> observerArrayList=new ArrayList<>();

    public AtomicClock(){
        interval=2000;
    }

    public void start (){
        worker = new Thread(this,"Clock thread");
        worker.start();
        System.out.println("Creating new thread");
//        observerArrayList=new ArrayList<>();
    }
    public void stop(){
        isRunning=false;
    }
    public void interupt(){
        isRunning=false;
        worker.interrupt();
    }

    @Override
    public void run() {
        isRunning=true;
        while (isRunning){
//            localTime=LocalTime.now();
//            System.out.println("updating time"+ localTime);
            System.out.println("Updating");
            updateObservers();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void registerObserver(Observer observer) {
        if(!observerArrayList.contains(observer)){
            observerArrayList.add(observer);
            System.out.println(observer+" connected to atomic clock");
        }
    }

    @Override
    public void deleteObserver(Observer observer) {
if(observerArrayList.contains(observer))
    observerArrayList.remove(observer);
        System.out.println(observer +" remove");
    }

    @Override
    public void updateObservers() {
        for (Observer o:
             observerArrayList) {
            localTime=LocalTime.now();
            o.update(localTime);
        }
    }
}
