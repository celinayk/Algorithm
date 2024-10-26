import java.io.*;
import java.util.*;

class Student {
    int num;   // 학생 번호
    int like;  // 추천 횟수
    int time;  // 추천된 순서

    public Student(int num, int like, int time) {
        this.num = num;
        this.like = like;
        this.time = time;
    }
}

public class Main {
    static Student[] students = new Student[101]; // 1~100번 학생을 위한 배열
    static List<Student> photos = new ArrayList<>(); // 사진틀에 게시된 학생 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 사진틀 개수
        int n = Integer.parseInt(br.readLine());
        // 추천 횟수
        int k = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 이미 사진틀에 있는 학생이라면
            if (students[num] != null) {
                students[num].like++; // 추천 수 증가
            } else { // 해당 학생이 사진틀에 없으면
                // 사진틀이 꽉 찼다면
                if (photos.size() == n) {
                    removeLeastLikedStudent(); // 추천 수가 가장 적은 학생 제거
                }
                // 새로운 학생 추가
                students[num] = new Student(num, 1, i); // 새 학생 객체 생성
                photos.add(students[num]); // 사진틀에 추가
            }
        }

        // 학생 번호로 정렬
        Collections.sort(photos, Comparator.comparingInt(s -> s.num));
        for (Student s : photos) {
            System.out.print(s.num + " ");
        }
    }

    // 추천 수가 가장 적은 학생 삭제
    private static void removeLeastLikedStudent() {
        int minIndex = 0; // 최소 like를 가진 학생의 인덱스
        for (int i = 1; i < photos.size(); i++) {
            if (photos.get(i).like < photos.get(minIndex).like) {
                minIndex = i; // 최소 like 인덱스 업데이트
            } else if (photos.get(i).like == photos.get(minIndex).like) {
                // 추천 수가 같다면 시간 기준으로 비교
                if (photos.get(i).time < photos.get(minIndex).time) {
                    minIndex = i; // 시간 기준으로 업데이트
                }
            }
        }
        Student del = photos.remove(minIndex); // 해당 학생 삭제
        students[del.num] = null; // 해당 학생을 null로 설정
    }
}
