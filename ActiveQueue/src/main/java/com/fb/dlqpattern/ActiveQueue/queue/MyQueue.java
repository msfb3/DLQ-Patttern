package com.fb.dlqpattern.ActiveQueue.queue;

import java.util.ArrayList;
import java.util.List;



public class MyQueue {
    private List<Integer> data;
    private int q_start;
    public MyQueue() {
        data = new ArrayList<Integer>();
        q_start = 0;
    }
    public boolean addQueue(int x) {
        data.add(x);
        return true;
    }
    public boolean deleteQueue() {
        if (isEmpty()) {
            return false;
        }
        q_start++;
        return true;
    }

    public int FirstItem() {
        return data.get(q_start);
    }
    public boolean isEmpty() {
        return q_start >= data.size();
    }
}
