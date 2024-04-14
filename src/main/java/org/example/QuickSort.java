import java.util.Arrays;

/**
 * @Description:
 * @Auther: LucasXu
 * @email: 18140041@bjtu.edu.cn
 * @github: https://github.com/LucasXu01
 * @Date: 2022/02/27/4:54 下午
 */
public class QuickSort {
    public static void quickSort(int nums[], int left, int right) {
        // 递归返回条件，和分区排序结束
        if (right-left <=0) {
            return;
        }
        // 选择数组右边界值作为分区节点
        int pivot = nums[right];
        // 从数组左边界值开始维护分区
        int partition=left-1;
        // 遍历当前分区内元素
        for (int i = left; i <= right-1; i++) {
            if ((nums [i] < pivot) ) {
                // 将小于pivot的值交换到partition左边
                // 将大于等于pivot的值交换到partition右边
                partition++;
                swap(nums, partition, i);
            }
        }
        // 将分区节点插入到数组左右分区中间
        partition++;
        swap(nums, partition, right);
        // 分区节点排序完成
        // 左分区继续排序，右分区继续排序
        quickSort(nums,left, partition-1);
        quickSort(nums,partition+1, right);

    }


    public static void quickMy(int[] num, int left, int right){
      int pivod = num[right];
      int position = left - 0;
      for(int i = left ; i < right; i++){
          if (num[i] < pivod){
              position ++;
              swap(num, position, i);
          }

      }

      position ++;
      swap(num, position, right);
      quickSort(num, left, position-1);
      quickSort(num, position+1, right);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums [i];
        nums [i] = nums [j];
        nums [j] = temp;
    }




    public static void main(String[] args) {
        int a[] = { 49, 38, 65, 97, 76, 13, 27, 49 };
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}