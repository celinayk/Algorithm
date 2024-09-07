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
          
        int[] dp = new int[1001];
       
        dp[1] = 1;
        dp[2] = 2;

        
        for(int i=3; i<=n; i++) {
        	dp[i] = (dp[i-2] + dp[i-1]) %10007;
        }
        
       
        System.out.println(dp[n]);
        
    }
}

