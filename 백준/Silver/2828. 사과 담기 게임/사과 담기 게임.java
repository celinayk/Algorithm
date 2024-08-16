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
	static int arr[][] = new int[5][5];  
	static int ans = 0;
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		String a[] = br.readLine().split(" ");
		int n =Integer.parseInt(a[0]);
		int m =Integer.parseInt(a[1]);

		int j = Integer.parseInt(br.readLine());
		int arr[] = new int[j];
		
		//사과가 떨어지는 위치를 배열에 숫자로 담음
		for(int i=0; i<arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int left = 1; //최초의 바구니 위치는 1임 
		int right = m;
		int cnt=0; //이동 횟수 카운트 
		
		for(int i=0; i<arr.length; i++) {
			if(right<arr[i]) { //내려오는 사과가 바구니보다 오른쪽에 있으면
				cnt+=arr[i]-right;
				left = arr[i] - m + 1;
                right = arr[i];
			}
			else if(arr[i]<left){ //사과가 바구니보다 왼쪽에 있음
				cnt+=left-arr[i];
				right = arr[i] + m - 1;
				left=arr[i];
			}
			
			
		}
		System.out.println(cnt);
		
	}
}


