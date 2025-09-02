import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] arr ;
    static int n, m;
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];

        for(int i=0; i<m; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int ans = binarysearch(arr);
        System.out.println(ans);

    }
    private static int binarysearch(int[] arr){
        int start = 1;
        int end = arr[arr.length-1];
        int ans = 0;

        while(start <= end){
            int sum = 0;
            int mid = (start+end)/2;

            for(int i=0; i<m; i++) {
                if(arr[i]/mid > 0) {
                    sum+=arr[i]/mid;
                    if(arr[i]%mid !=0) {
                        sum++;
                    }
                }
                else { //몫이 0이면 무조건 그냥 1번만 더하면됨
                    sum++;
                }
            }

            if(sum<=n) {
                end= mid-1;
                ans =  mid; // 일단 담아둠

            } else {
                start = mid + 1;
            }

        }
        return ans;
    }



}