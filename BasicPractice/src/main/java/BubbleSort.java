import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
//        int x = 1;
//        int y,z ;
//        y = ++x;
//        z = x++;
//        System.out.println(y);
//        System.out.println(z);

        Integer[] arr = {5,3,6,2,7,8};
        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.bubbleSort(arr);
//        System.out.println("冒泡排序："+Arrays.toString(arr));

        bubbleSort.chooseSort(arr);
        System.out.println("选择排序：" + Arrays.toString(arr));

        int index = bubbleSort.findIndex(arr,6);
        System.out.println("二分法查找：" + index);

        System.out.println("1到100的和："+bubbleSort.sum());

    }

    /**
     * 冒泡排序：
     * 1、原理：每次比较两个相邻的元素，将较大的元素交换至右端。
     * 每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求，如果不满足就让它俩交换。
     * 一次冒泡会让至少一个元素移动到它应该在的位置，重复n次，就完成了n个数据的排序工作。
     */
    public void bubbleSort(Integer[] arr){
        //如果只有一个元素就不用排序了
        if (arr.length <=1){
            return;
        }
        //提前退出冒泡排序的标志位
        boolean flag = false;
        for (int i =0;i<arr.length;i++){  //冒泡趟数
            for (int j=0;j<arr.length - i -1;j++){   //轮询比较数组中相邻的两个元素
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag){ //没有数据交换，数组已经有序，则退出排序。
                break;
            }
        }
    }

    /**
     * 快速排序：挖坑填数 + 分治法
     * 1、先从序列中取出一个数作为基准数
     * 2、分区：将比基准数更大的数全部放到它的右边，小于或者等于基准数的数全放到它的左边
     *
     * 对挖坑填数进行总结
     * 1．i = L; j = R; 将基准数挖出形成第一个坑 a[i]。
     * 2．j-- 由后向前找比它小的数，找到后挖出此数填前一个坑 a[i] 中。
     * 3．i++ 由前向后找比它大的数，找到后也挖出此数填到前一个坑 a[j] 中。
     * 4．再重复执行 2，3 二步，直到 i==j，将基准数填入 a[i] 中。
     */


    /**
     * 选择排序：每次选择一个数和其余的数一一进行比较，比他大的不动，比他小的两者交换
     * 从0索引开始，依次和后面元素比较，小的往前放，第一次完毕，最小值出现在了最小索引处。
     */

    public void chooseSort(Integer[] arr){
        for (int index = 0; index<arr.length-1;index++){
            for(int j = index +1;j<arr.length;j++){
                if (arr[index] > arr[j]){
                    int temp = arr[index];
                    arr[index] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    /**
     * 二分法查找： 二分法查找的前提是元素有序
     * 每次都查中间的元素，比较大或者小就能减少一半的元素
     */

    public int findIndex(Integer[] arr,int element){
        //先定义三个位置的变量
        int minIndex = 0;
        int maxIndex = arr.length-1;
        int midIndex = (minIndex + maxIndex) / 2;

        while (minIndex <= maxIndex){
            if (element == arr[midIndex]){
                return midIndex;
            }else if (element > arr[midIndex]){
                minIndex = midIndex + 1;
            }else if (element <arr[midIndex]){
                maxIndex = midIndex - 1;
            }
            //重新计算中间索引
            midIndex = (minIndex + maxIndex)/2;
        }
        return -1;
    }

    public int sum(){
        //int i =1;
        int sum =0;
        for (int i=1;i<=100;i++){
            sum = sum +i;
        }
        return sum;
    }
}
