package com.ggr.select;

/**
 * Created by GuiRunning on 2017/6/8.
 * 堆排序实现
 *
 * 知识点：一棵二叉树的最后一个叶子节点为k,那么他的父节点(最后一个非叶子节点)为（k-1）/2
 */
public class HeapSort {
    private DataWarp[] dataWarps;

    public HeapSort(DataWarp[] dataWarps) {
        this.dataWarps = dataWarps;
    }

    public DataWarp[] getDataWarps() {

        return dataWarps;
    }

    public void setDataWarps(DataWarp[] dataWarps) {
        this.dataWarps = dataWarps;
    }

    public void display(){
        System.out.print("[ ");
        for (DataWarp d:dataWarps) {
            System.out.print(d.toString()+" ");
        }
        System.out.print("]\n");
    }

    /**
     * 堆排序实现
     * 时间复杂度：T(o)=(n-1)*log(n)
     * 空间复杂度: S(o)=1
     * 稳定性：不稳定
     */
    public void heapSort(){

        /**
         * 从最后一个父节点开始
         */
        int len = dataWarps.length;
        //只要走n-1趟
        for(int i=0;i<len-1;i++){

            //建堆
            buildMaxHeap(dataWarps,len-1-i);
            /**
             * 交换,每次都将顶端元素移动到末置位，所以这里交换了n-1次
             */
            swap(dataWarps,0,len-1-i);

            this.display();
        }

    }

    /**
     *
     * @param dataWarps 数组
     * @param i 当前堆大小
     */
    public void buildMaxHeap(DataWarp[] dataWarps,int i){

        /**
         * j,表示当前判断的父节点索引位置
         */
        for(int j=(i-1)/2;j>=0;j--){
            /*
             * 先判断有没有左叶子节点
             */
            int left = 2*j+1; //左叶子节点索引
             if(left==i){//左叶子节点索引等于堆的最后一个大小-1，那么就说明没有有叶子结点
                if(dataWarps[left].compareTo(dataWarps[j])>0){
                    swap(dataWarps,left,j);
                }
             }else{
                int right = 2*j+2;//右叶子节点
                if(dataWarps[left].compareTo(dataWarps[right])>=0){
                    if(dataWarps[left].compareTo(dataWarps[j])>0){
                        swap(dataWarps,left,j);
                    }
                }else{
                    if(dataWarps[right].compareTo(dataWarps[j])>0){
                        swap(dataWarps,right,j);
                    }
                }
             }

        }
    }

    public void swap(DataWarp[] dataWarps,int i,int j){
            DataWarp temp = dataWarps[i];
            dataWarps[i] = dataWarps[j];
            dataWarps[j] = temp;
    }

     public static void main(String[] args){

         DataWarp[] test = new DataWarp[8];

         test[0]=new DataWarp(12);
         test[1]=new DataWarp(7);
         test[2]=new DataWarp(7);
         test[3]=new DataWarp(10);
         test[4]=new DataWarp(1);
         test[5]=new DataWarp("*",16);
         test[6]=new DataWarp(23);
         test[7]=new DataWarp(16);



         HeapSort HeapSort = new HeapSort(test);

         HeapSort.display();

         System.out.println("堆排序效果演示开始=============");
         HeapSort.heapSort();
         System.out.println("堆排序效果演示结束=============");
     }

}
