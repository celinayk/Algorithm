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
	static int[] arr;
	static boolean[] visited;
	static int s,n;
	static int ans =0;
	   public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        n = Integer.parseInt(st.nextToken());
	        s = Integer.parseInt(st.nextToken());
	        
	        arr = new int[n];
	        visited = new boolean[n];
	        st = new StringTokenizer(br.readLine());
	        for(int i =0; i<n; i++) {
	        	arr[i] = Integer.parseInt(st.nextToken());
	        }
	        
	        backtrack(0, 0);
	        if(s==0) {
	        	System.out.println(ans-1);
	        }
	        else {
	        	System.out.println(ans);
	        }
	     
	        
	   }

	private static void backtrack(int depth, int sum) {
		// 종료조건 
		if (depth==n) {
			if(sum==s) {
				ans++;			
			}
			return;
		}
		
		backtrack(depth +1, sum+arr[depth]);
		backtrack(depth +1, sum);
		
	}
}