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
	static int n;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
   
        arr = new int[n][n];
        isVisited = new boolean[n][n];
        
        for(int i=0; i<n; i++) {
        	String line = br.readLine();
        	for(int j=0; j<n; j++) {
        		char ch = line.charAt(j);
        		if (ch == 'R') {
                    arr[i][j] = 0;
                } else if (ch == 'G') {
                    arr[i][j] = 1;
                } else if (ch == 'B') {
                    arr[i][j] = 2;
                }
        	}
        }
        
        
        
        int red=0;
        int green=0;
        int blue=0;
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++ ) {
        		if(arr[i][j]==0&& !isVisited[i][j]) {
        			dfs0(i,j);
        			red++;
        		}     		
        	}
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++ ) {
        		if(arr[i][j]==1&& !isVisited[i][j]) {
        			dfs1(i,j);
        			green++;
        		}     		
        	}
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++ ) {
        		if(arr[i][j]==2&& !isVisited[i][j]) {
        			dfs2(i,j);
        			blue++;
        		}     		
        	}
        }
        
        int cnt1=0;
        cnt1=red+green+blue;
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(isVisited[i], false);
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                } 
        	}
        }
        
        red=0;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++ ) {
        		if(arr[i][j]==0&& !isVisited[i][j]) {
        			dfs0(i,j);
        			red++;
        		}     		
        	}
        }
        
        blue=0;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++ ) {
        		if(arr[i][j]==2&& !isVisited[i][j]) {
        			dfs2(i,j);
        			blue++;
        		}     		
        	}
        }
        
        int cnt2= 0;
        cnt2=red+blue;
        
        System.out.println(cnt1+ " "+ cnt2);
       
       
        
    }


	private static void dfs0(int x, int y) {

		isVisited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && ny>=0 && nx < n && ny < n) {
				if(arr[nx][ny]==0 && !isVisited[nx][ny]) {
					dfs0(nx,ny);
				}
				
			}
			
			
		}
		
	}	
	private static void dfs1(int x, int y) {

		isVisited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && ny>=0 && nx < n && ny < n) {
				if(arr[nx][ny]==1 && !isVisited[nx][ny]) {
					dfs1(nx,ny);
				}
				
			}
			
			
		}
		
	}	
	private static void dfs2(int x, int y) {

		isVisited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=0 && ny>=0 && nx < n && ny < n) {
				if(arr[nx][ny]==2 && !isVisited[nx][ny]) {
					dfs2(nx,ny);
				}
				
			}
			
			
		}
		
	}	
}

