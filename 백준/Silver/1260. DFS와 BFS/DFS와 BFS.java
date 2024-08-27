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
	static int n, m,v;
	static boolean[] isVisited;
	static LinkedList<Integer>[] adjList;
	static int cnt=0;
	static StringBuilder sd;
	static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
             
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());
        
        isVisited = new boolean[n+1]; //0번째 요소는 사용하지 않음
        adjList = new LinkedList[n+1];
        sd = new StringBuilder();
        sb = new StringBuilder();
        
        // 인접리스트 초기화
        for(int i=0; i<=n; i++) {
        	adjList[i] = new LinkedList<Integer>();
        }
		
        for(int i=0; i<m; i++) {
        	 st = new StringTokenizer(br.readLine());
        	 int u = Integer.parseInt(st.nextToken());
        	 int v = Integer.parseInt(st.nextToken());
        	 
        	 adjList[u].add(v);
        	 adjList[v].add(u);
        }
        
        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }
        
        dfs(v);
        System.out.print(v+ " ");
        System.out.println(sd);
        
        Arrays.fill(isVisited, false);
        bfs(v);
        System.out.print(v+ " ");
        System.out.println(sb);
	}

	private static void bfs(int i) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(i);
		isVisited[i] = true;
		while(!q.isEmpty()) {
			//큐에서 노드 꺼냄 
			int tmp = q.poll();
			
			//현재 노드에 연결된 모든 노드 확인
			for(int neighbor : adjList[tmp]) {
				//인접 노드가 방문하지 않은 노드라면 
				if(!isVisited[neighbor]) {
					q.add(neighbor);
					sb.append(neighbor+ " ");
					isVisited[neighbor] = true;
				}
			}
		}
		
		
	}

	private static void dfs(int i) {
		isVisited[i] = true;
		
		for(int k :adjList[i]) { //i노드와 연결된 모든 컴퓨터에 대해
			if(!isVisited[k]) { // 아직 방문하지 않은 컴퓨터가 있으면
				sd.append(k+ " ");
				dfs(k); // 거기로 이동해서 탐색
			}
		}
		
	}  
}