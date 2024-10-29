import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[h][w];
        
        // 배열을 -1로 초기화
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                arr[i][j] = -1;
            }
        }
        
        // 각 행을 처리
        for (int i = 0; i < h; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                if (tmp[j] == 'c') { // 구름 위치를 확인
                    int cloud = 0;
                    for (int k = j; k < w; k++) { // 오른쪽으로 구름의 거리 계산
                        arr[i][k] = cloud;
                        cloud++;
                    }
                    
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
