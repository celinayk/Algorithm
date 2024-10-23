import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static char[][] arr;
	static boolean[][] visited;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        visited = new boolean[n][n];
        
 
        for(int i=0; i<n; i++) {
        	String line = br.readLine();
        	for(int j=0; j<n; j++) {
        		arr[i][j] = line.charAt(j);
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        int cnt=0;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(!visited[i][j]) {
        			dfs(i,j);
        			cnt++;
        		}
        	}
        }
        sb.append(cnt);
        sb.append(" ");
        
        visited = new boolean[n][n];
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(arr[i][j]=='G') {
        			arr[i][j] = 'R';
        		}
        	}
        }
        
        int cnt2=0;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(!visited[i][j]) {
        			dfs(i,j);
        			cnt2++;
        		}
        	}
        }
        sb.append(cnt2);
        System.out.println(sb);
        
        
    }

	private static void dfs(int x, int y) {
		visited[x][y] = true;
		char now = arr[x][y];
		
		for(int i=0; i<4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			
			if(nx<n && ny<n && nx>=0 && ny>=0) {
				if(!visited[nx][ny]) {
					if(arr[nx][ny]==now) {
						dfs(nx,ny);
					}
				}
			}
		}
		
	}
	
}

