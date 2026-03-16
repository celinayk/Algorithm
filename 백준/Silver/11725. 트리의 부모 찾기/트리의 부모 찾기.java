import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static ArrayList<Integer>[] arr;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 배열 초기화
        arr = new ArrayList[n+1];
        parent = new int[n+1];
        visited = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());

            int u =  Integer.parseInt(st.nextToken());
            int v =  Integer.parseInt(st.nextToken());

            arr[u].add(v);
            arr[v].add(u);

        }

        sol(1,-1);
        for(int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }
    
    static void sol(int node, int par) {
        Queue<Integer>q = new LinkedList<>();
        q.offer(node);
        visited[node] = true;

        while(!q.isEmpty()) {
            Integer curr = q.poll();

            for(int k : arr[curr]) {
                if(!visited[k]) {
                    parent[k] = curr; // 나를 꺼낸 애가 부모가 나는 자식이다. k입장에서
                    q.offer(k);
                    visited[k] = true;
                }

            }
        }
    }

}

