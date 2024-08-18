import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int n = Integer.parseInt(br.readLine());	
		HashMap<Integer, Integer> map = new HashMap<>();
		
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            
            if(!map.containsKey(num)) {
            	map.put(num, 1);
            }
            else {
            	map.put(num, map.get(num)+1);
            }
        }
		
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuffer sb = new StringBuffer();
		
		for(int i=0; i<m; i++) {
			int k = Integer.parseInt(st.nextToken());
			if(map.containsKey(k)) {
				sb.append(map.get(k)+ " ");
			}
			else {
				sb.append(0+ " ");
			}
			
		}
		
		System.out.println(sb);
	}



	}


