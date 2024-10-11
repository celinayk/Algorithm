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
	static int k;
	static char[] sign;
	static List<String>ans;
	static boolean[] visited;
	   public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        int n = Integer.parseInt(st.nextToken());
	        int k = Integer.parseInt(st.nextToken());
	        
	        char [] arr = new char[20010];
	        boolean [] visited = new boolean[20010];
	        
	        String input = br.readLine();
	        for(int i=0; i<n; i++)  {
	        	arr[i] = input.charAt(i);
	        }
	        
	        int cnt=0; 
	        for(int i=0; i<n; i++) {
	        	for(int j = Math.max(0, i - k); j <= Math.min(n - 1, i + k); j++) {
	        		if(arr[i]=='P') {
	        			if(arr[j]=='H' && !visited[j]) {
	        				cnt++;
	        				visited[j]=true;
	        				break;
	        			}
	        		}
	        	}
	        }
	        
	        
	        System.out.println(cnt);

	        
	}


	
}