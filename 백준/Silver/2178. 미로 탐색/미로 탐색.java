import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int n,m;
	static int[][] arr;
	static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++) {
        	String line = br.readLine();
        	for(int j=0; j<m; j++) { 
        		arr[i][j] = line.charAt(j)-'0';
        	}
        }
        bfs(0,0);
        System.out.println(arr[n-1][m-1]);
        
    }
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y] = true;
		
		
		while(!q.isEmpty()) {
			int []tmp = q.poll();
			int cx = tmp[0];
			int cy = tmp[1];
			
			
			for(int i=0; i<4; i++) {
				int nx = dx[i]+cx;
				int ny = dy[i]+cy;
		
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(!visited[nx][ny] && arr[nx][ny]==1) {
						q.add(new int[] {nx,ny});
						visited[nx][ny] = true;
						arr[nx][ny] = arr[cx][cy]+1;
					}
				}
			}
		}
		
	}
	

}

