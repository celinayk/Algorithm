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

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
	
		
		String[] input = br.readLine().split(" ");
	    int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
	
		
		String[] scoreInput = br.readLine().split(" ");
        Integer[] score = new Integer[n];
        
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(scoreInput[i]);
        }
		
		 Arrays.sort(score, Collections.reverseOrder());
		 
		 System.out.println(score[k - 1]);
		
	}
}
