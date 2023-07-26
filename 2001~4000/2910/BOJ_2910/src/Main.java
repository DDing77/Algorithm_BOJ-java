import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    int N;
    int C;
    HashMap<Integer, Message> hashMap;
    ArrayList<Message> list;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        hashMap = new HashMap<>();
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());

            if (!hashMap.containsKey(cur)) {
                Message message = new Message(i, cur, 1);
                list.add(message);
                hashMap.put(cur, message);
            } else {
                hashMap.get(cur).increment();
            }
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            Message message = list.get(i);
            int cnt = message.cnt;
            while (cnt-- > 0) {
                sb.append(message.number + " ");
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    class Message implements Comparable<Message> {
        int idx;
        int number;
        int cnt;

        public Message(int idx, int number, int cnt) {
            this.idx = idx;
            this.number = number;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Message o) {
            if (this.cnt == o.cnt) {
                return this.idx - o.idx;
            }
            return o.cnt - this.cnt;
        }

        public void increment() {
            this.cnt++;
        }
    }
}
