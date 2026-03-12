import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n, t;
    static boolean[][] visited;
    static int[][] adj;
    static int start_x, start_y, finish_x, finish_y;
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {-1,-2,-2,-1,1,2,2,1};
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       t = Integer.parseInt(br.readLine());
       for(int k = 0; k < t; k++) {
           // 체스판 크기
           n = Integer.parseInt(br.readLine());

           // 초기화
           visited = new boolean[n][n];
           adj = new int[n][n];

           StringTokenizer st = new StringTokenizer(br.readLine());
           start_x = Integer.parseInt(st.nextToken());
           start_y = Integer.parseInt(st.nextToken());

           st = new StringTokenizer(br.readLine());
           finish_x = Integer.parseInt(st.nextToken());
           finish_y = Integer.parseInt(st.nextToken());

           bfs();
           System.out.println(adj[finish_x][finish_y]);


       }
    }

    static void bfs() {
        Queue<int[]>q = new LinkedList<>();
        q.offer(new int[]{start_x, start_y});
        visited[start_x][start_y] = true;

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int cx = tmp[0];
            int cy = tmp[1];

            for(int i=0; i<8; i++) {
                int nx = cx+ dx[i];
                int ny = cy+ dy[i];

                if(nx >=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny]) {
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    adj[nx][ny] = adj[cx][cy] + 1;
                }

            }
        }
    }


}

