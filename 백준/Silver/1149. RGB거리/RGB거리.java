import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        
        int n = Integer.parseInt(br.readLine());
        
        int dp[][] = new int[n+1][4];
        int arr[][] = new int[n+1][4];
        
        StringTokenizer st;
        for(int i=1; i<=n; i++) {
           st = new StringTokenizer(br.readLine());
           for(int j=1; j<=3; j++) {
              arr[i][j] = Integer.parseInt(st.nextToken());
           }
        }
        
        for(int i=1; i<=n; i++) {
           for(int j=1; j<=3; j++) {
              if(j==1) {
                 dp[i][j] = Math.min(dp[i-1][2], dp[i-1][3])+arr[i][j];
              }
              else if(j==2) {
                 dp[i][j] = Math.min(dp[i-1][1], dp[i-1][3])+arr[i][j];
              }
              else {
                 dp[i][j] = Math.min(dp[i-1][1], dp[i-1][2])+arr[i][j];
              }
           }
        }
       
        int ans = Math.min(dp[n][1], Math.min(dp[n][2], dp[n][3]));
        System.out.println(ans);
        
    }   
}

