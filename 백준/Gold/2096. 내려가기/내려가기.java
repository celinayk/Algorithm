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
        
        int max_dp[][] = new int[n+1][3];
        int min_dp[][] = new int[n+1][3];
        
        
        StringTokenizer st;
        for(int i=1; i<=n; i++) {
           st = new StringTokenizer(br.readLine());
           
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           int c = Integer.parseInt(st.nextToken());
           
           //최대값 구하기 
           max_dp[i][0] = Math.max(max_dp[i-1][0], max_dp[i-1][1])+a;
           max_dp[i][1] = Math.max(max_dp[i-1][0], Math.max(max_dp[i-1][1], max_dp[i-1][2]))+b;
           max_dp[i][2] = Math.max(max_dp[i-1][2], max_dp[i-1][1])+c;
           
           //최소값 구하기 
           min_dp[i][0] = Math.min(min_dp[i-1][0], min_dp[i-1][1])+a;
           min_dp[i][1] = Math.min(min_dp[i-1][0], Math.min(min_dp[i-1][1], min_dp[i-1][2]))+b;
           min_dp[i][2] = Math.min(min_dp[i-1][2], min_dp[i-1][1])+c;
        }
        
        int maxx = Math.max(max_dp[n][0], Math.max(max_dp[n][1], max_dp[n][2]));
        int minn = Math.min(min_dp[n][0], Math.min(min_dp[n][1], min_dp[n][2]));
        System.out.println(maxx + " "+ minn);
        
        
        
   
      
 
    }   
}

