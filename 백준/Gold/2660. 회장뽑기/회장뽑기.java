import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int n;
    static boolean[] visited;
    static int[][] arr;
    static int[] ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine()); // 회원의 수

        visited = new boolean[n+1];
        ans = new int[n+1]; // 각 회원의 점수 입력할 정답 배열
        arr = new int[n+1][n+1];

        //StringTokenizer st = new StringTokenizer(br.readLine());

        // -1 -1이 나올때가지 회원친구 관계도 입력받기
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v =  Integer.parseInt(st.nextToken());
            int u  =  Integer.parseInt(st.nextToken());

            if(v==-1 && u==-1) {
                break;
            }

            arr[v][u] = arr[u][v] = 1;
        }

        for(int i=1; i<=n; i++) {
            bfs(i);
        }

        // ans배열의 최소값 구하기
        int min = ans[1];
        int cnt = 0;
        for(int i=1; i<=n; i++) {
            if(ans[i]<min) {
                min = ans[i];
            }
        }

        for(int i=1; i<=n; i++) {
            if(ans[i]==min) {
                cnt++;
            }
        }

        System.out.print(min+ " "); // 점수
        System.out.println(cnt); // 후보의 수

        for(int i=1; i<=n; i++) {
            if(ans[i]==min) {
                System.out.print(i+ " ");
            }
        }



    }

    static void bfs(int node) {
        // 각 노드만을 위한 방문배열과 거리 저장 배열
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];

        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.offer(node);

        while(!q.isEmpty()) {
            int curr =  q.poll(); // 1
            for(int next = 1; next<=n; next++) { // 나와 인접한 노드 찾기 = 나와 친구인 사람찾기(바로연결되어있는)
                if(!visited[next] && arr[curr][next]==1) {
                    visited[next] = true; // 그 친구도 방문처리
                    // 그 친구와 기준이 되는 노드와의 거리를 측정해서 배열 저장
                    dist[next] = dist[next] + dist[curr] +1;
                    q.offer(next);
                }
            }
        }

        // 각 노드에 대한 거리 배열 가장 큰값이 그 노드의 점수다.
        int max = 0;
        for(int i=1; i<=n; i++) {
            max = Math.max(max,dist[i]); // 노드1의 경우는 3이 점수다.
        }

        ans[node] = max; // 정답배열에 각 노드의 점수 삽입
    }



}

