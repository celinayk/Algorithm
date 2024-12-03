import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	static int[] arr;
	static int F,S,G,U,D;
	static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        arr = new int[F+1];
        visited = new boolean[F+1];
        
        int ans=bfs();
        if(ans==-1) {
        	System.out.println("use the stairs");
        }
        else {
        	System.out.println(ans);
        }
        
    }
	private static int bfs() {
		Queue<int[]>q = new LinkedList<>();
		q.add(new int[] {S, 0}); //현재위치와 점프횟수
		visited[S] = true;
		
		while(!q.isEmpty()) {
			int []tmp = q.poll();
			int now =tmp[0]; // 현재 엘베가 위치하는 층 
			int cnt =tmp[1]; //점프 횟수 
			
			if(now==G) {
				return cnt;
			}
			
			//위로 이동
			int up = now+U;
			if(up<=F && !visited[up]) {
				visited[up] = true;
				q.add(new int[] {up,cnt+1});
			}
			
			int down = now-D;
			if(down>=1 && !visited[down]) {
				visited[down] = true;
				q.add(new int[] {down, cnt+1});
			}
			
		}
		return -1;
	}	
}

