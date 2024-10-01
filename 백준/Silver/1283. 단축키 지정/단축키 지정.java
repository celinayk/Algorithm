import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	   public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int n = Integer.parseInt(br.readLine());
	        String[] arr = new String[n];
	        Set<Character> key = new HashSet<>();
	        
	        // 입력 받기
	        for(int i = 0; i < arr.length; i++) {  
	            arr[i] = br.readLine();
	        }
	        
	        // 각 옵션에 대해 단축키 지정
	        for(int i = 0; i < arr.length; i++) {
	            String[] words = arr[i].split(" ");  // 옵션을 단어로 분리
	            boolean check = false;  // 각 옵션에 대해 새롭게 초기화

	            // 1번 규칙: 단어의 첫 글자를 확인
	            for (int j = 0; j < words.length; j++) {
	                char firstChar = Character.toUpperCase(words[j].charAt(0));
	                if (!key.contains(firstChar)) {
	                    key.add(firstChar);  // 단축키로 지정
	                    words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1);  // 대괄호 추가
	                    check = true;  // 규칙1이 적용됨
	                    break;  // 1번 규칙이 적용되면 해당 옵션에 대해 2번 규칙은 실행되지 않음
	                }
	            }

	            // 2번 규칙: 1번 규칙이 적용되지 않은 경우
	            if (!check) {
	                for (int j = 0; j < words.length; j++) {
	                    for (int k = 0; k < words[j].length(); k++) {
	                        char currentChar = Character.toUpperCase(words[j].charAt(k));
	                        if (!key.contains(currentChar)) {
	                            key.add(currentChar);  // 사용되지 않은 문자를 단축키로 지정
	                            words[j] = words[j].substring(0, k) + "[" + words[j].charAt(k) + "]" + words[j].substring(k + 1);
	                            check = true;
	                            break;  // 2번 규칙이 적용되면 더 이상 탐색하지 않음
	                        }
	                    }
	                    if (check) break;  // 단축키가 지정되면 반복문 종료
	                }
	            }
	            
	            // 변경된 옵션을 다시 arr에 저장
	            arr[i] = String.join(" ", words);
	        }

	        // 결과 출력
	        for (String option : arr) {
	            System.out.println(option);
	        }
	    }
	}