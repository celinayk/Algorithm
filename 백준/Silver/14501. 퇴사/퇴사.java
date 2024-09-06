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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        
        int n = Integer.parseInt(br.readLine()); 
        
        int[]t = new int[n+1];
        int[]p = new int[n+1];
        
        StringTokenizer st;
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	t[i] = Integer.parseInt(st.nextToken());
        	p[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] dp = new int[n+1];
        
        for(int i=0; i<n; i++) {
        	if(i+t[i]<=n) { //날짜 초과x
        		//i번째날 상담했을때, 그 상담이 끝나는 날의 최대 이익 갱신 
        		dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
        	}
        	//상담 안하고 다음 날로 넘어가는 경우의 최대 이익 갱신 
        	dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[n]);
        
    }
}

