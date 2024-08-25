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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
             
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
    	char arr[][] = new char[n][m];

    	//문자 입력받기 
    	for (int i = 0; i < n; i++) {  
    		String str = br.readLine();
            for (int j = 0; j < m; j++) {    
                arr[i][j] =  str.charAt(j);    
            }
        }
    	
    	int row=0;
    	int col = 0;
    	for(int i = 0; i < n; i++) {
            boolean inSequence = false; 
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == '-') {
                    if(!inSequence) {
                        row++;
                        inSequence = true;
                    }
                } else {
                    inSequence = false;
                }
            }
        }
        
        // 열에서 연속된 '|' 블록 계산
        for(int j = 0; j < m; j++) {
            boolean inSequence = false; 
            for(int i = 0; i < n; i++) {
                if(arr[i][j] == '|') {  
                    if(!inSequence) {
                        col++;
                        inSequence = true;
                    }
                } else {
                    inSequence = false;
                }
            }
        }
    	
    	System.out.println(row+col);
	}
    
}




