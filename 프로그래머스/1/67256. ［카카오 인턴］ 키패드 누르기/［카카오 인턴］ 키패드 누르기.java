class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        // 1단계 -> 시작지점
        int left = 10;
        int right = 12;
        
        for(int num : numbers) {
            if(num==0) num=11;
            // 왼손 이동
            if(num == 1 || num == 4 || num == 7) {
                sb.append("L");
                left = num;
            }
            
            // 오른속 이동
            else if(num== 3 || num == 6 || num== 9) {
                sb.append("R");
                right = num;
            }
            
            // 2,5,8,0의 경우
            else {
                int n=Math.abs(left-num);
                    int left_dist = (n/3)+(n%3);
                    
                    n=Math.abs(right-num);
                    int right_dist = (n/3)+(n%3);
                    
                    if(left_dist>right_dist) {
                        //오른손이 선택
                        sb.append("R");
                        right = num;
                    } else if(left_dist<right_dist) {
                        sb.append("L");
                        left = num;
                    } else { //거리같으면
                        if(hand.equals("right")) {
                            sb.append("R");
                            right = num;
                        } else  {
                            sb.append("L");
                             left = num;
                        }
                        
                    }
            }    
        }
        return sb.toString();
    }
}