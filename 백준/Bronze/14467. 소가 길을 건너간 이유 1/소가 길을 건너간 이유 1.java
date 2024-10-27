import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        int cow[][] = new int[11][1];
        int cnt=0;
        for(int i=1; i<11; i++) {
        	cow[i][0] = -1;
        }
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int num = Integer.parseInt(st.nextToken());
        	int road = Integer.parseInt(st.nextToken());
        	//처음엔 일단 넣는다 카운팅 안함 
        	if(cow[num][0]==-1) {
        		cow[num][0] = road;
        	}
        	else {
        		if(cow[num][0]!=road) {
        			cnt++;
        			cow[num][0] =road;
        		}
        	}
        	
        	
        	
        }
       System.out.println(cnt);
        
    }  
}

