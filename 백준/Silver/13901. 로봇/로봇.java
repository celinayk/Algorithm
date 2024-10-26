import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int r, c;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited = new boolean[r][c];

        // 장애물 입력
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            visited[x][y] = true; // 장애물로 방문 처리
        }

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        visited[startX][startY] = true; // 시작 위치 방문 처리

        int[] order = new int[4];
        st = new StringTokenizer(br.readLine());
        // 이동 방향 입력받기
        for (int i = 0; i < 4; i++) {
            order[i] = Integer.parseInt(st.nextToken()) - 1; // 1-based to 0-based
        }

        moveRobot(startX, startY, order);
    }

    private static void moveRobot(int x, int y, int[] order) {
        int dir = 0; // 초기 방향 설정

        while (true) {
            boolean moved = false; // 이동 여부 초기화

            // 현재 방향부터 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nowDir = (dir + i) % 4; // 현재 방향
                int nx = x + dx[order[nowDir]]; // 다음 x 좌표
                int ny = y + dy[order[nowDir]]; // 다음 y 좌표

                // 범위 및 방문 체크
                if (nx >= 0 && ny >= 0 && nx < r && ny < c && !visited[nx][ny]) {
                    // 이동 가능
                    x = nx; // 좌표 업데이트
                    y = ny; // 좌표 업데이트
                    visited[x][y] = true; // 방문 처리
                    dir = nowDir; // 방향 업데이트
                    moved = true; // 이동 상태 표시
                    break; // 이동한 후 루프 종료
                }
            }

            // 이동하지 못했다면 탐색 종료
            if (!moved) {
                break;
            }
        }

        // 최종 위치 출력
        System.out.println(x + " " + y);
    }
}
