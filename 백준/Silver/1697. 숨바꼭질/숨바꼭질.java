import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n,k;
    static int ans=0;
    static int[] arr;
    static boolean[] visited;
    static int[] pos = {-1,1,2};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        visited = new boolean[100001];
        bfs();



    }
    public static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == k) { // 현재 위치가 이미 동생의 위치와 동일하면
                System.out.println(arr[now]);
            }
            for (int i = 0; i < 3; i++) {
                int next;
                if (pos[i] == 2) {
                    next = now * pos[i];
                } else {
                    next = now + pos[i];
                }

                if (next <= 100000 && next >= 0 && !visited[next]) {
                    q.add(next);
                    visited[next] = true;
                    arr[next] = arr[now] + 1;
                }
            }
        }


    }

}

