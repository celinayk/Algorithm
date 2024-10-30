import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int []arr = new int[n];
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxSum=0;
        int windowSum=0;
        int maxCount=0;
        
        //첫 윈도우의 합 계산 
        for(int i=0; i<x; i++) {
        	windowSum+=arr[i];
        }
        maxSum= windowSum;
        maxCount=1;
        
        for(int i=x; i<n;i++) {
        	windowSum+=arr[i]-arr[i-x];
        	if(windowSum>maxSum) {
        		maxSum=windowSum;
        		maxCount=1;
        	}
        	else if(windowSum==maxSum) {
        		maxCount++;
        	}
        }
        
        if(maxSum==0) {
        	System.out.println("SAD");
        }
        else {
            System.out.println(maxSum);       
            System.out.println(maxCount);
        }
        
        
    }
}