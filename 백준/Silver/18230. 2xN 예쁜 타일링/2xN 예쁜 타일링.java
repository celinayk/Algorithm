import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        Integer [] A = new Integer[a];
        Integer [] B = new Integer[b];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<a; i++) {
        	A[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<b; i++) {
        	B[i] = Integer.parseInt(st.nextToken());
        }
        
        //가장 큰 값의 타일 사용해야 하므로, 타일을 크기 큰 순서대로 정렬
        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B, Collections.reverseOrder());
        
        int ans =0;
        int one = 0;
        int two = 0;
        
        // n이 홀수인지 확인 
        if(n%2==1) {
        	ans+=A[one]; //2*1 타일중 가장 큰거 하나 사용하고 정답에 합산 
        	one++;
        	n--;
        }
        
        // 이제 짝수개의 2*2크기의 타일을 만든다.
        while(n>0) {
        	if(one+1>=a) {
        		while(n>0) {
        			ans+=B[two];
            		two++;
            		n-=2;
        		}
        		break;
        	}
        	if(two>=b) {
        		while(n>0) {
        			ans+=A[one]+A[one+1];
            		one+=2;
            		n-=2;
        		}
        		break;
        	}
        	if(A[one]+A[one+1] <= B[two]) {
        		ans+=B[two];
        		two++;
        	}
        	else {
        		ans+=A[one] + A[one+1];
        		one+=2;
        	}
        	n-=2;
        }
        
        System.out.println(ans);
    }	   
}
	


