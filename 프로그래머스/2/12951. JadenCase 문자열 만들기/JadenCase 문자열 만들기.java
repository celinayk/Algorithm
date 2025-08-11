import java.util.Arrays;
class Solution {
    public String solution(String s) {
        if(s.length()==1) {
            s = s.toUpperCase();
            return s;
        }
        else {
            s = s.toLowerCase();
        char[]arr = s.toCharArray();
 
        for(int i=0; i<arr.length-1; i++) {
            //첫번째 문자라면 바로 대문자로 변환
            //예외 -> 첫번재가 공백일수도 있음
            if(arr[0] !=' ') {
                arr[0]=Character.toUpperCase(arr[0]);
            }
                
            //내 앞에 문자가 공백이라면 대문자로 변환
            //조건 추가 나도 공백이 아니어야함
            if(arr[i] == ' ' &&arr[i+1]!=' ' ) {
                arr[i+1]=Character.toUpperCase(arr[i+1]);
            }
        }
        String ans = new String(arr);       
        return ans;
        }
        
    }
}