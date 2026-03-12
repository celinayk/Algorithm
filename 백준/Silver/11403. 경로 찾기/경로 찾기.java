import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static boolean[][] visited;
    public static int[][] map;
    public static int N;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];

        for (int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++){
            BFS(i);
        }

        System.out.print(sb);
    }

    public static void BFS(int node){
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();

        q.add(node);
        while (!q.isEmpty()){
            int curr = q.poll();
            for (int i = 1; i <= N; i++){
                if (!visited[i] && map[curr][i] == 1){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        for (int i = 1; i <= N; i++){
            if (visited[i]) sb.append("1 ");
            else sb.append("0 ");
        }
        sb.append("\n");
    }

}

