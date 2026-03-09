import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
    static int n,m,v;
    static boolean[] visited;
    static LinkedList<Integer>[] adj;
    static int cnt = 0;
    static StringBuilder sb;
    static StringBuilder sd;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());


        visited = new boolean[n+1];
        adj = new LinkedList[n+1];
        sb = new StringBuilder();
        sd = new StringBuilder();

        for(int i=0; i<=n; i++) {
            adj[i] = new LinkedList<Integer>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        for(int i=1; i<=n; i++) {
            Collections.sort(adj[i]);
        }

        dfs(v);
        System.out.print(v+ " ");
        System.out.println(sd);
        visited = new boolean[n+1];

        bfs(v);
        System.out.print(v+ " ");
        System.out.println(sb);
    }


    private static void dfs(int i) {
        visited[i] = true;

        for(int k: adj[i]) {
            if(!visited[k]) {
                sd.append(k+ " ");
                dfs(k);
            }
        }
    }

    private static void bfs(int i) {
        Queue<Integer>q = new LinkedList<Integer>();
        q.offer(i);
        visited[i] = true;
        while(!q.isEmpty()) {
            int tmp = q.poll();

            for(int k: adj[tmp]) {
                if(!visited[k]) {
                    q.offer(k);
                    sb.append(k+ " ");
                    visited[k] = true;
                }
            }
        }
    }




}

