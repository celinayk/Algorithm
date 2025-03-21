class Solution {
    static int answer=0;
    static int n=0;
    static int t;             // 추가
    static int[] num; 
    public int solution(int[] numbers, int target) {
    
    num = numbers;
    t= target;
    n = numbers.length;
    back(0,0);
    return answer; 
        
    }
    
    private static void back(int sum, int depth) {
        // 종료조건
        if(depth == n) {
            if(sum==t) {
                answer++;
            }
            return;
        }
        
        //더하기
        back(sum+num[depth], depth+1);
        //빼기
        back(sum-num[depth], depth+1);
    }
    
}