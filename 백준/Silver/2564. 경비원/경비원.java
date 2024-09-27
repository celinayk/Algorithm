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
        
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        int cnt=0, p = 0;
        
        int[] arr = new int[n];
        
        for(int i=0; i<=n; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int dir = Integer.parseInt(st.nextToken());
        	int loc = Integer.parseInt(st.nextToken());
        	int tmp = 0;
        	
        	switch(dir) {
        	case 1: // 북쪽일때
        		tmp = loc;
        		break;     		
        	case 2: // 남쪽일때
        		tmp = w+h+w-loc;
        		break;
        	case 3: // 서쪽일때
        		tmp = w+h+w+h-loc;
        		break;      		
        	case 4: // 동쪽일때
        		tmp = w+loc;
        		break;       				
        	}
        	if(i<n) { //상점의 위치 입력받기
        		arr[i]=tmp;
        	}
        	else { //동근이 위치 입력받기
        		p = tmp;
        	}
        }
        
        for (int i = 0; i<arr.length; i++) {
            int path1 = Math.abs(p - arr[i]);
            int path2 = 2 * w + 2 * h - path1;
            cnt += Math.min(path1, path2);
        }
        
        System.out.println(cnt);
        
        
        
        
        
    }  
}