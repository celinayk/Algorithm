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
        
        int dp[] = new int[n];
        int arr[] = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int ans = 0;
        for(int i=0; i<n; i++) {
        	dp[i] = 1;
        	for(int j=0; j<i; j++) {
        		if(arr[i]<arr[j]) {
        			dp[i] = Math.max(dp[i], dp[j]+1);
        		}      		
        	}
        	ans=Math.max(dp[i], ans);
        }
        System.out.println(ans);
    }	
}

