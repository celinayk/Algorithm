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
	static int n,m;
	static boolean[] visited;
	static LinkedList<Integer>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = null;
        int testCase=1;
        
        while(!(str=br.readLine()).equals("0 0")) {
        	
        	String[] input = str.split(" ");
        	n = Integer.parseInt(input[0]);
        	m = Integer.parseInt(input[1]);
        	
        	adj = new LinkedList[n+1];
        	for(int i=1; i<=n; i++ ) {
        		adj[i] = new LinkedList<Integer>();
        	}
        	visited = new boolean[n+1];
        	
        	StringTokenizer st;
        	for(int i=0; i<m; i++) {
        		st = new StringTokenizer(br.readLine());
        		int u = Integer.parseInt(st.nextToken());
        		int v = Integer.parseInt(st.nextToken());
        		
        		adj[u].add(v);
        		adj[v].add(u);
        	}
        	
        	
        	int tree=0;
        	for(int i=1; i<=n; i++) {
        		if(!visited[i]) {
        			tree+=checkTree(i);
        		}
        	}
        	
        	
        	
        	System.out.print("Case " + testCase + ": ");;
        	if(tree>1) {
        		System.out.println("A forest of " + tree + " trees.");
        	}
        	else if(tree==1) {
        		System.out.println("There is one tree.");
        	}
        	else {
        		System.out.println("No trees.");
        	}
        	
        	testCase++;
        	
        }
 
    }
	private static int checkTree(int x) {
		Queue<Integer>q = new LinkedList<Integer>();
		
		int node = 0;
		int edge = 0;
		
		q.add(x);
		visited[x] = true;
		while(!q.isEmpty()) {
			int tmp = q.poll();
			node++;
		
			for(int next: adj[tmp]) {
				edge++;
				if(!visited[next]) {	
					visited[next] = true;
					q.add(next);
					
				}
			}
			
		}
		
		return edge / 2 == node - 1 ? 1 : 0;
	}

	
	
	
	
		
		
		
	}

