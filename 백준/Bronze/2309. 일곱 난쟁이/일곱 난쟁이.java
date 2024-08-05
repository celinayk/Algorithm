import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[] = new int[9];
		int sum = 0;
		
		// 9개 숫자 입력받아서 배열에 저장
		for(int i=0; i<9; i++) {
			int n = Integer.parseInt(br.readLine());
			 arr[i] = n;
			 sum += n;
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(sum - (arr[i]+arr[j])==100) {
					arr[i] = 0;
					arr[j] = 0;
					Arrays.sort(arr);


					for(int k=2; k<arr.length; k++) {
						System.out.println(arr[k]);
					}
					return;
				}
			}
			
		}
		
	
		
	}
}
