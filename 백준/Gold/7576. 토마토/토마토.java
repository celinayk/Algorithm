import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	static int m,n;
	static int [][]arr;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int cnt=0;
	static Queue<int[]> q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        arr = new int[n][m];

        //그래프 초기화 
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<m; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());
        		if(arr[i][j] == 1) {
        			q.add(new int[] {i,j});
        		}
        	}
        }
        System.out.println(bfs());
        
        
    }
    

	
	private static int bfs() {
		while(!q.isEmpty()) {
			int tmp[]=q.poll();
			int cx = tmp[0]; //현재 x좌표
			int cy = tmp[1]; //현재 y좌표

			
			for(int i=0; i<4; i++) {
				int nx = cx + dx[i]; //이동할 좌표 상하좌우
				int ny = cy + dy[i];
				
				if(nx<n && nx>=0 && ny<m && ny>=0) {
					if(arr[nx][ny]==0) {
						q.add(new int[] {nx,ny});
						arr[nx][ny] = arr[cx][cy]+1; //날짜 더하기 
						
						
					}
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]==0) {
					return -1; //그래프에 0이존재하면 안익은게 있는거니까 -1
				}
				cnt= Math.max(cnt, arr[i][j]); //그래프에서 가장 큰수가 날짜임
			}
		}
		
		//처음부터 모든 토마토가 익어있다면
		if(cnt==1) {
			return 0;
		}
		else {
			return cnt-1;
		}
	}
	
	

}

