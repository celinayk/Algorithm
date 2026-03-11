import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n,m,h;
    static boolean[][][] visited;
    static int ans = 0;
    static int[][][] adj;
    static int cnt = 0;
    static int[] dx = {-1, 1, 0, 0, 0,0};
    static int[] dy = {0, 0, -1, 1,0,0};
    static int[] dz = {0,0,0,0,-1,1};
    static Queue<int[]> q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m][h];
        adj = new int[n][m][h];
        q = new LinkedList<>();

        for(int k=0; k<h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < m; j++) {
                    adj[i][j][k] = Integer.parseInt(st.nextToken());
                    if(adj[i][j][k] == 1) {
                        q.add(new int[]{i, j, k});
                    }
                }
            }
        }

        System.out.println(bfs());

    }

    static int bfs () {
        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int cx = tmp[0];
            int cy = tmp[1];
            int cz = tmp[2];

            for(int i=0; i<6; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nz = cz + dz[i];

                if(nx>=0 && ny>=0 && nz>=0 && nx<n && ny<m && nz<h) {
                    if(!visited[nx][ny][nz] && adj[nx][ny][nz]==0) {
                        q.add(new int[]{nx, ny, nz});
                        visited[nx][ny][nz] = true;
                        adj[nx][ny][nz] = adj[cx][cy][cz] + 1; // 날짜 세기
                    }
                }
            }
        }

        for(int k=0; k<h; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(adj[i][j][k]==0) {
                        return -1;
                    }
                    ans = Math.max(ans, adj[i][j][k]);
                }
            }
        }

        if(ans ==1) {
            return 0;
        } else {
            return ans-1;
        }








    }



}

