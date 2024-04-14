public class leetcode_jumpStep {
    public static void main(String[] args) {
        int start = (int) System.nanoTime();

//        System.out.println(jumpStepFibonacci(3, 2));
        System.out.println(getWays(10));
        int end = (int)System.nanoTime();
        System.out.println("time:"+(end-start)+"ns");

    }

    /**上台阶问题,递归求解  方法的时间复杂度为O(2^n) **/
    public static int jumpStepFibonacci(int n,int m) {
        if(n<0) return -1;
        if(n<=2) return n;
        return jumpStepFibonacci(n-1, m)+jumpStepFibonacci(n-2, m);
    }


    /**上台阶问题，dp   时间复杂度仍为O(n)，但空间复杂度降为O(1) **/
    public static int climbStairs(int n) {
        if(n==0) return -1;
        if(n==1) return 1;
        int[] dp = new int [n];
        dp[0] =1;
        dp[1] =2;
        for(int i=0;i<n-2;i++) {
            dp[i+2]=dp[i]+dp[i+1];
        }
        return dp[n-1];
    }

    public static int getWays( int n) {

        if (n < 1) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        // a保存倒数第二个子状态数据，b保存倒数第一个子状态数据， temp 保存当前状态的数据
        int a = 1, b = 2;
        int temp = a + b;
        for (int i = 3; i <= n; i++) {
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

    public int fiboTest1(int n) {
        if (n==1) return 1;
        if (n==2) return 2;
        return fiboTest1(n-1) + fiboTest1(n-2);
    }

    public void fiboTest2(int n) {
        int[] dp = new int[n];
        dp[1] = 1;
        dp[2] = 2;
        for (int i= 3; i < n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
    }
}
