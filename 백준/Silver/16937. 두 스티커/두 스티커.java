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
	        int h = Integer.parseInt(st.nextToken());
	        int w = Integer.parseInt(st.nextToken());
	        
	     
	        int n = Integer.parseInt(br.readLine());
	        int [][] sticker = new int[n][2];
	        
	        for(int i=0; i<n; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	int r = Integer.parseInt(st.nextToken());
	        	int c = Integer.parseInt(st.nextToken());
	        	
	        		sticker[i][0] = r; 
	        	    sticker[i][1] = c; 
	        	       	
	        }
	        	
	        int maxArea = 0;
	        for(int i=0; i<n; i++) {
	        	for(int j=i+1; j<n; j++) {
	        		int r1 = sticker[i][0];
	                int c1 = sticker[i][1];
	                
	                // 두 번째 스티커 크기
	                int r2 = sticker[j][0];
	                int c2 = sticker[j][1];

	               
	                // 스티커 두 개를 가로로 붙이는 경우
	                if(r1 + r2 <= w && Math.max(c1, c2) <= h) {
	                    maxArea = Math.max(maxArea, (r1 * c1) + (r2 * c2));
	                }
	                
	                
	                // 스티커 두 개를 세로로 붙이는 경우
	                if(c1 + c2 <= w && Math.max(r1, r2) <= h) {
	                    maxArea = Math.max(maxArea, (r1 * c1) + (r2 * c2));
	                }
	               
	                
	                // 스티커 하나는 가로, 하나는 세로로 붙이는 경우 
	                if(c1 + r2 <=w && Math.max(c2, r1) <=h) {
	                	 maxArea = Math.max(maxArea, (r1 * c1) + (r2 * c2));
	                }
	                
	                if (c2 + r1 <=w && Math.max(c1, r2) <=h){
	                	maxArea = Math.max(maxArea, (r1 * c1) + (r2 * c2));
	                }
	                
	                // 둘다 가로 세로로 붙이기 
	                if(r1 + r2 <= h && Math.max(c1, c2) <= w) {
	                    maxArea = Math.max(maxArea, (r1 * c1) + (r2 * c2));
	                }
	                
	             // 스티커 두 개를 세로로 붙이는 경우
	                if(c1 + c2 <= h && Math.max(r1, r2) <= w) {
	                    maxArea = Math.max(maxArea, (r1 * c1) + (r2 * c2));
	                }
	                
	                if(c1 + r2 <=h && Math.max(c2, r1) <=w) {
	                	 maxArea = Math.max(maxArea, (r1 * c1) + (r2 * c2));
	                }
	                
	                if (c2 + r1 <=h && Math.max(c1, r2) <=w){
	                	maxArea = Math.max(maxArea, (r1 * c1) + (r2 * c2));
	                }
	               
	        	}
	        }
	       
	        System.out.println(maxArea);
	   }
}