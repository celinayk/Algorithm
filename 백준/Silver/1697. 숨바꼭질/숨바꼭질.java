import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	static int n,k;
	static int []arr;
	static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[100001];
        visited= new boolean[100001];
        
        System.out.println(bfs());
        
        
    }
	private static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {n, 0});
		visited[n] = true;
		
		while(!q.isEmpty()) {
			int[] tmp=q.poll();
			int now=tmp[0]; //수빈이의 현 위치
			int cnt = tmp[1]; //수빈이의 이동 횟수 
			
			if(now==k) {
				return cnt;
			}
			
			int go = now+1;
			if(go <= 100000 && !visited[go] ) { //새로운 이동위치가 방문하지 않고 범위초과안한다면
				visited[go] = true;
				q.add(new int[] {go,cnt+1});
			}
			
			int back = now-1;
			if(back >= 0 && !visited[back] ) { //새로운 이동위치가 방문하지 않고 범위초과안한다면
				visited[back] = true;
				q.add(new int[] {back,cnt+1});
			}
			
			int jump = now*2;
			if(jump <= 100000 && !visited[jump] ) { //새로운 이동위치가 방문하지 않고 범위초과안한다면
				visited[jump ] = true;
				q.add(new int[] {jump ,cnt+1});
			}
			
		}
		return -1;
	}
	

}

