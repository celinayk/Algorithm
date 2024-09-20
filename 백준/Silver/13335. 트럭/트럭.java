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
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> truck = new LinkedList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {      	
        	 truck.add(Integer.parseInt(st.nextToken()));
        }
        
        for (int i = 0; i < w; i++) {
            bridge.add(0);
        }
        
        int time=0;
        int currentBridgeWeight = 0;
        
        //모든 트럭이 다리를 다 건널떄까지 반복 
        while(!bridge.isEmpty()) {
        	time++;
        	//다리에서 트럭 빠져나가면 그 무게는 뺀다 
        	currentBridgeWeight -= bridge.poll();
        	
        	if(!truck.isEmpty()) {
        		if(currentBridgeWeight+truck.peek() <=L) {
        			int tmp = truck.poll();
        			bridge.offer(tmp); //트럭이 다리에 진입
        			currentBridgeWeight+=tmp; //무게 갱신
        		}
        		else {
        			bridge.offer(0);
        		}
        	}
        	
        }
        System.out.println(time);
        
        
        
    }
  
}

