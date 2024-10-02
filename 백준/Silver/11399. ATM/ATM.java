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
	   public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(br.readLine());
	        
	        int [] arr = new int[n];
	        int [] sum = new int[n];
	        
	     
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        for(int i=0; i<n; i++) {
	        	arr[i] = Integer.parseInt(st.nextToken());
	        }
	     
	        
	        Arrays.sort(arr);
	        
	        for(int i=0; i<n; i++) {
	        	sum[i] = arr[i];
	        	for(int j=0; j<i; j++) {
	        		sum[i]+=arr[j];
	        	}
	        }
	        
	        int ans = 0;
	        for(int l: sum) {
	        	ans+=l;
	        }
	        System.out.println(ans);
	   }
}