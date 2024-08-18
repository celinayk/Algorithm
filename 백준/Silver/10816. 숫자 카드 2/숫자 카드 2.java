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
		int arr[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
		
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<m; i++) {
			int k = Integer.parseInt(st.nextToken());
			sb.append(upperBound(arr,k) - lowerBound(arr,k)).append(" ");
			
		}
		
		System.out.println(sb);
	}

	private static int lowerBound(int[] arr, int k) {
		int low = 0;
		int high = arr.length;
		
		while(low<high) {
			int mid= (low+high)/2;
			if(arr[mid]>=k) { //k값이 중간위치 보다 같거나 작으면
				high = mid; //범위를 왼쪽으로 탐색해야하니까 high를 줄인다
			}
			else {
				low = mid +1;
			}
		}
		return low;
	}

	private static int upperBound(int[] arr, int k) {
		int low = 0;
        int high = arr.length;

        while(low<high) {
        	int mid= (low+high)/2;
        	if(arr[mid]>k) { //k값이 중간위치보다 작으면
        		high = mid; //작는 범위
        	}
        	else {
        		low=mid+1;
        	}
        			
        }
        return low;
	}
}


