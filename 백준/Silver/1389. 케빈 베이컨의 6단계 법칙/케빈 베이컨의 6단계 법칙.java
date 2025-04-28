import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static int N, M;
    static int[] visited;
    static LinkedList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        adjList = new LinkedList[N + 1];

        // 인접리스트 초기화
        for (int i = 1; i <=N; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        // 인접리스트 할당
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        solution();


    }

    private static void solution() {
        int minCnt = Integer.MAX_VALUE, minIdx = 0;
        // 유저의 수만큼 반복문을 돌린다.
        for (int i = 1; i <= N; i++) {
            int cnt = bfs(i); // 1부터 bfs호출하고 2, 3,,,,4 ,,,
            if (minCnt > cnt) {
                minCnt = cnt;
                minIdx = i;
            }
        }
        System.out.println(minIdx);
    }

    private static int bfs(int start) {
        Arrays.fill(visited, -1);
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = 0; //시작 노드의 거리는 0

        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int neighbor : adjList[tmp]) {
                if (visited[neighbor] != -1) continue;
                visited[neighbor] = visited[tmp] + 1;
                cnt += visited[neighbor];
                q.add(neighbor);
            }

        }
        return cnt;
    }
}
