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
	static boolean[]isVisited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
             
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        arr=new int[n];
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = 0;
        int cnt=0;
        int tmp = 0;
        boolean flag = false;
        isVisited = new boolean[n+1];

        
        while(true) {
        	if(arr[tmp]==k) { //보성이 번호에 걸리는경우 
        		cnt++;
        		break;
        	}
        	else if(isVisited[arr[tmp]]) { //k없는 싸이클생성
        		flag = true;
        		break;
        	}
        	else {
        		tmp=arr[tmp];
        		isVisited[tmp]= true;
        		cnt++;
        	}
        }
        if(flag) {
        	System.out.println(-1);
        }
        else {
        	System.out.println(cnt);
        }
        
//        for(int i=0; i<arr.length; i++) {
//        	if(!isVisited[i]) {
//        		isVisited[i] = true;
//        		int tmp = arr[i];
//        		while(arr[i]!=k) {
//        			if(isVisited[tmp]) 
//        				System.out.println(-1);
//        				break;
//        			}
//        			System.out.println(arr[i]);
//        	}
//        }
        
    }
}