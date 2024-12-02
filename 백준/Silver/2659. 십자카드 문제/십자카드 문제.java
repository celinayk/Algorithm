
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	static int small;
	static int cnt=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] num = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
        	num[i] = Integer.parseInt(st.nextToken());
        }
        
        small=searchNum(num);
        findSmallClockNum();
        System.out.println(cnt);
        
    }

    // 몇번째로 작은 시계수인지 찾는 메서드
    private static void findSmallClockNum() {
		for(int i=1111; i<=small; i++) {
			if(String.valueOf(i).contains("0")) continue;
			// 숫자를 각 자리로 분리
			int [] digits = new int[4];
			int tmp = i;
			for(int j=3; j>=0; j--) {
				digits[j]= tmp%10;
				tmp/=10;
			}
			
			int a = searchNum(digits);
			if(a==i) cnt++;
		
		}
		
	}

	// 시계수 찾는 메서드 
	private static int searchNum(int[] arr) {
		int tmp = Integer.MAX_VALUE;
		
		for(int i=0; i<4; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<4; j++) {
				sb.append(arr[(i + j) % 4]);	  
			}
			tmp = Math.min(tmp, Integer.parseInt(sb.toString()));
		}
		return tmp;
	}
}

