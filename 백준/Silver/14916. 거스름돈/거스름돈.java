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
		
		int num = Integer.parseInt(br.readLine());
		int sum=0;
		int cnt=0;
	
		while(num % 5 != 0) {
			if(num%5==0) {
				System.out.println(num/5);
				return;
			}
			else {
				num-=2;
				cnt++;
			}
 		}
		if(num<0) {
			System.out.println(-1);
		}
		else {
			System.out.println(cnt+(num/5));
		}
	}
}


