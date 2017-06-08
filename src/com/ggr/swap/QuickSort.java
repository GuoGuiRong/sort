package com.ggr.swap;

import com.ggr.entity.DataWarp;
import com.ggr.util.ObjUtil;

/**
 * Created by GuiRunning on 2017/6/8.
 */
public class QuickSort {
    private DataWarp[] dataWarps;

    public DataWarp[] getDataWarps() {
        return dataWarps;
    }

    public void setDataWarps(DataWarp[] dataWarps) {
        this.dataWarps = dataWarps;
    }

    public QuickSort(DataWarp[] dataWarps) {
        this.dataWarps = dataWarps;
    }

    public void subSort(DataWarp[] dataWarps,int start,int end){

        DataWarp temp = dataWarps[start];//选择分界值

        if(start<end) {

            int i = start;
            int j = end+1;
            while (true) {
                /**
                 * 找出大于临界值的位置
                 */
                while(dataWarps[++i].compareTo(temp) < 0 && i < end-1);
                 /*while (true) {
                     if (dataWarps[i].compareTo(temp) > 0 || i == end) {
                         break;
                     }
                     i++;
                 }*/

                /**
                 * 找出小于临界值的位置
                 */
                while(dataWarps[--j].compareTo(temp) > 0 && j >start);
                /* while (true) {
                     if (dataWarps[j].compareTo(temp) < 0 || j == start) {
                         break;
                     }
                     --j;
                 }*/

                if (i < j) {
                    ObjUtil.swap(dataWarps, i, j);
                } else {
                    break;
                }
            }
            ObjUtil.swap(dataWarps, start, j);
            ObjUtil.display(dataWarps);

            subSort(dataWarps,start,j-1);

            subSort(dataWarps,j+1,end);
        }
    }


    public static void main(String[] args){
        DataWarp[] test2 = new DataWarp[8];

        test2[0]=new DataWarp(12);
        test2[1]=new DataWarp(8);
        test2[2]=new DataWarp(16);
        test2[3]=new DataWarp(5);
        test2[4]=new DataWarp(1);
        test2[5]=new DataWarp("*",13);
        test2[6]=new DataWarp(23);
        test2[7]=new DataWarp(13);
        System.out.println("初始数组顺序:");
        ObjUtil.display(test2);

        System.out.println("开始快排：");
        QuickSort quickSort = new QuickSort(test2);
        quickSort.subSort(test2,0,test2.length-1);
        //ObjUtil.display(test2);
    }
}
