import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][] arr = new int[n+1][m+1];
        for(int i=1; i<=n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=m; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        int [][][] dp = new int[n+1][m+1][4];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        for(int i=1; i<=m; i++) {
        	dp[1][i][1] = arr[1][i];
        	dp[1][i][2] = arr[1][i];
        	dp[1][i][3] = arr[1][i];
        }
    
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 왼쪽에서 오는 경우
                if (j > 1) {
                    dp[i][j][1] = Math.min(dp[i][j][1], Math.min(dp[i - 1][j - 1][2], dp[i - 1][j - 1][3]) + arr[i][j]);
                }
                // 위에서 오는 경우
                dp[i][j][2] = Math.min(dp[i][j][2], Math.min(dp[i - 1][j][1], dp[i - 1][j][3]) + arr[i][j]);
                // 오른쪽에서 오는 경우
                if (j < m) {
                    dp[i][j][3] = Math.min(dp[i][j][3], Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j]);
                }
            }
        }
       
        int minFuel= Integer.MAX_VALUE;
        for(int i=1; i<=m; i++) {
        	 minFuel = Math.min(minFuel, Math.min(dp[n][i][1], Math.min(dp[n][i][2], dp[n][i][3])));
        }
        System.out.println(minFuel);
             		
    }
}