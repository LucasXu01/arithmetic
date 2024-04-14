import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class sortDemo {
    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 6, 4, 5, 0, 8, 9, 7};

        int[] sortedArray = bubbleSort(array);
//        int[] sortedArray = QuickSort(array,0,array.length-1);
        for (int item : sortedArray) {
            System.out.println(item);
        }

    }


    /**
     * 冒泡排序
     */
    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length - 1 - i; j++) {
                System.out.println("-" + array[j] + array[j+1]);
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        return array;
    }

    // 选择排序
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {//遍历未剩余未排序元素中继续寻找最小元素
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }


    /**
     * 插入排序
     */
    public static int[] insertSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i + 1];
            int index = i;
            while (index >= 0 && current < array[index]) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = current;
        }
        return array;
    }

    public static int[] QuickSort(int[] array, int low, int hight) {
        if (low < hight) {
            int privotpos = partition(array, low, hight);
            QuickSort(array, low, privotpos - 1);
            QuickSort(array, privotpos + 1, hight);
        }
        return array;

    }

    public static int partition(int[] array, int low, int hight) {
        int privot = array[low];
        while (low < hight) {
            while (low < hight && array[hight] >= privot) --hight;
            array[low] = array[hight];
            while (low < hight && array[low] <= privot) ++low;
            array[hight] = array[low];
        }
        array[low] = privot;
        return low;
    }


    /**
     * 希尔排序
     */
    public class ShellSort {
        private int[] array;
        public ShellSort(int[] array) {
            this.array = array;
        }
        public void sort() {
            int temp;
            for (int k = array.length / 2; k > 0; k /= 2) {
                for (int i = k; i < array.length; i++) {
                    for (int j = i; j >= k; j -= k) {
                        if (array[j - k] > array[j]) {
                            temp = array[j - k];
                            array[j - k] = array[j];
                            array[j] = temp;
                        }
                    }
                }
            }
        }
        public void print() {
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
        }
    }

}
