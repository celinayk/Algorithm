import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] arr ;
    static int n, m;
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());

        System.out.println(binarysearch(arr, n));
    }

    private static int binarysearch(int[] arr, int n) {
        int low = 0;
        int high = arr[n-1];
        int ans = 0;

        while(low<=high) {
            int mid = (low+high)/2;
            long sum = check(mid);
            if(sum>m) { //490>=484 -> mid값 내려서 다시 탐색
                high = mid-1;
            } else { // mid 값 올리기
                low = mid + 1;
                ans = mid; // 일단 정답킵
            }

        }
        return ans;
    }

    private static int check(int mid) {
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[i]<=mid) {
                sum+=arr[i];
            } else {
                sum+=mid; //상한액보다 예산이 크면 상한액만큼만 더한다
            }
        }
        return sum;
    }
}