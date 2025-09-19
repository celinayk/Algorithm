import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
    static int n,k,result;
    static int[] door;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());

        String[] opened = br.readLine().split(" ");
        int left = Integer.parseInt(opened[0]);
        int right = Integer.parseInt(opened[1]);


        k =  Integer.parseInt(br.readLine());
        door = new int[k];
        for(int i=0; i<k; i++) {
            door[i] =  Integer.parseInt(br.readLine());
        }

        result = Integer.MAX_VALUE;
        dfs(0,left, right, 0);
        System.out.println(result);

    }

    private static void dfs(int idx, int left, int right, int sum) {
        if(result <=sum) {
            return;
        }
        if(idx == k) {
            result = sum;
            return;
        }
        //열어야 하는 문이 왼쪽열린문과 오른쪽 열린문 사이에 있다면 둘다 탐색
        if(left ==door[idx] || right == door[idx]) {
            dfs(idx+1, left, right, sum);
        }
        else if(left <door[idx] && right > door[idx]) {
            dfs(idx+1, door[idx], right, sum + door[idx]-left);
            dfs(idx+1, left, door[idx], sum +right -  door[idx]);
        } else if(door[idx]<left) { //열어야 하는 문이 두개의 열린문보다 왼쪽에 있으면
            //왼쪽에 열린문을 당겨서 사용
            dfs(idx+1, door[idx], right, sum+left-door[idx]);
        } else {
            dfs(idx+1, left, door[idx], sum+door[idx]-right);
        }

    }


}

