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
        
        int dp[][] = new int[n+1][3];
        int arr[][] = new int[n+1][3];
        
        StringTokenizer st;
        for(int i=1; i<=n; i++) {
           st = new StringTokenizer(br.readLine());
           for(int j=0; j<3; j++) {
        	   arr[i][j] = Integer.parseInt(st.nextToken());
           }         
        }
        
        for(int i=1; i<=n; i++) {
        	for(int j=0; j<3; j++) {
        		if(j==0) {
        			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1])+arr[i][0];
        		}
        		else if(j==1) {
        			dp[i][1] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]))+arr[i][1];
        		}
        		else {
        			dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1])+arr[i][2];
        		}
        	}
        }
        
        int a = Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2]));
        
        for(int i=1; i<=n; i++) {
        	for(int j=0; j<3; j++) {
        		if(j==0) {
        			dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1])+arr[i][0];
        		}
        		else if(j==1) {
        			dp[i][1] = Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2]))+arr[i][1];
        		}
        		else {
        			dp[i][2] = Math.min(dp[i-1][2], dp[i-1][1])+arr[i][2];
        		}
        	}
        }
        
        int b = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
        
        System.out.println(a + " " + b);
        
   
      
 
    }   
}

