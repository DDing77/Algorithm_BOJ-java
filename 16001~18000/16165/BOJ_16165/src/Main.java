import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int N;
    int M;
    HashMap<String, List<String>> groups;

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        String groupName;
        int memberCount;
        groups = new HashMap<>();
        for (int i = 0; i < N; i++) {
            groupName = br.readLine();
            memberCount = Integer.parseInt(br.readLine());

            List<String> members = new ArrayList<>();
            for (int j = 0; j < memberCount; j++) {
                members.add(br.readLine());
            }

            Collections.sort(members);
            groups.put(groupName, members);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            String type = br.readLine();

            if(type.equals("0")) {
                for (String member : groups.get(name)) {
                    sb.append(member).append("\n");
                }
            }

            if(type.equals("1")) {
                for (String group : groups.keySet()) {
                    if(groups.get(group).contains(name)) {
                        sb.append(group).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
