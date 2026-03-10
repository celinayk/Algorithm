import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n,m;
    static boolean[][] visited;
    static int[][] adj;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int ans = 0;
    static Queue<int[]>q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        // 배열 초기화
        visited = new boolean[n][m];
        adj = new int[n][m];
        q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
                if(adj[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        System.out.println(bfs());


    }

    public static int bfs() {
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int cx = tmp[0];
            int cy = tmp[1];

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m) {
                    if(!visited[nx][ny] && adj[nx][ny]==0) {
                        q.offer(new int[]{nx,ny});
                        visited[nx][ny] = true;
                        adj[nx][ny] = adj[cx][cy]+1;
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(adj[i][j]==0) { // 익지 않은 토마토가 남아 있는 경우
                    return -1;
                }
                ans = Math.max(ans, adj[i][j]);
            }
        }

        if(ans==1) {
            return 0;
        } else {
            return ans-1;
        }


    }


}

