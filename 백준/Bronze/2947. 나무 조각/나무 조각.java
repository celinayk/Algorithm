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
		
		String[] input = br.readLine().split(" ");
		
		int[] num = new int[5];
		
		for(int i=0; i<5; i++) {
			num[i] = Integer.parseInt(input[i]);
		}
				
		for(int i=0; i<num.length-1; i++) {
			for(int j=0; j<num.length-1-i; j++) {
				if(num[j]>num[j+1]) {
					int tmp = num[j];
					num[j] = num[j+1];
					num[j+1] = tmp;
					for(int k=0; k<num.length; k++) {
						System.out.print(num[k]+ " ");
					}
					System.out.println();
				}
				
			}
			
		}
	}
	

}


