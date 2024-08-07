import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int n = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[n][2];
		
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(str[0]);
			arr[i][1] = Integer.parseInt(str[1]);
		}
		
		Arrays.sort(arr, (n1, n2) -> n1[0]==n2[0] ? n1[1]-n2[1] : n1[0]-n2[0]);
		
		
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i][0]+ " "+arr[i][1]);
		}
	}
}
