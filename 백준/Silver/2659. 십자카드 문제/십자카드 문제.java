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
	static int clockNum;
	static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int []arr = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
         clockNum = getClockNum(arr);
         findSmallClockNum();
         System.out.println(ans);
        
    }	
    
    //시계수 구하기 
    static int getClockNum(int[] arr) {
    	 int num = 10000;      
         StringBuilder sb;
         for(int i=0; i<4; i++) {
         	sb = new StringBuilder();
         	for(int j=0; j<4; j++) {
         		sb.append(arr[(i + j) % 4]);    		
         	}
         	int cur = Integer.parseInt(sb.toString());
     		num = Math.min(cur, num);
         } 
         return num;
    }
    
    
    //시계수보다 작은 
    static void findSmallClockNum() {
    	//전체 4자리 숫자들중에서 몇번째에 해당하는지 찾기
        for(int i=1111; i<=clockNum; i++) {
        	if(String.valueOf(i).contains("0")) continue;
        	
        	//4자리수 1111부터 9999까지 
        	int[] digit = new int[4];
        	int k = i;
        	for(int j=3; j>=0; j--) {
        		digit[j] = k%10;
        		k/=10;
        	}
        	 if (getClockNum(digit) == i) ans++; 
        	

        }
    	
    }
}
	


