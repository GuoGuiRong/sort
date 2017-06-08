package com.ggr.util;

/**
 * Created by GuiRunning on 2017/6/8.
 */
public class ObjUtil {
    /**
     * 交换数组元素位置
     * @param dataWarps 数组
     * @param i 数组索引为i的元素
     * @param j 数组索引为j的元素
     */
    public static void swap(Object[] dataWarps, int i, int j){
        Object temp = dataWarps[i];
        dataWarps[i] = dataWarps[j];
        dataWarps[j] = temp;
    }

    /**
     * 打印数组元素
     * @param dataWarps
     */
    public static void display(Object[] dataWarps){
        if(dataWarps!=null&&dataWarps.length>0){
            StringBuilder temp=new StringBuilder("[ ");
            for (int i=0;i<dataWarps.length;i++){
                temp.append(dataWarps[i].toString()).append(", ");
            }
            int index = temp.lastIndexOf(",");
            System.out.println(temp.substring(0,index)+" ]");
        }
    }
}
