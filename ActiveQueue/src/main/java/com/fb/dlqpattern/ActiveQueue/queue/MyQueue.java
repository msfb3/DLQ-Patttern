package com.fb.dlqpattern.ActiveQueue.queue;

import com.fb.dlqpattern.ActiveQueue.domain.RecivedData;

import java.util.*;


public class MyQueue<RecivedData> extends AbstractQueue<RecivedData> {

    private LinkedList<RecivedData> dataQueue;

    public MyQueue() {
        this.dataQueue = new LinkedList<RecivedData>();
    }

    @Override
    public Iterator<RecivedData> iterator() {
        return dataQueue.iterator();
    }

    @Override
    public int size() {
        return dataQueue.size();
    }


    @Override
    public boolean offer(RecivedData recivedData) {
        if(recivedData == null) return false;
        dataQueue.add(recivedData);
        return true;
    }

    @Override
    public RecivedData poll() {
        Iterator<RecivedData> iter = dataQueue.iterator();
        RecivedData recivedData = iter.next();
        if(recivedData != null) {
            iter.remove();
        }
        return recivedData;
    }

    @Override
    public RecivedData peek() {
        return dataQueue.getFirst();
    }
}
