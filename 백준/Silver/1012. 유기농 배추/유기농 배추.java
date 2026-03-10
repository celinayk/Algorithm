import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int t,n,m,k;
    static int cnt=0;
    static boolean[][] visited;
    static int[][] adj;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       t = Integer.parseInt(br.readLine());

       // 테스트 케이스 개수만큼 루프
       for(int i = 0; i < t; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           n = Integer.parseInt(st.nextToken()); // 10
           m = Integer.parseInt(st.nextToken()); // 8
           k = Integer.parseInt(st.nextToken()); // 17
           //배열 초기화
           visited = new boolean[m][n]; //8행 10열
           adj = new int[m][n];

           for(int j=0; j<k; j++) {
               st = new StringTokenizer(br.readLine());
               int u  = Integer.parseInt(st.nextToken()); //열
               int v = Integer.parseInt(st.nextToken()); //행
               adj[v][u] = 1;
           }


           cnt = 0;
           // dfs수행
           for(int x=0; x<n; x++) {
               for(int y=0; y<m; y++) {
                   if(!visited[y][x] && adj[y][x] == 1) {
                       dfs(y,x);
                       cnt++;
                   }
               }

           }
           System.out.println(cnt);
       }

    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx =  x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<m && ny<n) {
                if(adj[nx][ny]==1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }


    }
}

