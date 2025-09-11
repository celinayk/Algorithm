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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[]dp = new int[n + 1];
        int[]arr = new int[n + 1];

        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            int max = 0;
            arr[i] = Integer.parseInt(st.nextToken());

            for(int j=i; j>=1; j--) {
                max = Math.max(max, arr[j]);
                min = Math.min(min, arr[j]);
                dp[i] = Math.max(dp[i], max-min + dp[j-1]);
            }
        }

        System.out.println(dp[n]);










    }


}

