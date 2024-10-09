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
	static int[][] arr;
	static int ans =0;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	static Set<String> num;
	   public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;

	        arr = new int[5][5];

	        for(int i=0; i<5; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	for(int j=0; j<5; j++) {
	        		arr[i][j] = Integer.parseInt(st.nextToken());
	        	}        
	        }
	        
	        num = new HashSet<>();
	        for(int i=0; i<5; i++) {
	        	for(int j = 0; j<5; j++) {
	        		dfs(i,j,0, "");	 

	        	}
	        }
	        System.out.println(num.size());
	}
	   
	private static void dfs(int x, int y, int len, String current) {
		current+=arr[x][y];
		if(len==5) {
			num.add(current);
			return;
		}
		
		//상하 좌우 탐색
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<5 && ny<5) {
				dfs(nx,ny,len+1, current);
			}
		}
	}
}