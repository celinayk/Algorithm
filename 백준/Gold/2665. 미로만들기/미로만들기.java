import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static int[][] arr;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n][n];
        arr = new int[n][n];
        dist = new int[n][n];

        for(int i = 0; i < n; i++) {
           String line = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();
        System.out.println(dist[n-1][n-1]);

    }
    static void bfs() {
        Deque<int[]> dq = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE); // 비용초기화
        }

        dist[0][0] = 0; //시작배열의 거리는 0
        dq.add(new int[]{0,0}); // 큐 삽임

        while(!dq.isEmpty()) {
            int[] tmp = dq.poll();
            int cx = tmp[0];
            int cy = tmp[1];

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<n) {
                    int cost= (arr[nx][ny]==0) ? 1: 0; // 다음칸이 0이면 검은방이라 cost는 1이다.

                    if(dist[cx][cy]+cost < dist[nx][ny]) { // 현재까지의 비용+다음칸비용 < 기존에 기록된 비용
                        dist[nx][ny] = dist[cx][cy]+cost;

                        if(cost == 0) {
                            dq.addFirst(new int[] {nx, ny});
                        } else {
                            dq.addLast(new int[] {nx, ny});
                        }
                    }
                }
            }
        }
    }
}

