package com.ggr.select;

/**
 * Created by GuiRunning on 2017/6/7.
 */
public class DirectSelectSort {
    private DataWarp[] dataWarps;

    /**
     * 直接选择排序,没有优化
     *
     * 时间复杂度T（o）=n*n
     * 执行次数：(n-1)[(n-1)+(n-2)....+1]=(1/2)(n*n)
     *
     * 空间复杂度:1
     *
     * 稳定性:不稳定
     *
     */
    public void selectSort(){

        int count=0;//定义交换次数
        for(int i=0;i<dataWarps.length;i++){

            for(int j=i+1;j<dataWarps.length;j++){

                if(dataWarps[i].compareTo(dataWarps[j])>0){
                    /**
                     * 交换位置
                     */
                    DataWarp temp = dataWarps[i];
                    dataWarps[i]=dataWarps[j];
                    dataWarps[j]=temp;
                    count++;
                }
            }
        }
        System.out.println("优化前排序结果:");
        display();
        System.out.println("交换次数:"+count);
    }

    /**
     * 优化直接选择算法,增加一个索引标志位，减少不必要的交换
     */

    public void selectSort2(){
        int count=0;//定义交换次数
        for(int i=0;i<dataWarps.length;i++){

            int minIndex = i;
            for(int j=i+1;j<dataWarps.length;j++){

                if(dataWarps[i].compareTo(dataWarps[j])>0){
                    minIndex = j;
                }
            }

            /**
             * 交换位置
             */
            if(i!=minIndex){
                DataWarp temp = dataWarps[i];
                dataWarps[i]=dataWarps[minIndex];
                dataWarps[minIndex]=temp;
                count++;
            }
        }
        System.out.println("优化后排序结果:");
        display();
        System.out.println("交换次数:"+count);

    }


    public void display(){
        for (DataWarp d:this.dataWarps) {
            System.out.print(d.toString()+" ");
        }
    }

    public DirectSelectSort(DataWarp[] dataWarps) {
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

        DirectSelectSort selectSort = new DirectSelectSort(test);
        System.out.println("原始顺序:");
        selectSort.display();
        System.out.println();
        selectSort.selectSort();
        System.out.println("=========================================");
        System.out.println("优化后:");
        DataWarp[] test2 = new DataWarp[8];

        test[0]=new DataWarp(12);
        test[1]=new DataWarp(8);
        test[2]=new DataWarp(16);
        test[3]=new DataWarp(5);
        test[4]=new DataWarp(1);
        test[5]=new DataWarp("*",16);
        test[6]=new DataWarp(23);
        test[7]=new DataWarp(13);
        DirectSelectSort selectSort2 = new DirectSelectSort(test);


        selectSort2.selectSort2();
    }
}
