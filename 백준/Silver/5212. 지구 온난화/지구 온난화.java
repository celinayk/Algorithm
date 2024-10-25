import java.io.*;
import java.util.*;

public class Main {
   static char [][] arr;
   static int r,c;
   static int[] dx = {-1,1,0,0};
   static int[] dy = {0,0,-1,1};
   static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
              
        arr = new char[r][c];
        visited = new boolean [r][c];
        for(int i=0; i<r; i++) {
           String line = br.readLine();
           for(int j=0; j<c; j++) {
              arr[i][j] = line.charAt(j);
           }
        }
        
        //잠기는 땅 구하기
        for(int i=0; i<r; i++) {
        	for(int j=0; j<c; j++) {
        		if(arr[i][j]=='X') {
        			check_sea(i,j);
        		}
        	}
        }
        
        //바다로 변환
        for(int i=0; i<r; i++) {
        	for(int j=0; j<c; j++) {
        		if(visited[i][j]==true) {
        			arr[i][j] = '.';
        		}
        	}
        }
        
        //출력해야할 지도 크기 구하기 
        int minX = r;
        int maxX = 0;
        int minY = c;
        int maxY = 0;
        
        for(int i=0; i<r; i++) {
        	for(int j=0; j<c; j++) {
        		if(arr[i][j]=='X') {
        			minX = Math.min(minX, i);
        			maxX = Math.max(maxX, i);
        			minY = Math.min(minY, j);
        			maxY = Math.max(maxY, j);
        		}
        	}
        }
        
        for(int i=minX; i<=maxX; i++) {
        	for(int j=minY; j<=maxY; j++) {
        		System.out.print(arr[i][j]);
        	}
        	System.out.println();
        }
        

        
    }
	private static void check_sea(int x, int y) {
		int cnt =0;
		for(int i=0; i<4; i++) {
			int nx = dx[i]+x;
			int ny = dy[i]+y;
			
			//지도범위를 벗어났다면 바다이므로 cnt증가
			if(nx<0 || ny<0 || nx>=r || ny>=c ) {
				cnt++;
			}
			else {
				if(arr[nx][ny]=='.') {
					cnt++;
				}
			}
		}
		if(cnt>=3) {
			visited[x][y] = true;
		}
	}
   
      
}
   


