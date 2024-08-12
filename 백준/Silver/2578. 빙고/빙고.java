import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int arr[][] = new int[5][5];  
	static int ans = 0;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int cnt=0;
		
		// 빙고판 입력
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//사회자 숫자부름
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				// 사회자가 부른값과 빙고판 숫자가 같으면 0으로 변경
				for(int k=0; k<5; k++) {
					for(int l=0; l<5; l++) {
						if(arr[k][l]==num) {
							arr[k][l] = 0;
							cnt++;
						}
					}
				}
				
		
				//만약 ans가 3이상이면 빙고이기때문에 종료
				if (check() >= 3) {
                    System.out.println(cnt);
                    return;
                }
			}
		}
		
	}
	
	public static int check() {
        int lineCount = 0;

        // 가로줄 체크
        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] != 0) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) lineCount++;
        }

        // 세로줄 체크
        for (int i = 0; i < 5; i++) {
            boolean isBingo = true;
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] != 0) {
                    isBingo = false;
                    break;
                }
            }
            if (isBingo) lineCount++;
        }

        // 대각선 체크 (왼쪽 위에서 오른쪽 아래로)
        boolean isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (arr[i][i] != 0) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) lineCount++;

        // 대각선 체크 (오른쪽 위에서 왼쪽 아래로)
        isBingo = true;
        for (int i = 0; i < 5; i++) {
            if (arr[i][4 - i] != 0) {
                isBingo = false;
                break;
            }
        }
        if (isBingo) lineCount++;

        return lineCount;
    }
}


