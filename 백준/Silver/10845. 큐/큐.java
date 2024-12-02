import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> q = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
        	st = new StringTokenizer(br.readLine());
        	String input = st.nextToken();
        	switch(input) {
        	case "push":
        		int num = Integer.parseInt(st.nextToken());
        		q.add(num);
        		break;
        	case "pop":
        		if(q.isEmpty()) {
        			sb.append(-1).append("\n");
        		}
        		else {
        			sb.append(q.poll()).append("\n");
        		}
        		break;
        	case "size":
        		sb.append(q.size()).append("\n");
        		break;
        	case "empty":
        		if(q.isEmpty()) {
        			sb.append(1).append("\n");
        		}
        		else {
        			sb.append(0).append("\n");
        		}
        		break;
        	case "front":
        		if(q.isEmpty()) {
        			sb.append(-1).append("\n");
        		}
        		else {
        			sb.append(q.peek()).append("\n");
        		}
        		break;
        	case "back":
        		if(q.isEmpty()) {
        			sb.append(-1).append("\n");
        		}
        		else {
        			sb.append(q.getLast()).append("\n");
        		}
        		break;
        	}
        }
        System.out.println(sb);
    }
}

