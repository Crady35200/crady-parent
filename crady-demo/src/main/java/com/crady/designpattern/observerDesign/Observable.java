package com.crady.designpattern.observerDesign;

import java.util.Vector;

/**
 * @author :Crady
 * date :2019/7/18 16:33
 * desc :
 **/
public abstract class Observable {

    Vector<Observer> observers = new Vector();

    public void addObserver(Observer observer){
        this.observers.addElement(observer);
    }
    public void deleteObserver(Observer observer){
        this.observers.removeElement(observer);
    }
    public void notifyObservers(){
        for(Observer observer : observers){
            observer.update();
        }
    }
}
