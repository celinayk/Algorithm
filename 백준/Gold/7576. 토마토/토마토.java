import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.Collections;

public class Main {
    static int n,m,day;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                arr[i][j] =  Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    q.add(new int[]{i,j});
                }
            }
        }

        System.out.println(bfs());


        // 처음부터 토마토가 전부 익었으면 0

        // 토마토가 모두 익지 못하는 상황이면 -1



    }

    private static int bfs() {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];

            for(int i=0; i<4; i++) {
                int nx = cx+dx[i];
                int ny = cy+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m ) {
                    if(arr[nx][ny]==0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx,ny});
                        arr[nx][ny] = arr[cx][cy]+1; // 날짜 더하기
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(arr[i][j]==0) {
                    return -1;
                }
                day = Math.max(day, arr[i][j]);
            }
        }

        if(day==1) {
            return 0;
        } else {
            return day-1;
        }

    }

}

