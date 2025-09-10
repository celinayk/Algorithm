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

        long[][] dp = new long[n][n];
        int[][] arr = new int[n][n];
        dp[0][0] = 1;

        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int jump = arr[i][j]; //이동할 칸의 수
                if(jump ==0) {
                    break;
                }
                if(i+jump < n) dp[i+jump][j] = dp[i][j] + dp[i+jump][j]; // 밑으로 갈수있는 경우
                if(j+jump < n) dp[i][jump+j] = dp[i][j] + dp[i][jump+j];
            }
        }

        System.out.println(dp[n-1][n-1]);





    }


}

