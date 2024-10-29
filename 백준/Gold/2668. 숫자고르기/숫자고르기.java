import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;
	static int[] arr;
	static List<Integer> answer;
	static TreeSet<Integer> set = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++) {
        	arr[i]= Integer.parseInt(br.readLine());
        }
        
        for(int i=1; i<=n; i++) {
        	if(!visited[i]) {
        		answer = new ArrayList<>();
        		int target = i;
        		visited[i]=true;
        		answer.add(i);
        		dfs(i, target);
        	}
        }
        System.out.println(set.size());
		for(int output : set) {
			System.out.println(output);
		}
        

    }
	private static void dfs(int cur, int target) {
		if(arr[cur]==target) {
			for(int i: answer) {
				set.add(i);
			}
			return;
		}
		if(!visited[arr[cur]]) {
			visited[arr[cur]]=true;
			answer.add(arr[cur]);
			dfs(arr[cur], target);
			visited[arr[cur]]=false;
		}
		
	}
}
