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
	        String n = br.readLine();
	        
	        char[] arr = n.toCharArray();
	        Arrays.sort(arr);
	        
	        
	        StringBuilder sb = new StringBuilder();
	        int sum = 0;
	        for(int i=arr.length-1; i>=0; i--) {
	        	int num = arr[i]-'0';
	        	sum+=num;
	        	sb.append(num);
	        }
	        
	        if(sum%3 !=0 || arr[0]!='0') { 
	        	System.out.println(-1);
	        }
	        else {
	        	System.out.println(sb);
	        }
	        //System.out.println(sb);
	   }
}