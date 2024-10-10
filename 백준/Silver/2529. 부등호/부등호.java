import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static int k;
	static char[] sign;
	static List<String>ans;
	static boolean[] visited;
	   public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;

	        k = Integer.parseInt(br.readLine());
	        sign = new char[10];
	        ans = new ArrayList<>();
	        visited = new boolean[10];
	        
	        st = new StringTokenizer(br.readLine());
	        for(int i=0; i<k; i++) {
	        	sign[i] = st.nextToken().charAt(0);
	        }
	        
	        
	        backtrack("", 0);
	        Collections.sort(ans);
	        System.out.println(ans.get(ans.size()-1));
	        System.out.println(ans.get(0));
	}

	private static void backtrack(String num, int depth) {
		// 종료 조건 
		if(depth == k+1) {
			ans.add(num);
			return;
		}
		
		for(int i=0; i<=9; i++) {
			if(visited[i]) continue;
			// depth가 0이면 비교할 숫자가 하나밖에 없음 다음 숫자로 패스
			// 비교한 두 숫자가 주어진 부등호의 조건과 맞다면 계속 진행 
			if(depth==0 || check(Character.getNumericValue(num.charAt(depth -1)), i, sign[depth-1])) {
				visited[i]= true;
				backtrack(num+i, depth+1);
				visited[i] = false;
			}
		}
		
	}
	
	private static boolean check(int a, int b, char c) {
		if (c=='<') {
			if( a>b) return false;
		}
		else if( c=='>') {
			if(a<b) return false;
		}
		return true;
	}
	
}