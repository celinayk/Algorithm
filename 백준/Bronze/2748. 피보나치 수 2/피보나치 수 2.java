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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        
        
        int n = Integer.parseInt(br.readLine());  
        
        long sum=1;
        long f1=0;
        long f2=1;
        
        for(int i=1; i<n; i++) {
        	sum = f1+f2;
        	f1=f2;
        	f2=sum;
        }
        System.out.println(sum);
    }
}




