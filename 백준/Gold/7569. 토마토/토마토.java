import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Long.MAX_VALUE;

public class Main {
    static int m,n,h,day;
    static int[][][] arr;
    static boolean[][][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        m =  Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[h][n][m];
        visited = new boolean[h][n][m];

        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < m; x++) {
                    arr[z][y][x] = Integer.parseInt(st.nextToken());
                    if (arr[z][y][x] == 1) {
                        q.add(new int[]{z, y, x}); // 큐에도 (z,y,x) 순서로
                        visited[z][y][x] = true;
                    }
                }
            }
        }


        System.out.println(bfs());

    }

    private static int bfs() {
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int z = now[0];
            int y = now[1];
            int x = now[2];

            for(int i=0; i<6; i++) {
                int nz = z+dz[i];
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx>=0 && nx<m && ny>=0 && ny<n && nz>=0 && nz<h) {
                    if(arr[nz][ny][nx] == 0 && !visited[nz][ny][nx]) {
                        visited[nz][ny][nx]= true;
                        q.add(new int[]{nz,ny,nx});
                        arr[nz][ny][nx] =arr[z][y][x]+1;
                    }
                }
            }
        }

        for(int z=0; z<h; z++) {
            for(int y=0; y<n; y++) {
                for(int x=0; x<m; x++) {
                    if(arr[z][y][x]==0) {
                        return -1;
                    }
                    day = Math.max(day, arr[z][y][x]);
                }
            }
        }
        if(day==1) {
            return 0;
        } else {
            return day-1;
        }
    }


}

