import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int []arr = new int[100001];
        for(int i=1; i<=m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	arr[a] = i;
        	arr[b] = i;
        }
        
        n%=(2*m);
        if(n==0) n=2*m;
        
        int floor =1;
        for(int i=1; i<10001; i++) {
        	if(arr[i]!=0) {
        		if(floor==n) {
        			System.out.println(arr[i]);
        			break;
        		}
        		else {
        			floor++;
        		}
        	}
        }
        		
        
        
        
   
    }

  
}
