import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static long arr[];
	static int n;
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] =  Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        long min = Long.MAX_VALUE;
        int ml = 0; int mr = 0;
        for(int i=0; i<n; i++) {
        	int start = i+1;
        	int end = n-1;
        	while(start<=end) {
        		int mid =(start+end)/2;
        		long sum = Math.abs(arr[i] + arr[mid]);
        		
        		if(min>sum) {
        			min = sum;
        			ml = i;
        			mr = mid;      			
        		}
        		if(arr[mid]>= -arr[i]) {
					end = mid-1;
				}else{
					start = mid+1;
				}      		
        	}
        	
        }
        System.out.println(arr[ml]+" "+arr[mr]);
        
    }



  
}