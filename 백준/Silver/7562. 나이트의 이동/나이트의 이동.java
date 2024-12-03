import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int l;
	static int dx[] = {-2,-1,1,2,2,1,-1,-2};
	static int dy[] = {-1,-2,-2,-1,1,2,2,1};
	static int start_x, start_y, finish_x, finish_y;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        for(int t=0; t<T; t++) {
        	l = Integer.parseInt(br.readLine());
        	arr=new int[l][l];
        	visited = new boolean[l][l];
        	
        	
        	st = new StringTokenizer(br.readLine());
        	start_x = Integer.parseInt(st.nextToken());
        	start_y = Integer.parseInt(st.nextToken());
        	
        	st = new StringTokenizer(br.readLine());
        	finish_x = Integer.parseInt(st.nextToken());
        	finish_y = Integer.parseInt(st.nextToken());
        	
        	bfs();
        	sb.append(arr[finish_x][finish_y]).append("\n");
        	
        }
        System.out.println(sb);
    }
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {start_x,start_y});
		visited[start_x][start_y] = true;
		

		while(!q.isEmpty()) {
			int[] now= q.poll();
			int cx = now[0];
			int cy = now[1];
			
			for(int i=0; i<8; i++) {
				int nx = dx[i]+cx;
				int ny = dy[i]+cy;
				
				if(nx>=0 && ny>=0 && nx<l && ny<l) {
					if(!visited[nx][ny]) {
						q.add(new int[] {nx,ny});
						visited[nx][ny] = true;
						arr[nx][ny] = arr[cx][cy]+1;
					}
				}
			}
		}
		
		
	}
	
}

