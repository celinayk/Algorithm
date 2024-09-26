import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	static int arr[];
	static int n,k;
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(br.readLine().trim());
        }
        Arrays.sort(arr);
        
        long start = 1;
        long end = arr[arr.length-1];
        long ans = 0;
        
        while(start<=end) {
        	long mid = (start+end)/2;
        	
        	if(check(mid)) {
        		ans = mid;
        		start = mid+1;
        	}
        	else {
        		end = mid-1;
        	}
        }
        
        System.out.println(ans);
        
    }

private static boolean check(long mid) {
	int cnt = 0;
	for(int i=0; i<arr.length; i++) {
		cnt += arr[i] / mid;
	}
	return cnt>=k;
}

  
}