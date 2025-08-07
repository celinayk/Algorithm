import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static long ans = 0;
    static LinkedList<int[]>[] adjList;
    static int cnt = 0;
    static boolean[] visited;
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        visited = new boolean[n+1];
        adjList = new LinkedList[n+1];

        for(int i=1; i<=n; i++) {
            adjList[i] = new LinkedList<>(); //인접리스트 초기화
        }

        for(int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken()); //거리
            adjList[a].add(new int[] {b, c});
            adjList[b].add(new int[] {a, c});
        }

        dfs(1,0); //1번 노드부터 방문, 누적거리 0
        System.out.println(ans);
    }

    private static void dfs(int cur, long dist) {
        visited[cur] = true;
        ans = Math.max(ans, dist);

        for(int[] k: adjList[cur])  {
            int next = k[0];
            int cost = k[1];
            if (!visited[next]) {
                dfs(next, dist + cost); // 거리 누적
            }
        }

    }
}