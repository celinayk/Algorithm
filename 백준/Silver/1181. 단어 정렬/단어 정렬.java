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


public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int n = Integer.parseInt(br.readLine());
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split("\n");
			String key = input[0];
			int len = key.length();
			map.put(key, len);
		}
		
		List<String> setlist = new ArrayList<>(map.keySet());
		
		Collections.sort(setlist, (n1, n2) ->  {
			int m1 = map.get(n1);
			int m2 = map.get(n2);
			return (m1 == m2) ? n1.compareTo(n2) : m1 - m2;	
		});
		
		for(String key : setlist) {
			System.out.println(key);
		}
		
	}
}
