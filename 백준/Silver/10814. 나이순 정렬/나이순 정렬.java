import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Member {
	int age;
	String name;
	
	Member(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int n = Integer.parseInt(br.readLine());
		
		List<Member> members = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			String[] input = br.readLine().split(" ");
			int age = Integer.parseInt(input[0]);
			String name = input[1];
			members.add(new Member(age, name));
		}
		
		members.sort(Comparator.comparingInt(m -> m.age));
		
		for (Member member : members) {
            System.out.print(member.age +" "+member.name);
            System.out.println();
        }
	}
}
