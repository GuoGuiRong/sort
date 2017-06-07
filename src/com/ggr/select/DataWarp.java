package com.ggr.select;

/**
 * Created by GuiRunning on 2017/6/7.
 */
public class DataWarp implements Comparable<DataWarp>{

    private String tag;//标记

    private int value;//值

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return tag+value;
    }

    public DataWarp(String tag, int value) {
        this.tag = tag;
        this.value = value;
    }

    public DataWarp(int value) {
        this.value = value;
        this.tag="";
    }

    @Override
    public int compareTo(DataWarp o) {
        return this.getValue()<o.getValue()?1:(this.getValue()==o.getValue()?0:-1);
    }
}
