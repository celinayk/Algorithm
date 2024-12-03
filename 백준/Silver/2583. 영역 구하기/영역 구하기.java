import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	static int m,n,k,x1,x2,y1,y2;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k =  Integer.parseInt(st.nextToken());
        
        arr = new int[m][n];
        visited = new boolean[m][n];
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		arr[i][j] = 0;
        	}
        }
        
        for(int i=0; i<k; i++) {
        	st = new StringTokenizer(br.readLine());
        	x1 = Integer.parseInt(st.nextToken());
        	y1 = Integer.parseInt(st.nextToken());
        	x2 = Integer.parseInt(st.nextToken());
        	y2 = Integer.parseInt(st.nextToken());
        	
        	
        	int x_min = Math.min(x1, x2);
			int x_max = Math.max(x1, x2);
			int y_min = Math.min(y1, y2);
			int y_max = Math.max(y1, y2);
			
			for(int j = x_min; j < x_max; j++) {
				for(int k = y_min; k < y_max; k++) {
					arr[k][j] = 1;
				}
			}
        	
        }
        
        int ans=0;
        List<Integer> li = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(arr[i][j]==0 && !visited[i][j]) {
        			int tmp = dfs(i,j);
        			li.add(tmp);

        			ans++;
        		}
        	}
        	
        }
        System.out.println(ans);
        Collections.sort(li);
        for(int x: li) {
        	System.out.print(x+ " ");
        }
     
        
        
    }
	private static int dfs(int x, int y) {
		visited[x][y] = true;
		
		int num=1;
		for(int i=0; i<4; i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			
			if(nx>=0 && ny>=0 && nx<m && ny<n ) {
				if(arr[nx][ny]==0 && !visited[nx][ny]) {
					
					num+=dfs(nx,ny);
				}
			}
			
		}
		return num;
	}
}

