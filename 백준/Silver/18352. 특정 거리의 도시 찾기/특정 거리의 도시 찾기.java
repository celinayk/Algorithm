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
	static ArrayList<Integer>[] adj;
	static boolean[] visited;
	static int[] distance;
	static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        int x = Integer.parseInt(input[3]);
        
        adj = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
        	adj[i] = new ArrayList<>();
        }
        visited = new boolean[n+1];
        distance = new int[n+1];
        
        for(int i=0; i<m; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	adj[u].add(v);
        
        }
        
        bfs(x);
        
        boolean found = false;

        for(int i=1; i<=n; i++) {
        	if(distance[i]==k) {
        		System.out.println(i);
        		found = true;
        	}
        }
        if(!found) {
        	System.out.println(-1);
        }
        
 
    }
	private static void bfs(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(x);
		visited[x] =true;
		distance[x] = 0;
		while(!q.isEmpty()) {		
			int tmp = q.poll();
			
			for(int next: adj[tmp]) {
				if(!visited[next]) {
					q.add(next);
					visited[next] = true;
					distance[next] = distance[tmp]+1;
					
				}
			}
		}
	
		
		
	}
	
	
	
		
		
		
	}

