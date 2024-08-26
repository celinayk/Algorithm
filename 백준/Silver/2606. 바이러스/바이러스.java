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
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[] isVisited;
	static LinkedList<Integer>[] adjList;
	static int cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
             
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        isVisited = new boolean[n+1];
        adjList = new LinkedList[n+1];
        
        // 인접리스트 초기화
        for(int i=0; i<=n; i++) {
        	adjList[i] = new LinkedList<Integer>();
        }
		
        // 간선 입력받기
        // 두 노드 사이에 여러개의 간선이 있을 수 있다
        // 양방향 연결이다 
        for(int i=0; i<m; i++) {
        	 StringTokenizer st = new StringTokenizer(br.readLine());
        	 int u = Integer.parseInt(st.nextToken());
        	 int v = Integer.parseInt(st.nextToken());
        	 
        	 adjList[u].add(v);
        	 adjList[v].add(u);
        }
        
        dfs(1);
        System.out.println(cnt-1);
        
	}

	private static void dfs(int i) {
		isVisited[i] = true;
		cnt++;
		
		for(int k :adjList[i]) { //i노드와 연결된 모든 컴퓨터에 대해
			if(!isVisited[k]) { // 아직 방문하지 않은 컴퓨터가 있으면
				dfs(k); // 거기로 이동해서 탐색
			}
		}
		
	}  
}




