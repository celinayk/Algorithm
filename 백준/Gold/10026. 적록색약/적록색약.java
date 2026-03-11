import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static boolean[][] visited;
    static int[][] adj;
    static int cnt = 0;
    static int ans = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visited = new boolean[n][n];
        adj = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                adj[i][j] = line.charAt(j);
            }
        }

        // 정상인
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        System.out.print(cnt+ " ");

        // 적록색약
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(adj[i][j] == 'G') {
                    adj[i][j] = 'R';
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    dfs(i,j);
                    ans++;
                }
            }
        }
        System.out.println(ans);

    }

    static void dfs(int x, int y) {
        visited[x][y] = true; // r,r

        for(int i=0; i<4; i++) {
            int nx =  x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny]) {
                if(adj[nx][ny] == adj[x][y]) { // 같은 색상이면 r=r / g=g / b=b
                    dfs(nx,ny);
                }
            }
        }
    }


}

