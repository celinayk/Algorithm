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
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        arr= new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        
        for(int i=0; i<m; i++) {
        	st= new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            // 시작점보다 크거나 같은 첫 번째 점의 위치 찾기
            int lower = lowerBound(arr, start);
            
            // 끝점보다 작거나 같은 마지막 점의 위치 찾기
            int upper = upperBound(arr, end);
            
            // 선분 위에 있는 점의 개수: upper - lower
            sb.append(upper - lower).append("\n");
        }
      
        System.out.println(sb);
        	     
    }

   // 이진 탐색으로 시작점보다 크거나 같은 첫 번째 위치 찾기
   private static int lowerBound(int[] arr, int target) {
       int low = 0;
       int high = arr.length;
       
       while(low<high) {
    	   int mid = (low+high)/2;
    	   if(arr[mid]>= target) {
    		   high = mid;
    	   }
    	   else {
    		   low = mid+1;
    	   }
       }
       
       return low;
   }
   
   // 이진 탐색으로 끝점보다 작거나 같은 마지막 위치 찾기
   private static int upperBound(int[] arr, int target) {
       int low = 0;
       int high = arr.length;
       
       while(low<high) {
    	   int mid = (low+high)/2;
    	   if(arr[mid] <= target) {
    		   low = mid+1;
    	   }
    	   else {
    		   high = mid;
    	   }
       }
       
       return low;
   }
}

