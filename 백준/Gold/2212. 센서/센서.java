import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] road =  new int[n];

        for (int i = 0; i < n; i++) {
            road[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(road);

        if(k>n) {
            System.out.println(0);
        }
        else {
            //배열의 차를 저장할 배열
            int[] diff = new int[n-1];
            for(int i=0; i<n-1; i++) {
                diff[i] = road[i+1] - road[i];
            }
            Arrays.sort(diff);

            for(int i=0; i<k-1; i++) {
                diff[diff.length-1-i] = 0;
            }

            int sum = 0;
            for(int i=0; i<diff.length; i++) {
                sum += diff[i];
            }
            System.out.println(sum);
        }
        
    }
}