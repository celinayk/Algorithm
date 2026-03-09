import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
    static int n,m;
    static int cnt = 0;
    static boolean[][] visited;
    static int[][] adj;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 초기화
        adj = new int[n][m];
        visited = new boolean[n][m];

        // 입력 받기
        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                adj[i][j] = line.charAt(j) - '0';
            }
        }
        bfs(0,0); // 시작은 (1,1)부터 시작
        System.out.println(adj[n-1][m-1]);

    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int cx = tmp[0];
            int cy = tmp[1];

            for(int k=0; k<4; k++) {
                int nx = dx[k] + cx;
                int ny = dy[k] + cy;

               if(nx>=0 && ny>=0 && nx<n && ny <m) {
                   if(adj[nx][ny] == 1 && !visited[nx][ny]) {
                       q.offer(new int[]{nx, ny});
                       visited[nx][ny] = true;
                       // 여기 중요
                       adj[nx][ny] = adj[cx][cy] + 1;
                   }
               }
            }
        }

    }



}

