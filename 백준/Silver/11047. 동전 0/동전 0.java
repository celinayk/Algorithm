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
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        
	        int n = Integer.parseInt(st.nextToken());
	        int k = Integer.parseInt(st.nextToken());
	        int []coin = new int[n];
	        
	        for(int i=0; i<n; i++) {
	        	coin[i] = Integer.parseInt(br.readLine());
	        }
	        
	        int sum = 0;
	        for(int i=n-1; i>=0; i--) {
	        	if(coin[i]<=k) {
	        		sum+= k/coin[i];
	        		k%=coin[i];
	        	}
	        }
	        System.out.println(sum);
	        
	   }
}