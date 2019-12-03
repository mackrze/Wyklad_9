package com.company;

public interface Observable {
    void registerObserver(Observer observer);
    void deleteObserver(Observer observer);
    void updateObservers();

}
