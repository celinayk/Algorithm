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
	        int []dp = new int[n+1];
	        int [] arr = new int[n+1];
	        int max = 1;
	        
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for(int i=0; i<n; i++) {
	        	arr[i] = Integer.parseInt(st.nextToken());
	        }
	        
	        for(int i=0; i<n; i++) {
	        	dp[i]=1; // 우선 본인의 값 1 부터 
	        	for(int j=0; j<i; j++) {
	        		if(arr[j]<arr[i]) {
	        			dp[i] = Math.max(dp[i], dp[j]+1);
	        		}
	        	}
	        	max = Math.max(max, dp[i]);
	        }
	        System.out.println(max);
	    }
	}