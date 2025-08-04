import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static int m,n;
    static boolean num[];
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        num = new boolean[n+1];
        get_prime();

        StringBuilder sb = new StringBuilder();
        for(int i = m; i<=n; i++) {
            if(!num[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void get_prime() {
        // true 소수 아님 , false 소수임
        num[0] = num[1] = true;

        for(int i = 2; i<=Math.sqrt(n); i++) { //2부터 n의 제곱근까지 확인
            if(num[i]) { //소수라면 스킵
                continue;
            }
            for(int j=i*i; j<=n; j+=i) {
                num[j] = true;
            }
        }
    }
}