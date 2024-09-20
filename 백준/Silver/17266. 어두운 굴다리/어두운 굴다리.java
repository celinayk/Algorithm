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
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        int[] arr = new int[m];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int a = arr[0];
        int c = n - arr[arr.length-1];
        int b = 0;
        for(int i=0; i<m-1; i++) {
        	 int gap = arr[i+1]-arr[i];
        	 int height = (gap % 2 == 0) ? gap / 2 : (gap / 2) + 1;
        	 a=Math.max(a, height);
        }
        
        a = Math.max(a, n-arr[m-1]);
        System.out.println(a);
        
        
        
    }
  
}

