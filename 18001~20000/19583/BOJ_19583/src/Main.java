import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private String courSeStartTime;
    private String courseEndTime;
    private String streamingEndTime;
    private HashSet<String> users;
    private int res;

    private void solution() throws IOException {

        users = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        courSeStartTime = st.nextToken();
        courseEndTime = st.nextToken();
        streamingEndTime = st.nextToken();

        String input;
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            String time = st.nextToken();
            String name = st.nextToken();

            if (time.compareTo(streamingEndTime) > 0) {
                break;
            }
            if (time.compareTo(courSeStartTime) <= 0) {
                users.add(name);
            } else if (time.compareTo(courseEndTime) >= 0 && time.compareTo(streamingEndTime) <= 0) {
                if (users.contains(name)) {
                    res++;
                    users.remove(name);
                }
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
