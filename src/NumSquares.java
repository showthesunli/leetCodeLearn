import java.util.Arrays;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 *
 * Created by prototype on 2015/9/21.
 */
public class NumSquares {

    /**
     * 时间复杂度：O(n * sqrt n)
     * @param n
     * @return
     */
    public int otherSolution(int n){
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                /**
                 * dp[i]为完美平个数和
                 * i = (i-j*j)+j*j;
                 * dp[i] = dp[i-j*j]+dp[j*j]; dp[j*j]一定等于1
                 * dp[i] = dp[i-j*j]+1
                 * 假如i为完美平方数，dp[i] = 1;
                 * 所以取最小值
                 */
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }


    private int mySolution(int n){
        int [] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for (int i=1;i<=n;i++){
            //dp[i] = Math.min(dp[i],recursion(i,dp));
            dp[i] =  recursion(i,dp);
        }
        return dp[n];
    }

    public int recursion(int m,int [] arr){
        for(int i=1;i*i<=m;i++){
            if (i*i==m){
                return 1;
            }else if((i+1)*(i+1)>m){
                return  1+arr[m-i*i];
                /*
                if(i<=m){
                    return 1+arr[i];
                }else{
                    return 1+recursion(m - i * i,arr);
                }
                */
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String [] args) {

        long t1 = System.currentTimeMillis();
        System.out.println(new NumSquares().otherSolution(18));
        long t2 = System.currentTimeMillis();
        System.out.println(new NumSquares().mySolution(18));
        long t3 = System.currentTimeMillis();

        System.out.println("otherSolution's time is " + (t2-t1));
        System.out.println("mySolution's time is " + (t3-t2));


    }
}
