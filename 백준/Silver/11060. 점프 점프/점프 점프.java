import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
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
        int []arr = new int[n+1];
        int []dp = new int [1101];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        	dp[i] = Integer.MAX_VALUE;
        }
        
        dp[1] = 0;
        for(int i=1; i<=n; i++) {
        	if(dp[i]>=Integer.MAX_VALUE) continue;
        	for(int j=1; j<=arr[i]; j++) {
        		dp[i+j] = Math.min(dp[i+j], dp[i]+1);
        	}       	
        }
        if(dp[n]>=Integer.MAX_VALUE) {
        	System.out.println(-1);
        }
        else {
        	System.out.println(dp[n]);
        }
        
        
    }  
}