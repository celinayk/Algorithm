import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] arr ;
    static int n, m;
    static int maxx;
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }

        for (int i : arr) {
            maxx=Math.max(maxx,i);
        }
        int ans = binarysearch(arr);
        System.out.println(ans);

    }

    private static int binarysearch(int[] arr){
        int start = maxx;
        int end = Integer.MAX_VALUE;
        int ans = 0;


        while(start <= end){
            int mid = start + (end - start) / 2;
            int cnt = 0; // 인출 여부

            int charge = 0; // 하루동안 쓰고 남은돈=현재 내 돈

            for(int i=0; i<n; i++) {
                if(charge < arr[i]) { // 돈모자라면 인출해야함
                    cnt++;
                    charge=mid-arr[i];
                } else { //안모자라면 그냥 남은 charge에서 빼서씀
                    charge = charge - arr[i];
                }
            }

            if(cnt>m) { //5번 인출해야하는데 6번 인출한 경우 -> 인출해야할 금액의 액수를 늘린다
                start = mid + 1;
            } else {
                // 일단 정답으로 킵해둠
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }



}