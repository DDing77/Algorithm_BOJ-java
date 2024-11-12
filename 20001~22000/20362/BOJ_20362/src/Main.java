import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private String S;
    private String answerMessage;
    private int answerMessageIdx;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = st.nextToken();

        ArrayList<MessageLog> log = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String message = st.nextToken();

            if (name.equals(S)) {
                answerMessage = message;
                answerMessageIdx = i;
            }
            log.add(new MessageLog(name, message));
        }

        for (int i = 0; i < answerMessageIdx; i++) {
            if (log.get(i).message.equals(answerMessage)) {
                res++;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class MessageLog {

        String name;
        String message;

        public MessageLog(String name, String message) {
            this.name = name;
            this.message = message;
        }
    }
}
