package com.fb.dlqpattern.ActiveQueue.queue;

import java.util.*;


public class MyQueue<ReceivedData> extends AbstractQueue<ReceivedData> {

    private LinkedList<ReceivedData> dataQueue;

    public MyQueue() {
        this.dataQueue = new LinkedList<ReceivedData>();
    }

    @Override
    public Iterator<ReceivedData> iterator() {
        return dataQueue.iterator();
    }

    @Override
    public int size() {
        return dataQueue.size();
    }


    @Override
    public boolean offer(ReceivedData receivedData) {
        if(receivedData == null) return false;
        dataQueue.add(receivedData);
        return true;
    }

    @Override
    public ReceivedData poll() {
        Iterator<ReceivedData> iter = dataQueue.iterator();
        ReceivedData receivedData = iter.next();
        if(receivedData != null) {
            iter.remove();
        }
        return receivedData;
    }

    @Override
    public ReceivedData peek() {
        return dataQueue.getFirst();
    }
}
