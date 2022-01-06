import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        long distance;
        int A,B;

        public Edge(long distance, int A, int B) {
            this.distance = distance;
            this.A = A;
            this.B = B;
        }
        @Override
        public int compareTo(Edge o) {
            return distance > o.distance? 1: -1;
        }
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a == b) return false;
        else {
            if(a < b) parent[b] = a;
            else parent[a] = b;
        }
        return true;
    }
    static int[] parent;
    static int N ,M;
    static long ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ArrayList<Edge> arr = new ArrayList<>();

        parent = new int[N+1];
        for(int i=1; i<=N; i++) parent[i] = i;


        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            Edge edge = new Edge(c, a, b);
            arr.add(edge);
            ans += c;
        }
        Collections.sort(arr);

//        for(int i=0; i<arr.size(); i++){
//            System.out.println(arr.get(i).distance);
//        }
        int isolation = 0;
        for(int i=0; i<M; i++) {
            if(union(arr.get(i).A ,arr.get(i).B )) {
                ans -=arr.get(i).distance;
                isolation++;
            }
        }
        if(isolation != N-1) ans= -1;
        System.out.println(ans);
    }
}
