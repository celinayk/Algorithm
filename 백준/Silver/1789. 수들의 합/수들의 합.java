import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        
        long sum=0;
        
        if(s==1||s==2) {
        	System.out.println(1);
        	return;
        }
        for(int i=1; i<=s; i++) {
        	sum+=i;
        	if(sum>s) {
        		System.out.println(i-1);
        		break;
        	}
        	else if(sum==s) {
        		System.out.println(i);
        		break;
        	}
        }
    }
  
}

