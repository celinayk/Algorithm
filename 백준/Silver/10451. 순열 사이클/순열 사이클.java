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
	static int[] arr;
	static int n,m,k=0;
	static boolean[]isVisited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
             
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        
        for(int i=0; i<t; i++) {
        	n = Integer.parseInt(br.readLine());
        	arr = new int[n+1];
            isVisited = new boolean[n + 1];
            
            st = new StringTokenizer(br.readLine());
            //배열이 순열 숫자를 채움
        	for(int j=1; j<=n; j++) {	
        		arr[j] = Integer.parseInt(st.nextToken());
        	}
        	
        	int cnt=0;
        	for(int k=1; k<=n; k++) {
        		if(!isVisited[k]) {
        			isVisited[k] = true; //방문처리
        			int next = arr[k];
        			while(true) {
        				if(isVisited[next]) {
        					cnt++;
        					break;
        				}
        				isVisited[next] = true;
        				next = arr[next];
        			}
        		}
        	}
        	
        	System.out.println(cnt);
        }
    
    }
}