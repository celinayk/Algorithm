import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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

	static boolean[][] isVisited;
	static int[][] arr;
	static int w,h;
	static int[] dx = {-1,1,0,0,-1,-1,1,1};
	static int[] dy = {0,0,-1,1,-1,1,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        StringBuilder sb = new StringBuilder();
        
        while(true) {
        	String[] input = br.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);
            
            if (w == 0 && h == 0) break;
            
            isVisited = new boolean[h][w];
            arr = new int[h][w];
            
            //배열 채우기 
            for(int i=0; i<h; i++) {
            	StringTokenizer st = new StringTokenizer(br.readLine());
            	for(int j=0; j<w; j++) {
            		arr[i][j] = Integer.parseInt(st.nextToken());
            	}
            }
            
            int cnt=0;
   
            for(int i=0; i<h; i++) {
            	for(int j=0; j<w; j++) {
            		if(arr[i][j] == 1 && !isVisited[i][j]) {
            			dfs(i,j);
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
		
		for(int i=0; i<8; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && ny>=0 && nx<h && ny<w) {
				if(arr[nx][ny]==1 && !isVisited[nx][ny]) {
					dfs(nx,ny);
				}
			}
		}
		
	}
	
		
	
}

