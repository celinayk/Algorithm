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
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
             
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        isVisited = new boolean[n+1];
        adjList = new LinkedList[n+1]; 
        
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
        
       
        for(int i=1; i<=n; i++) {
        	if(!isVisited[i]) {
        		dfs(i);
        		cnt++;
        	}
        }
        System.out.println(cnt);
        
    }

	private static void dfs(int i) {
		isVisited[i] = true;
		
		for(int j :adjList[i]) {
			if(!isVisited[j]) {
				dfs(j);
			}
			
		}
	}
}