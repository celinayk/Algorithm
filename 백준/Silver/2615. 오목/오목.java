import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        
     
        StringTokenizer st;
        
        int [][] arr = new int[19][19];
     
        // 바둑판 입력 받기 
        for(int i=0; i<19; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j=0; j<19; j++) {
        		arr[i][j] = Integer.parseInt(st.nextToken());      			
        	}      			
        }
        
        int[] result = checkOmok(arr);

        // 결과 출력
        if (result[0] == 0) {
            System.out.println(0); // 승리자 없으면 0 출력
        } else {
            System.out.println(result[0]); // 승리한 돌의 색 출력
            System.out.println(result[1] + " " + result[2]); // 가장 왼쪽 또는 위쪽 돌의 좌표 출력
        }
        
    }
private static int[] checkOmok(int[][] arr) {   
	 for(int i=0; i<19; i++) { 
     	for(int j=0; j<19; j++) {
     		if(arr[i][j] != 0) {
     			int color = arr[i][j]; 
     			
     			//가로 검사
     			if(checkDirection(arr,i,j,0,1,color)) {
     				return new int[]{color, i + 1, j + 1};
     			}
     			
     			//세로 검사 
     			else if(checkDirection(arr,i,j,1,0,color)) {
     				return new int[]{color, i + 1, j + 1};

     			}
     			
     			// 오른쪽 밑으로 내려가는 대각선 검사 
     			else if(checkDirection(arr,i,j,1,1,color)) {
     				return new int[]{color, i + 1, j + 1};

     			}
     			
     			// 오른쪽 위로 올라가는 대각선 검사 
     			else if(checkDirection(arr,i,j,1,-1,color)) {
     				return new int[]{color, i + 5, j -3};

     			}
     			
     		}
     	
     	}
     }
	 return new int[]{0, 0, 0}; 
}

private static boolean checkDirection(int[][] arr, int x, int y, int dx, int dy, int color) {

	int cnt = 1;
	for(int i=1; i<=5; i++) {
		int nx = x + dx *i;
		int ny = y + dy * i;
		
		if (nx >= 0 && nx < 19 && ny >= 0 && ny < 19 && arr[nx][ny] == color) {
            cnt++;
        } else {
            break;
        }
		
	}
	
	if(cnt==5) {
		// 앞과 뒤에 같은 색 돌이 있으면 안 됨
        int prevX = x - dx;
        int prevY = y - dy;
        int nextX = x + dx * 5;
        int nextY = y + dy * 5;
        
        if ((prevX < 0 || prevX >= 19 || prevY < 0 || prevY >= 19 || arr[prevX][prevY] != color) &&
                (nextX < 0 || nextX >= 19 || nextY < 0 || nextY >= 19 || arr[nextX][nextY] != color)) {
                return true;
            }
	}
	return false;
}   
}

