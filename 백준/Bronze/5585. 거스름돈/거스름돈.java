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
		num = 1000-num;
		
		int sum=0; //최종 잔돈의 갯수를 세기 위한 변수
		int n[] = {500,100,50,10,5,1};
		
		
		for(int i=0; i<n.length; i++) {
			int a =num/n[i];
			sum+=a;
			num=num%n[i];
		}
		System.out.println(sum);
		
	}
}


