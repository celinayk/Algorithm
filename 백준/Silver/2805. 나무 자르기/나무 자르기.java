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
	static int[] arr;
	static int n,m;
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int start = 0;
        int end = arr[arr.length-1];
        int ans = 0;
        
        while(start<=end) {
        	int mid = (start+end)/2;
        	long h = check(mid);
        	if(h>=m) {
        		ans = mid;
        		start = mid+1;
        	}
        	else {
        		end = mid-1;
        	}
        	
        }
        System.out.println(ans);
        
    }
private static long check(int length) {
	long sum = 0;
	for(int i=0; i<arr.length; i++) {
		if(arr[i]>length) {
			sum+=(arr[i]-length);
		}
	}
	return sum;
}  
}

