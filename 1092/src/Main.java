import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer> cranes = new ArrayList<>();
    static ArrayList<Integer> boxes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) cranes.add(Integer.parseInt(st.nextToken()));
        Collections.sort(cranes, Collections.reverseOrder());

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) boxes.add(Integer.parseInt(st.nextToken()));
        Collections.sort(boxes, Collections.reverseOrder());

        int cnt = 0;

        if(cranes.get(0) < boxes.get(0)) {
            System.out.println(-1);
        } else {
            while(!boxes.isEmpty()) {
                int idx = 0;
                for(int i = 0; i< cranes.size();) {
                    if(idx == boxes.size()) break;
                    if(cranes.get(i) >= boxes.get(idx)) {
                        boxes.remove(idx);
                        i++;
                    } else idx++;
                }
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}
