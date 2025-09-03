import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Collections;

public class Main {
    static int n,m,cnt;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] =  Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Integer> num = new ArrayList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j]==1 && !visited[i][j]) {
                    cnt = 0;
                    int tmp=dfs(i,j);
                    num.add(tmp);
                }
            }
        }


        int ans = 0;
        System.out.println(num.size());
        for (Integer i : num) {
            ans =Math.max(ans,i);
        }
        System.out.println(ans);


    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;
        cnt++;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx>=0 && nx<n && ny>=0 && ny<m) {
                if(arr[nx][ny]==1 && !visited[nx][ny]) {
                    dfs(nx,ny);
                }
            }
        }
        return cnt;
    }

}

