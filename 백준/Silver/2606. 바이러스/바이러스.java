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
	static int[][]  adjMatrix;
	static int cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
             
        
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        isVisited = new boolean[n+1];
        adjMatrix = new int[n+1][n+1];
        
    
		
        // 간선 입력받기
        // 두 노드 사이에 여러개의 간선이 있을 수 있다
        // 양방향 연결이다 
        for(int i=0; i<m; i++) {
        	 StringTokenizer st = new StringTokenizer(br.readLine());
        	 int u = Integer.parseInt(st.nextToken());
        	 int v = Integer.parseInt(st.nextToken());
        	 
        	 adjMatrix[u][v] = adjMatrix[v][u] = 1;
        }
        
        dfs(1);
        System.out.println(cnt);
        
	}

	private static void dfs(int i) {
		isVisited[i] = true;
		
		for(int j=1; j<=n; j++) {
			if(adjMatrix[i][j] == 1 && isVisited[j] ==false) {
				cnt++;
				dfs(j);
			}
		}
	
	}  
}




