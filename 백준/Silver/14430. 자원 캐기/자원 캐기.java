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
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][m+1];
        int[][] arr = new int[n+1][m+1];
        
        for(int i=1; i<=n; i++) {   
        	st = new StringTokenizer(br.readLine());
        	for(int j=1; j<=m; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}     	   	 
        }
        
       
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=m; j++) {
        		dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + arr[i][j];
        		
        	}
        }
        System.out.println(dp[n][m]);

        
    }	
}

