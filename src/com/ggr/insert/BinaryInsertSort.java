package com.ggr.insert;

import com.ggr.entity.DataWarp;
import com.ggr.util.ObjUtil;

/**
 * Created by GuiRunning on 2017/6/9.
 * 折半查找算法
 */
public class BinaryInsertSort {

    private DataWarp[] dataWarps;

    public BinaryInsertSort(DataWarp[] dataWarps) {
        this.dataWarps = dataWarps;
    }

    public DataWarp[] getDataWarps() {

        return dataWarps;
    }

    public void binaryInsertSort(){

        int len = dataWarps.length;
        int left = 0;
        int right = len-1;
        for(int i=1;i<len;i++){
            right = i-1;
            //当前位置的值
            DataWarp temp = dataWarps[i];
            /**
             * 折半查找,找到具体位置
             */
            int center=0;
            if(temp.compareTo(dataWarps[i-1])<0){

                while(left<right){
                    center = (left+right)/2;
                    if(temp.compareTo(dataWarps[center])>0){
                        left = center+1;
                    }
                    if(temp.compareTo(dataWarps[center])<=0){
                        right = center-1;
                    }
                }
                center = (left+right)/2;
                int j = i-1;
                for (; j >= center&&(temp.compareTo(dataWarps[j]) < 0); j--) {

                    dataWarps[j + 1] = dataWarps[j];

                }
                dataWarps[j + 1] = temp;
            }

            System.out.println("center="+center+"  i="+i);
            ObjUtil.display(dataWarps);
        }
    }

    public void setDataWarps(DataWarp[] dataWarps) {
        this.dataWarps = dataWarps;
    }



    public static void main(String[] args){
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
        System.out.println("排序.....");
        BinaryInsertSort directInsert = new BinaryInsertSort(test);
        directInsert.binaryInsertSort();
        System.out.println("排序后：");

    }
}
