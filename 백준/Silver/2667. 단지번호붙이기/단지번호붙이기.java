import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static int cnt=0;
    static boolean[][] visited;
    static int[][] adj;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static LinkedList<Integer> ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        // 배열 초기화
        visited = new boolean[n][n];
        adj = new int[n][n];
        ans = new LinkedList<Integer>();

        // 단지 입력 받기
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                adj[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(adj[i][j] == 1 && !visited[i][j]) {
                    cnt = 1;
                    ans.add(dfs(i,j));
                }
            }
        }

        System.out.println(ans.size());

        for(int i=0; i<ans.size(); i++) {
            Collections.sort(ans);
            System.out.println(ans.get(i));
        }

    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;

        for(int k=0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx>=0 && ny>=0 && nx<n && ny<n) {
                if(!visited[nx][ny] && adj[nx][ny]==1) {
                    cnt++; // 각 단지에 속하는 집의 수
                    dfs(nx, ny);
                }
            }
        }
        return cnt;
    }




}

