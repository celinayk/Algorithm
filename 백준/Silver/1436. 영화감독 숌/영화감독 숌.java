import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int ans=0;
        int num=666;
        
        while(true) {  	
        	if(String.valueOf(num).contains("666")) {
        		ans++;
        		if(ans==n) {
        			System.out.println(num);
        			break;
        		}
        	}
        	num++;
        }
    }
}