package com.ggr.swap;

import com.ggr.entity.DataWarp;
import com.ggr.util.ObjUtil;

/**
 * Created by GuiRunning on 2017/6/8.
 * 冒泡排序
 * 时间复杂度:T(o)=>{n,n*n}
 * 空间复杂度:O（1）
 * 稳定性:稳定
 */
public class BubbleSort {

    private DataWarp[] dataWarps;

    public BubbleSort(DataWarp[] dataWarps) {
        this.dataWarps = dataWarps;
    }

    public DataWarp[] getDataWarps() {

        return dataWarps;
    }

    public void setDataWarps(DataWarp[] dataWarps) {
        this.dataWarps = dataWarps;
    }

    public void bubbleSort(){
        for(int i=0;i<dataWarps.length-1;i++){
            boolean flag=false;//如果发现子for循环没有发生交换，说明顺序已经排好了
            for(int j=0;j<dataWarps.length-1-i;j++){
                if(dataWarps[j].compareTo(dataWarps[j+1])>0){
                    ObjUtil.swap(dataWarps,j,j+1);
                    flag=true;
                }
            }
            ObjUtil.display(dataWarps);
            if(!flag){
                break;
            }
        }
    }


    public void swap(DataWarp[] dataWarps,int i,int j){
        DataWarp temp;
        temp = dataWarps[i];
        dataWarps[i] = dataWarps[j];
        dataWarps[j]=temp;
    }

    public static void main(String[] args){
        DataWarp[] test2 = new DataWarp[8];

        test2[0]=new DataWarp(12);
        test2[1]=new DataWarp(8);
        test2[2]=new DataWarp(16);
        test2[3]=new DataWarp(5);
        test2[4]=new DataWarp(1);
        test2[5]=new DataWarp("*",16);
        test2[6]=new DataWarp(23);
        test2[7]=new DataWarp(13);
        System.out.println("初始数组顺序:");
        ObjUtil.display(test2);
        BubbleSort bubbleSort = new BubbleSort(test2);
        System.out.println("开始冒泡:=======================");
        bubbleSort.bubbleSort();
        System.out.println("结束冒泡:=======================");
    }
}
