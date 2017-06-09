package com.ggr.insert;

import com.ggr.entity.DataWarp;
import com.ggr.util.ObjUtil;

/**
 * Created by GuiRunning on 2017/6/9.
 */
public class DirectInsert {

    private DataWarp[] dataWarps;

    public DirectInsert(DataWarp[] dataWarps) {
        this.dataWarps = dataWarps;
    }

    public DataWarp[] getDataWarps() {

        return dataWarps;
    }

    public void directSort(){
        int len = dataWarps.length;
        for(int i=1;i<len;i++){

            if(dataWarps[i].compareTo(dataWarps[i-1])<0){

                DataWarp temp = dataWarps[i];
                for(int j=i-1;j>=0;j--){

                        if(temp.compareTo(dataWarps[j])<0){
                            dataWarps[j+1]=dataWarps[j];
                            if(j==0){
                                dataWarps[j]=temp;
                            }
                        }else{
                            dataWarps[j+1]=temp;
                            break;
                        }

                    }
                }
            System.out.println("i="+i);
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
        DirectInsert directInsert = new DirectInsert(test);
        directInsert.directSort();
        System.out.println("排序后：");

        //ObjUtil.display(test);

    }
}
