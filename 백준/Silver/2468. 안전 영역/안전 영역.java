import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        int max = 0;
        StringTokenizer st;
        // 입력받기
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max=Math.max(arr[i][j], max);
            }
        }

        int ans = 1;
        for(int h=1; h<=max; h++) { // 높이는 배열의 최댓값까지만 보면됨
            visited = new boolean[n][n]; // 루프 돌때마다 방문배열 초기화
            int cnt = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(arr[i][j] <= h) {
                        visited[i][j] = true; // 잠김 처리
                    }
                }
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j]) {
                        dfs(i,j);
                        cnt++;
                    }
                }
            }
            ans = Math.max(cnt, ans);

        }
        System.out.println(ans);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<n && ny<n) {
                if(!visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}

