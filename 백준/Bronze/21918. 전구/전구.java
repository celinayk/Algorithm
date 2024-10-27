import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] light = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
        	light[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int a = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	
        	if(a==1) {
        		//b번째 전구를 c상태로 변경
        		light[b]=c;
        	}
        	else if(a==2) {
        		//b번재부터 c번째까지의 전구 상태를 변경
        		for(int j=b; j<=c; j++) {
        			if(light[j]==0) {
        				light[j]=1;
        			}
        			else {
        				light[j] = 0;
        			}
        		}
        	}
        	else if(a==3) {
        		for(int j=b; j<=c; j++) {
        			light[j]=0;
        		}
        	}
        	else {
        		for(int j=b; j<=c; j++) {
        			light[j]=1;
        		}
        	}
        }
        
        for(int i=1; i<=n; i++) {
        	System.out.print(light[i]+" ");
        }
        
        
    }  
}

