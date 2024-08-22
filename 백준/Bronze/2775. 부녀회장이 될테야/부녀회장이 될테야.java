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
             
        int t = Integer.parseInt(br.readLine());  
        StringBuilder sb = new StringBuilder();
    	int arr[][] = new int[15][15];
    	
    	for(int i=0; i<15; i++) {
    		arr[i][1] = 1; //모든 층의 1호는 1명이 산다
    		arr[0][i] = i; //0층은 호수만큼 사람이 산다 
    	}
    	
    	//구현//
    	for(int i=1; i<15; i++) {
    		for(int j=1; j<15; j++) {
    			arr[i][j] = arr[i][j-1] + arr[i-1][j];
    		}
    	}
    	
    	for(int i=0; i<t; i++) {	
    		int k = Integer.parseInt(br.readLine());
        	int n = Integer.parseInt(br.readLine());
        	sb.append(arr[k][n] + "\n");
    	}
        System.out.println(sb);
	}
}




