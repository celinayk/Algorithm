import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            map.put(st.nextToken(), 0);
        }

        for(int i=0; i<n; i++) {
            st= new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()) {
                String s = st.nextToken();
                map.put(s, map.get(s) + 1);
            }

        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> {
            if(map.get(o1)-map.get(o2) ==0) {
                return o1.compareTo(o2);
            }else {
                return map.get(o2) - map.get(o1);
            }
        });

        for(String key : list) {
            System.out.println(key+" "+ map.get(key));
        }

    }


}