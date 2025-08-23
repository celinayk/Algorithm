import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int[][]arr = new int[n+1][m+1];

        for(int i = 1; i <= n; i++) {
            inputs = br.readLine().split(" ");
            for(int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(inputs[j-1]);
            }
        }

        int[][]dp = new int[n+1][m+1];

        dp[1][1] = arr[1][1];
        for(int i = 1; i <= n; i++) {
            for(int j=1; j <= m; j++) {
                dp[i][j] = Math.max(Math.max(dp[i-1][j-1]+arr[i][j], dp[i][j-1]+arr[i][j]),dp[i-1][j]+arr[i][j]);
            }
        }
        System.out.println(dp[n][m]);


    }
}