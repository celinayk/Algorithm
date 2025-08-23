class Solution {
    public String solution(String new_id) {
        String answer = "";
        // 1단계 -> 전부 소문자로
        answer = new_id.toLowerCase();
        
        // 2단계 -> 해당 안되는 모든 문자 제거
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        
        // 3단계 -> . 연속 -> .치환
        answer = answer.replaceAll("\\.{2,}", ".");
        
        // 4단계 -> 처음 끝이면 . 제거
        answer = answer.replaceAll("^\\.|\\.$", "");
        
        // 5단계 -> 빈 문자열이면 
        if(answer.isEmpty()) {
            answer = "a";
        }
        
    
        // 6단계 -> 길이가 16자이상이면 나머지 제거
        if(answer.length() >=16) {
            answer =answer.substring(0,15);
        }
        answer = answer.replaceAll("^\\.|\\.$", "");
        
        // 7단계 -> 길이 2이하 
        while(answer.length()<3) {
            answer+=answer.charAt(answer.length()-1);
        }
        answer = answer.replaceAll("^\\.|\\.$", "");
        
        return answer;
    }
}