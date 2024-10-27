import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static char [][]board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        
        
        for(int i=0; i<n; i++) {
        	String line = br.readLine();
        	for(int j=0; j<n; j++) {
        		board[i][j] = line.charAt(j);
        	}
        }
        
        int ans = 1;
        // 서로 인접한 가로 두칸 교환
        for(int i=0; i<n-1; i++) {
        	for(int j=0; j<n-1; j++) {  
        		// 서로 인접한 가로 교환
        		if(board[i][j] != board[i][j+1] && j+1<n) {
        			char tmp = board[i][j];
        			board[i][j] = board[i][j+1];
        			board[i][j+1] = tmp;		
        			// 모두 같은 색으로 이루어진 가장 긴 연속 부분 고름
        			ans = Math.max(ans,  checkMaxNum());
        			//원상복귀
        			char tmp1 = board[i][j];
        			board[i][j] = board[i][j+1];
        			board[i][j+1] = tmp1;
        		}
        		
        		// 서로 인접한 세로 교환
        		if(board[i][j] != board[i+1][j] && i+1<n) {
        			char tmp = board[i][j];
        			board[i][j] = board[i+1][j];
        			board[i+1][j] = tmp;	
        			ans = Math.max(ans,  checkMaxNum());
        			char tmp2 = board[i][j];
        			board[i][j] = board[i+1][j];
        			board[i+1][j] = tmp2;
        		}
        	}
        }
        System.out.println(ans);
        
   
    }

	private static int checkMaxNum() {
		int max_cnt = 1;
		for(int i=0; i<n; i++) {
			int cnt=1;
			for(int j=1; j<n; j++) {
				if(board[i][j]==board[i][j-1]) {
					cnt++;
				}
				else {
					cnt=1;
				}
				max_cnt = Math.max(cnt, max_cnt);
			}
			
			for(int j=1; j<n; j++) {
				if(board[j][i] == board[j-1][i]) {
					cnt++;
				}
				else {
					cnt=1;
				}
				max_cnt = Math.max(cnt, max_cnt);
			}
		}
		return max_cnt;
	}  
}
