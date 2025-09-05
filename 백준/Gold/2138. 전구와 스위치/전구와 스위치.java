import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Main {
    static int n, ch1, ch2;
    static int[]arr, brr, result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n  = Integer.parseInt(br.readLine());

        String str1 = br.readLine(); // 000
        String str2 = br.readLine(); // 010

        arr = new int[n]; //
        brr = new int[n];
        result = new int[n];

        ch1 = 0;
        ch2 = 0;

        for(int i = 0; i <n; i++) {
            arr[i] = str1.charAt(i)-'0';
            brr[i] = str1.charAt(i)-'0';
            result[i] = str2.charAt(i)-'0';
        }

        swap(brr,0);
        ch2++;

        for(int i=1; i<n; i++) {
            if(arr[i-1]!=result[i-1]) {
                swap(arr,i);
                ch1++;
            }
            if(brr[i-1]!=result[i-1]) {
                swap(brr,i);
                ch2++;
            }
        }

        if(check(arr, result) && check(brr, result)) {
            ch1 = (ch1 < ch2) ? ch1 : ch2;
            System.out.println(ch1);
        } else if(check(arr, result)) {
            System.out.println(ch1);
        } else if(check(brr, result)) {
            System.out.println(ch2);
        } else {
            System.out.println(-1);
        }


    }

    private static void swap(int[] arr, int i) {

        if(i>0) {
            if(arr[i-1] == 1) arr[i-1]=0;
            else arr[i-1]=1;
        }

        if(arr[i]==1) arr[i]=0;
        else arr[i]=1;

        if(i==n-1) return;

        if(arr[i+1]==1) arr[i+1] =0;
        else arr[i+1]=1;

        return;

    }

    private static boolean check(int[] arr, int[] brr) {
        for(int i=0; i<n; i++) {
            if(arr[i]!=brr[i]) {
                return false;
            }
        }
        return true;
    }


}

