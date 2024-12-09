import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	static int r,c;
	static char[][] arr;
	static boolean[][] visited;
	static int[]dx = {-1,1,0,0};
	static int[]dy = {0,0,-1,1};
	static Queue<int[]> q = new LinkedList<>();;
	static Queue<int[]> water = new LinkedList<>();
	static int answer=Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        arr = new char[r][c];
        visited = new boolean[r][c];
        
        for(int i=0; i<r; i++) {
        	String line = br.readLine();
        	for(int j=0; j<c; j++) {
        		arr[i][j] = line.charAt(j);
        	}
        }
        
        for(int i=0; i<r; i++) {
        	for(int j=0; j<c; j++) {
        		if(arr[i][j]=='S') {
        			q.add(new int[] {i,j,0});
        		}
        		else if(arr[i][j]=='*') {
        			water.add(new int[] {i,j});
        		}
        		
        	}
        }
       bfs();
       System.out.println(answer==Integer.MAX_VALUE?"KAKTUS":answer);
        
        
    }
    
    

	//고슴도치 이동 큐
	private static void bfs() {

		while(!q.isEmpty()) {
			//물 확산(먼저해야함)
			int len = water.size();
			for(int k=0; k<len; k++) {
				int tmp[] = water.poll();
				int cx = tmp[0];
				int cy = tmp[1];
				
				for(int i=0; i<4; i++) {
					int nx = dx[i]+cx;
					int ny = dy[i]+cy;
					
					if(nx>=0 && ny>=0 && nx<r && ny<c) {
						if(arr[nx][ny]=='.' ) { 
							arr[nx][ny]= '*'; //물 확산해줌  
							water.add(new int[] {nx,ny}); 
						}
					
					}
				}	
			}
			
			//고슴도치 이동
			int leng = q.size();
			for(int k=0; k<leng; k++) {
				int tmp[]= q.poll();
				int cx = tmp[0];
				int cy = tmp[1];
				int now = tmp[2];
				
				for(int i=0; i<4; i++) {
					int nx = dx[i]+cx;
					int ny = dy[i]+cy;
					
					if(nx>=0 && ny>=0 && nx<r && ny<c) {
						if(arr[nx][ny]=='D') {
							answer=Math.min(answer,now+1);
                            return;
						}
						else if(arr[nx][ny]=='.') {
							arr[nx][ny] = 'S';
							q.add(new int[] {nx, ny, now+1});
						}
					}
				}
			}
		
		}
		
	}

	

	
	

}

