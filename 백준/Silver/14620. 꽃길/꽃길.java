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
	static int[][] arr;
	static boolean[][] visited;
	static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n][n];
        visited = new boolean[n][n];
        
        StringTokenizer st;
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<n; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        
        dfs(0,0);
        System.out.println(result);
        
    }
	private static void dfs(int cnt, int sum) {
//		visited[x][y] = true;
//		
//		// 꽃 하나 상하좌우로 값 더함 
//		int sum=arr[x][y];
//		for(int i=0; i<4; i++) {
//			int nx = dx[i]+x;
//			int ny = dy[i]+y;
//			
//			sum+=arr[nx][ny];
//		}
		
		if(sum>=result) return;
		if(cnt ==3) {
			result = Math.min(result, sum); 
		}
		else {
			for(int i=1; i<n-1; i++) {
				for(int j=1; j<n-1; j++) {
					if(!visited[i][j] && checkVisit(i,j)) {
						int cost = sumCost(i,j); 
						dfs(cnt+1, sum+cost);
						clearVisit(i,j);
					}
				}
			}
		}
		
		
	}
	private static void clearVisit(int x, int y) {
		for(int i=0; i<4; i++) {
			visited[x+dx[i]][y+dy[i]] = false;
		}
		visited[x][y] = false;
		
	}
	
	private static int sumCost(int x, int y) {
		int sum = arr[x][y];
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			sum+=arr[x+dx[i]][y+dy[i]];
			visited[x+dx[i]][y+dy[i]] = true;
		}
		return sum;
	}
	
	private static boolean checkVisit(int x, int y) {
		for(int i=0; i<4; i++) {
			if(visited[x+dx[i]][y+dy[i]]) {
				return false; //상하좌우 체크해서 방문한 기록이 있으면 false
			}
		}
		return true;
	}
    

	
	
	
	

}

