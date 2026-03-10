import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n,m;
    static int cnt = 0;
    static boolean[] visited;
    static LinkedList<Integer>[] adj;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 초기화
        visited = new boolean[n+1];
        adj  = new LinkedList[n+1];

        // 인접 리스트 초기화
        for(int i=0; i<=n; i++) {
            adj[i] = new LinkedList<Integer>();
        }

        for(int i=0; i<m; i++) {
            st =  new StringTokenizer(br.readLine());
            int u =  Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].add(v);
            adj[v].add(u);
        }

        for(int i=1; i<=n; i++) {
            if(!visited[i]) {
                dfs(i);
                cnt++;
            }
        }
        System.out.println(cnt);


    }

    private static void dfs(int k) {
        visited[k] = true;

        for (int i : adj[k]) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

}

