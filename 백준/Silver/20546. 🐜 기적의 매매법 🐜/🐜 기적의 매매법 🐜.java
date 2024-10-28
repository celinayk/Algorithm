import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        
        int [] arr = new int[15];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=14; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        //준현이의 경우 
        int num1 = money;
        int have1=0;
        for(int i=1; i<=14; i++) {
        	//보유자산이 해당일자 주가보다 커서 주식살수 있다면
        	if(num1>=arr[i]) {
        		have1+= num1/arr[i];
        		num1%=arr[i];
        	}     	
        }
        int final1= num1+arr[14]*have1;
        
        //성민이의 경우
        int num2 = money;
        int have2 = 0;
        for(int i=1; i<=11; i++) {
        	//전량매도 
        	if(arr[i]<arr[i+1] && arr[i+1]<arr[i+2]) {
        		num2+= have2*arr[i+3];
        		have2=0;
        	}
        	//전량매수
        	else if(arr[i]>arr[i+1] && arr[i+1]>arr[i+2]) {
        		have2+=num2/arr[i+3];
        		num2%=arr[i+3];
        	}
        }
        int final2= num2+arr[14]*have2;
        
        if(final1>final2) {
        	System.out.println("BNP");
        }
        else if(final1<final2) {
        	System.out.println("TIMING");
        }
        else {
        	System.out.println("SAMESAME");
        }
        
    }  
}

