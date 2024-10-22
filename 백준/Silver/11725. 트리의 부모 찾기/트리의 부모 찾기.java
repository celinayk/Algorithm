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
	static ArrayList<Integer>[] arr;
	static StringBuilder sb;
	static int n;
	static int []parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        parent = new int[n+1];
        StringTokenizer st;
        for(int i=0; i<n-1; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	arr[u].add(v);
            arr[v].add(u);
        }
        
        sol(1, -1);
        
  
    }
	private static void sol(int i, int j) {
		dfs(1,-1);
		sb = new StringBuilder();
		for(int k=2; k<=n; k++) {
			sb.append(parent[k]).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	
	 private static void dfs(int node, int par) {
	        parent[node] = par;  // 현재 노드의 부모를 기록

	        // 현재 노드에 연결된 다른 노드들 탐색
	        for (int next : arr[node]) {
	            if (next != par) {  // 부모로 돌아가는 경로는 제외
	                dfs(next, node);  // 자식 노드로 이동
	            }
	        }
	    }
		
		
		
	}

