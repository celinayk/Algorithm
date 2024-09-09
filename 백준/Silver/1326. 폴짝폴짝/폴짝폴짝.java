import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
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

	static boolean[] isVisited;
	static int[] arr;
	static int cnt,a,b,n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        
       n = Integer.parseInt(br.readLine());
        arr= new int[n+1];
        isVisited = new boolean[n+1];
        
        //징검다리에 적힌 번호 따로 저장 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
      
        
        if(a==b) {
        	System.out.println(0);
        }
        else {
        	System.out.println(bfs());
        }
        
       
        
    }
	private static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {a,0});
		//시작 지점 방문 처리 
		isVisited[a] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int num = arr[cur[0]]; //현재 징검다리에서 점프할 수 있는 거리 
			int next = cur[0]; //현재 위치 
			
			// 순방향 
			while(true) {
				next+=num; //점프거리 더해서 다음 위치 계산
				if(next > n) break; //배열 범위 벗어나면 종료 
				if(isVisited[next]) continue;
				isVisited[next] = true; 
				
				if(next == b) {
					return cur[1] + 1;
				}
				
				q.add(new int[] {next, cur[1]+1});
			}
			
			next = cur[0]; 
			// 역방향
			while(true) {
				next-=num; //점프거리 더해서 다음 위치 계산
				if(next < 1) break; //배열 범위 벗어나면 종료 
				if(isVisited[next]) continue;
				isVisited[next] = true; 
				
				if(next == b) {
					return cur[1] + 1;
				}
				
				q.add(new int[] {next, cur[1]+1});
			}
			
		}
		return -1;
		
	}
}

