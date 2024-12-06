
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int n;
	static int max = 0;
    static int cnt = 0;
	static int[][] arr;
	static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n][n];
        visited = new boolean[n][n];
        StringTokenizer st;
        int maxheight=0;
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<n; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		maxheight=Math.max(maxheight, arr[i][j]);
        		
        	}
        }
        
      
        //높이 0부터 최대높이까지 
        for(int k=0; k<=maxheight; k++) {
        	cnt=0;
        	for(int i=0; i<n; i++) {
        		for(int j=0; j<n; j++) {
        			if(arr[i][j]<=k) { //높이보다 작은 칸은 침수 
        				visited[i][j]= false;
        			}
        			else {
        				visited[i][j]=true;
        			}
        		}
        	}
        	
        	for(int i=0; i<n; i++) {
            	for(int j=0; j<n; j++) {
            		if(visited[i][j]==true) {
            			cnt++;
            			dfs(i,j);
            		}
            	}
            }
            max=Math.max(cnt, max);
        }
        System.out.println(max);
        
        
    }
	private static void dfs(int x, int y) {
		visited[x][y] = false;
		
		for(int i=0; i<4; i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			
			if(nx>=0 && ny>=0 && nx<n && ny<n) {
				if(visited[nx][ny]==true) {
					dfs(nx,ny);
				}
			}
		}
		
	}


}

