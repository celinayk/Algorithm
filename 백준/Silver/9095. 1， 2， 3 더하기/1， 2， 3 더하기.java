import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int dp[] = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        
        int T = Integer.parseInt(br.readLine()); 
        
        int n =0;
        
        for(int t=0; t<T; t++) {
        	n = Integer.parseInt(br.readLine());
       
        	
        	dp[0] = 0;
        	dp[1] = 1;
        	dp[2] = 2;
        	dp[3] = 4;
        	
        	for(int i=4; i<=n; i++) {
        		dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        	}
        	System.out.println(dp[n]);
        }
        
       
        
    }
	    
   
	
}

