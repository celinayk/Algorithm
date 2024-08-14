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
		
		int n = Integer.parseInt(br.readLine());
		String m = br.readLine();
		
		int scnt=0;
		int lcnt=0;
		int ans = 0;
		
		for(int i=0; i<m.length(); i++) {
			if(m.charAt(i)=='S') {
				scnt++;
			}
			else if(m.charAt(i) == 'L'){
				lcnt++;
			}
		}
		lcnt=lcnt/2;
		
		if(lcnt!=0) {
			ans=scnt+lcnt+1;
			System.out.println(ans);
		}
		if(lcnt==0) {
			ans=scnt+lcnt;
			System.out.println(ans);
		}
		
		
		
	}
}


