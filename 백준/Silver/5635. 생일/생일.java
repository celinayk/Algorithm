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

class User {
	
	String name;
	int dd;
	int mm;
	int yyyy;
	
	User(String name, int dd, int mm, int yy) {
		this.name = name;
		this.dd = dd;
		this.mm=mm;
		this.yyyy=yy;
	}
}

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int n = Integer.parseInt(br.readLine());
		
		List<User> users = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			String name = input[0];
			int dd = Integer.parseInt(input[1]);
			int mm = Integer.parseInt(input[2]);
			int yy = Integer.parseInt(input[3]);
			users.add(new User(name, dd, mm, yy));
		}
		
		users.sort((u1, u2) -> {
			if(u1.yyyy == u2.yyyy) {
				if(u1.mm == u2.mm) {
					return Integer.compare(u1.dd, u2.dd);
				}
				else { //년도는 같고 달을 다르면
					return Integer.compare(u1.mm, u2.mm);
				}	
			}
			return Integer.compare(u1.yyyy, u2.yyyy);
		});
		
		System.out.println(users.get(users.size()-1).name);
		System.out.println(users.get(0).name);
		
		
		
		
		
	}
}
