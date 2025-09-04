import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static boolean[][] visited;
    static int s;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());

        visited = new boolean[2001][2001]; //화면의 이모티콘, 클립보드에 복사된 이모티콘
        bfs(s);

    }

    public static class Node {
        int total;
        int clipboard;
        int time;

        public Node(int total, int clipboard, int time) {
            this.total = total;
            this.clipboard = clipboard;
            this.time = time;
        }
    }


    private static void bfs(int s) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1,0,0)); //현재이모티콘, 클립보드, 횟수
        visited[1][0] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if(now.total == s) {
                System.out.println(now.time);
                return;
            }

            // 화면의 이모티콘을 전부 복사해서 클립보드 저장하는 경우
            if(now.total > 0 && !visited[now.total][now.total]) {
                q.offer(new Node(now.total, now.total, now.time+1));
                visited[now.total][now.total] = true;
            }


            // 클립보드 이모티콘을 화면에 붙여넣기 하는 경우
            if (now.clipboard>0 &&  now.total+now.clipboard<2000 && !visited[now.total+now.clipboard][now.clipboard]) {
                q.offer(new Node(now.clipboard+now.total, now.clipboard,  now.time+1));
                visited[now.total+now.clipboard][now.clipboard] = true;
            }

            // 화면의 이모티콘 중 하나 삭제하는 경우
            if(now.total>0 &&!visited[now.total-1][now.clipboard] ) {
                q.offer(new Node(now.total-1, now.clipboard, now.time+1));
                visited[now.total-1][now.clipboard] = true;
            }
        }

    }


}

