import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static LinkedList<Integer>[] adjList;
	static boolean[]isVisited;
	static int cnt = 0;
	static int a,b;
	static int[] degree; 
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
             
        int n = Integer.parseInt(br.readLine());
        
        //촌수 계산해야하는 두 사람 번호 
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        int m = Integer.parseInt(br.readLine());
        
        isVisited = new boolean[n+1];
        adjList = new LinkedList[n+1]; 
        degree = new int[n+1];
        
        for(int i=0; i<=n; i++) {
        	adjList[i] = new LinkedList<Integer>();
        }
        
        //그래프 구현
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	adjList[u].add(v);
        	adjList[v].add(u);
        }
        
        
        bfs(a);
        if (degree[b] == 0 && a != b) {
            System.out.println(-1);
        } else {
            System.out.println(degree[b]);
        }
        
    }

	private static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i);
		isVisited[i] = true;	
		degree[i] = 0;     
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			//현재 노드와 연결된 모든 노드 탐색 			
			for(int k : adjList[tmp]) {
				if(!isVisited[k]) {
					q.add(k);
					isVisited[k] = true;
					degree[k] = degree[tmp] +1;
				}
			}
		}
	}
}