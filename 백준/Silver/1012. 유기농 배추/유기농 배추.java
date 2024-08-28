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
	static int[][] adjMatrix;
	static int n,m,k=0;
	static boolean[][] isVisited;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
             
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        
        for(int i=0; i<t; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	n = Integer.parseInt(st.nextToken());
        	m = Integer.parseInt(st.nextToken());
        	k = Integer.parseInt(st.nextToken());
        	
        	isVisited = new boolean[n][m];
            adjMatrix = new int[n][m];
             
             
             // 배추 입력받기 
            for(int j=0; j<k; j++) {
             	st = new StringTokenizer(br.readLine());
             	int x = Integer.parseInt(st.nextToken());
             	int y = Integer.parseInt(st.nextToken());
             	adjMatrix[x][y] = 1;
             }
             
             int cnt = 0;
             for(int k=0; k<n; k++) {
            	 for(int j=0; j<m; j++) {
            		 if(adjMatrix[k][j] == 1 && !isVisited[k][j]) {
            			 dfs(k,j);
            			 cnt++;
            		 }
            	 }
            	 
             }  	
             sb.append(cnt).append("\n");
        }

         System.out.println(sb);
	
	}
    
	private static void dfs(int x, int y) {
		isVisited[x][y] = true;
		
		//상하좌우로 인접 위치 탐색 
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && ny>=0 && nx < n && ny < m) {
				if(adjMatrix[nx][ny]==1 && !isVisited[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}
		
		
		
	}


}