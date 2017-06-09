package com.ggr.insert;

import com.ggr.entity.DataWarp;
import com.ggr.util.ObjUtil;

/**
 * Created by GuiRunning on 2017/6/9.
 */
public class ShellSort {

   private DataWarp[] dataWarps;

    public DataWarp[] getDataWarps() {
        return dataWarps;
    }

    public void setDataWarps(DataWarp[] dataWarps) {
        this.dataWarps = dataWarps;
    }

    public ShellSort(DataWarp[] dataWarps) {
        this.dataWarps = dataWarps;
    }


    public void shellSort(){
        int len = dataWarps.length;

        int h = 1;//定義增量為3
        while(h<=(len/3)){
            h=3*h+1;//初始化增量(來自官方算法)
        }

        while(h>=1){

            for(int i=h;i<len;i++){

                DataWarp temp = dataWarps[i];

                if(temp.compareTo(dataWarps[i-h])<0) {
                    int j = i - h;
                    for (; j >= 0 && (temp.compareTo(dataWarps[j]) < 0); j -= h) {
                        dataWarps[j + h] = dataWarps[j];
                    }
                    dataWarps[j + h] = temp;
                }

            }
            ObjUtil.display(dataWarps);
            h = (h-1)/3;//更新h
        }

    }

    public static void main(String[] args) {
        DataWarp[] test = new DataWarp[8];

        test[0]=new DataWarp(12);
        test[1]=new DataWarp(8);
        test[2]=new DataWarp(16);
        test[3]=new DataWarp(5);
        test[4]=new DataWarp(1);
        test[5]=new DataWarp("*",16);
        test[6]=new DataWarp(23);
        test[7]=new DataWarp(13);

        System.out.println("排序前：");
        ObjUtil.display(test);
        ShellSort shellSort = new ShellSort(test);

        System.out.println("排序中...");
        shellSort.shellSort();

    }
}
