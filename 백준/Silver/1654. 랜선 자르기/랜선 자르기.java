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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken());  
        int n = Integer.parseInt(st.nextToken());  
        int arr[] = new int[k];
 
        long high = 0;
        
        for(int i=0; i<k; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        	if(high<arr[i]) {
        		high = arr[i];
        	}
        }
        
        long low = 1;
        
        while(low<=high) {
        	long mid = (low+high)/2;
        	long cnt=0;
        	
        	//현재 길이로 만들 수 있는 랜선의 길이
        	for(int i=0; i<arr.length; i++) {
        		cnt+=(arr[i]/mid);
        	}
        	// 랜선의 개수가 n보다 작으면(길이가 답보다 길어서 그런거임)
        	// 더 많은 랜선을 만들어야함 
        	// 왼쪽을 탐색해야함 
        	if(cnt<n) { 
        		high = mid-1;
        	}
        	//랜선의 개수가 n보다 많다(길이가 답보다 짧으니까 늘려야함)
        	//오른쪽 탐색 
        	else {
        		low = mid+1;
        	}
        		
        }
        System.out.println(high);
    }
}




