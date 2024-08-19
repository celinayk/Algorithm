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
        
        int t = Integer.parseInt(br.readLine());	
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());  
            int m = Integer.parseInt(st.nextToken());  
            
            int arr[] = new int[n];
            int brr[] = new int[m];
      
            
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<arr.length; j++) {
            	arr[j] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<brr.length; j++) {
            	brr[j] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(arr);
            Arrays.sort(brr);
            
            
            int ans=0;
            int a = 0;
            int b = 0;
            while(true) {
            	if(a==n || b==m) break;
            	if(arr[a]>brr[b]) {
            		ans+=n - a;
            		b++;
            	}
            	else {
            		a++;
            	}
            }
           System.out.println(ans);
        }
    }


}






