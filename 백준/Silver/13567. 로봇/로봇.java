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
	        int m = Integer.parseInt(st.nextToken());
	        int n = Integer.parseInt(st.nextToken());
	        
	        int dir = 0;
	        int dx[] = {1,0,-1,0};
	        int dy[] = {0,-1,0,1};
	        int x = 0;
	        int y = 0;
	        boolean flag = true;
	        
	        for(int i=0; i<n; i++) {
	        	st = new StringTokenizer(br.readLine());
	        	String type = st.nextToken();
	        	int cnt = Integer.parseInt(st.nextToken());
	        	
	        	if(type.equals("TURN")) {
	        		if(cnt==0) {
	        			dir = (dir + 3) % 4;
	        		}
	        		else {
	        			dir = (dir + 1) % 4;;
	        		}

	        	}
	        	
	        	else {
	        		x += dx[dir] * cnt;
	        		y += dy[dir] * cnt;
	        	}
	        	
	        	if(x < 0 || x > m || y < 0 || y > m) {
	        		flag = false;
	        		break;
	        	}
	        	 
	        }
	        if(flag) {
	        	System.out.println(x+" "+y);
	        }
	        else {
	        	System.out.println(-1);
	        }
	        
	    }
	}