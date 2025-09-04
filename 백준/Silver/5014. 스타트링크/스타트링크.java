import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static boolean[] visited;
    static int[] arr;
    static int f,s,g,u,d;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        arr = new int[1000001];
        visited = new boolean[1000001];

        int ans=bfs();
        if(ans==-1) {
            System.out.println("use the stairs");
        }
        else {
            System.out.println(ans);
        }

    }

    private static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s, 0});
        visited[s] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll(); // 현재 위치
            int cur = now[0];
            int cnt = now[1];

            if(cur==g) {
                return cnt;
            }

            // 올라가는 경우
            // 해당층을 방문하지 않았고 f를 초과하지 않음
            if(cur+u<=f && !visited[cur+u]) {
                q.offer(new int[]{cur+u, cnt+1});
                visited[cur+u] = true;
            }
            //내려가는 경우
            if(cur-d>0 && !visited[cur-d]) {
                q.offer(new int[]{cur-d, cnt+1});
                visited[cur-d] = true;
            }

        }

        return -1;
    }


}

