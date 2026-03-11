import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n,m;
    static int max = 0;
    static int[][] adj;
    static int[][] copy;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adj = new int[n][m];

        // 1. 그래프 입력 받기
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽 3개를 세울 수 있는 모든 경우의 수로 조합 > 백트래킹
        setWall(0);
        System.out.println(max);
    }

    private static void setWall(int cnt) {
        if(cnt ==3) {
            // + 복사본 만들기 > 여러 조합들도 시도해야하니까
            copy = new int[n][m];
            for(int i=0; i<n; i++) {
                copy[i] = adj[i].clone();
            }
            // 3. bfs 탐색으로 바이러스 퍼지기
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(copy[i][j] == 2) {
                        bfs(i,j);
                    }
                }
            }

            // 4. 안전영역의 크기 구하기 ( = 0인거)
            int ans = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(copy[i][j] == 0) {
                        ans++;
                    }
                }
            }
            max = Math.max(ans, max);
            return;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(adj[i][j] == 0) {
                    adj[i][j] = 1; // 벽 세우기
                    setWall(cnt+1);
                    adj[i][j] = 0; // 되돌리기
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{x,y});

        while(!q.isEmpty()) {
            int[] tmp = q.poll();
            int cx = tmp[0];
            int cy = tmp[1];

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m) {
                    if(copy[nx][ny] == 0) {
                        q.add(new int[]{nx,ny});
                        copy[nx][ny] = 2;
                    }
                }
            }
        }
    }
}

