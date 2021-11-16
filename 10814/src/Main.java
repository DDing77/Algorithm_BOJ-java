import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static class User implements Comparable<User>{
        int year;
        String name;

        public User(int year, String name) {
            this.year = year;
            this.name = name;
        }

        @Override
        public int compareTo(User o) {
            return year- o.year;
        }
    }

    static User[] user;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        user = new User[N];

        for(int i=0; i<N;i ++) {
            st = new StringTokenizer(br.readLine());
            user[i] = new User(Integer.parseInt(st.nextToken()),st.nextToken());
        }
        Arrays.sort(user);
        for(int i=0; i<N; i++) {
            sb.append(user[i].year).append(" ").append(user[i].name).append("\n");
        }
        System.out.println(sb);

    }
}
