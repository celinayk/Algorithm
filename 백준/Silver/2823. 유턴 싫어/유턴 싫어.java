import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1}; // 상, 하, 좌, 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];

        // 마을 지도 입력
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        // 막다른 길 탐색
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (arr[i][j] == '.') {  // 길인 경우만 확인
                    int pathCount = 0;

                    // 네 방향 탐색
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        // 지도 범위를 벗어나지 않고, 길(`.`)이 있는 경우
                        if (nx >= 0 && ny >= 0 && nx < r && ny < c && arr[nx][ny] == '.') {
                            pathCount++;
                        }
                    }

                    // 막다른 길 발견 시, 1 출력 후 종료
                    if (pathCount <= 1) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }

        // 막다른 길이 없는 경우 0 출력
        System.out.println(0);
    }
}
