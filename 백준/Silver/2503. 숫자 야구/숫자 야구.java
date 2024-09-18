import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
        StringTokenizer st;
        //정답 배열 미리 세팅
        boolean[] check = new boolean[988];      
        
        //가능한 모든 숫자들을 미리 배열에 true로 담아둔다.
        for(int i=123; i<=987; i++) {
        	String num = String.valueOf(i);
        	
        	if(num.charAt(0)=='0' ||num.charAt(1)=='0' ||num.charAt(2)=='0' ) {
        		continue;
        	}
        	if(num.charAt(0) == num.charAt(1) || num.charAt(0) == num.charAt(2) || num.charAt(1) == num.charAt(2)) {
        		continue;
        	}
        	check[i] = true;
        }
        
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int num = Integer.parseInt(st.nextToken());
        	int s = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	
        	//가능한 모든 수 탐색하면서 되는 숫자 찾음 
        	for(int a = 123; a<=987; a++) {
        		if(check[a]) {
        			int sn = 0;
        			int bn=0;
        			
        			for(int one=0; one<3; one++) {
        				char num_split = Integer.toString(num).charAt(one);
        				
        				for(int two = 0; two < 3; two++) {
        					char a_split = Integer.toString(a).charAt(two);
        				
        					if (num_split == a_split && one == two) sn++;
        					else if (num_split == a_split && one != two) bn++; 
        				}
        			}
        			
        			if (sn == s && bn == b) check[a] = true;
        	        else check[a] = false;
        		}
        	}
        }
        int a = 0;
    	for(int i=123; i<=987; i++) {
    		if(check[i]) a++;
    	}
    	System.out.println(a);
        
    }   
}

