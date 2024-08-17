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
		
		// m개의 수를 입력받고 arr배열에 존재하는지 확인
		for(int i=0; i<m; i++) {
			if(Arrays.binarySearch(arr, Integer.parseInt(st.nextToken())) >=0) {
				sb.append(1).append("\n");
			}
			else {
				sb.append(0).append("\n");
			}
			
		}
		System.out.println(sb);
		
		
	}
}


