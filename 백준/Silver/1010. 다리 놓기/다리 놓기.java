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
	static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
             
        int t = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<t; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	int n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	
        	sb.append(combi(m,n)).append(" "); 
        }
        System.out.println(sb);
	
	}

	private static int combi(int n, int r) {
		if(dp[n][r] > 0) {
			return dp[n][r];
		}
		if(n==r || r==0) {
			return dp[n][r] = 1;
		}
		return dp[n][r] = combi(n-1,r-1) + combi(n-1, r);
	}  
}