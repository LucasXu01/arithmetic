public class leetcode_sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(144));
    }


    // 二分开方法
//    (0+3)/2 = 1.5, 1.5^2 = 2.25, 2.25 < 3;
//
//    (1.5+3)/2 = 2.25, 2.25^2 =5.0625, 5.0625 > 3;
//
//    (1.5+2.25)/2 = 1.875, 1.875^2 =3.515625;3.515625>3;
    public static int mySqrt(int x)
    {
        if(x == 1)
            return 1;
        int min = 0;
        int max = x;
        while(max-min>1)
        {
            int m = (max+min)/2;
            if(x/m<m)
                max = m;
            else
                min = m;
        }
        return min;
    }


    public int sqrt(int m) {
        int min = 0;
        int max = m;
        while (max - min > 1) {
            int mid = (max+min)/2;
            if (m/mid > mid) {
                min = mid;
            }else {
                max = mid;
            }
        }
        return min;
    }
}
