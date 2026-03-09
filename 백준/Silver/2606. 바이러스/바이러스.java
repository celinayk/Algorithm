import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
    static int n,m;
    static boolean[] visited;
    static LinkedList<Integer>[] adj;
    static int cnt = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()); //컴퓨터의 수
        m = Integer.parseInt(br.readLine()); //네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수

        visited = new boolean[n+1];
        adj = new LinkedList[n+1];

        for(int i=0; i<=n; i++) {
            adj[i] = new LinkedList<Integer>();
        }

        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        dfs(1);
        System.out.println(cnt);
    }

    private static void dfs(int i) {
        visited[i] = true;

        for(int k: adj[i]) {
            if(!visited[k]) {
                cnt++;
                dfs(k);
            }
        }
    }



}

