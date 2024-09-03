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
	static int n,m,k,cnt;
	static int[][] adjMatrix;
	static boolean[][]  isVisited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        
        StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	
        isVisited = new boolean[n][m];
        adjMatrix = new int[n][m];
        
        //음식물 좌표 입력 받기 
        for(int i=0; i<k; i++) {
        	st = new StringTokenizer(br.readLine());
        	int x = Integer.parseInt(st.nextToken())-1;
        	int y = Integer.parseInt(st.nextToken())-1;
        	adjMatrix[x][y] = 1;
        }
        
        int ans = 0;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<m; j++) {
        		if(adjMatrix[i][j] == 1 && !isVisited[i][j]) {
        			cnt = 0;
        			dfs(i,j);
        			ans = Math.max(ans, cnt);
        			
        		}
        	}
        }
        
        System.out.println(ans);
        
    }

	private static void dfs(int x, int y) {
		isVisited[x][y] = true;
		cnt++; //현재 위치 포함 
		
		for(int l=0; l<4; l++) {
			int nx = x+dx[l];
			int ny = y+dy[l];
			
			if(nx>=0 && ny>=0 && nx<n && ny<m) {
				if(adjMatrix[nx][ny]==1 && !isVisited[nx][ny]) {
					dfs(nx,ny);
					
				}
			}
		}
		
	}

	

}

