import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        int[][] dp = new int[n][n];

        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st =  new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];


        for(int i=1; i<n; i++) {
            for(int j=0; j<=i; j++) {
                if(j==0) { // 맨 왼쪽인 경우
                    dp[i][j] = dp[i-1][j]+arr[i][j];
                }
                else if(i==j) { // 맨 오른쪽인 경우
                    dp[i][j] = dp[i-1][j-1]+arr[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1]+arr[i][j], dp[i-1][j]+arr[i][j]);
                }

            }
        }

         int max = 0;
         for(int j=0; j<n; j++) {
             max = Math.max(max, dp[n-1][j]);

         }
        System.out.println(max);

    }
}