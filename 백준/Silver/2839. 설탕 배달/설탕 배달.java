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
		int cnt=0;
		
		while(n%5!=0) {
			if(n%5==0) {
				System.err.println(n/5);
				return;
			}
			else {
				n-=3;
				cnt++;
			}
		}
		if(n<0) {
			System.out.println(-1);
		}
		else {
			System.out.println(cnt+(n/5));
		}
		
	}
}


