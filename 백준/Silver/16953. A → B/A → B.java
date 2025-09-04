import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.lang.Long.MAX_VALUE;

public class Main {
    static long a,b;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        a =  Long.parseLong(st.nextToken());
        b =  Long.parseLong(st.nextToken());


        long ans =bfs( a);
        if(ans ==-1) {
            System.out.println(-1);
        } else {
            System.out.println(ans+1);
        }

    }

    private static long bfs(long a) {
        Queue<long[]> q = new LinkedList<>();
        q.offer(new long[]{a,0});


        while(!q.isEmpty()) {
            long[] now = q.poll();
            long cur = now[0];
            long cnt = now[1];

            if(cur==b) {
                return cnt;
            }

            if(cur*2 <= b) {
                q.offer(new long[]{cur*2,cnt+1});
            }

            if(cur*10+1 <= b) {
                q.offer(new long[]{cur*10+1,cnt+1});
            }

        }
        return -1;
    }
}

