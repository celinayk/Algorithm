import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	static int[][] adjMatrix;
	static boolean[][] isVisited;
	static int[] arr;
	static int cnt,n;;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        
        n = Integer.parseInt(br.readLine()); 
        
        adjMatrix = new int[n][n];
        isVisited = new boolean[n][n];
        
        StringTokenizer st;
        
        for(int i=0; i<n; i++) {
        	String line = br.readLine();
        	for(int j=0; j<n; j++) {		
        		adjMatrix[i][j] = line.charAt(j)- '0';
        	}			
        }
        
        List<Integer> sizes = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(adjMatrix[i][j] == 1 && !isVisited[i][j]) {
        			cnt=0;
        			dfs(i,j);
        			 sizes.add(cnt);
        		}
        	}
        }
        
        Collections.sort(sizes); 
        System.out.println(sizes.size());
        for(int k : sizes) {
        	System.out.println(k + " ");
        }
       
        
    }
    
    private static void dfs(int x, int y) {
    	isVisited[x][y] = true;
    	cnt++;
    	
    	for(int i=0; i<4; i++) {
    		int nx = x + dx[i];
    		int ny = y + dy[i];
    		if(nx>=0 && ny>=0 && nx<n && ny<n ) {
    			if(adjMatrix[nx][ny] == 1 && !isVisited[nx][ny]) {
    				dfs(nx,ny);
    			}
    		}
    	}
    }
	
}

