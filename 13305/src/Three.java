import java.util.*;

public class Three {
    static int ans =0;
    public static class SUBCLASS{
        String day;
        int time;
        boolean isSub = false;

        public SUBCLASS(String day, int time) {
            this.day = day;
            this.time = time;
        }
        public SUBCLASS(String day, int time, boolean isSub) {
            this.day = day;
            this.time = time;
            this.isSub = true;
        }
    }
    static ArrayList<SUBCLASS> subclasses = new ArrayList<>();

    static void parseString(String str) {
        if(str.length() == 19) {
            subclasses.add(new SUBCLASS(str.substring(1,2), Integer.parseInt(str.substring(4,5)) *60 + Integer.parseInt(str.substring(7,8))));
            subclasses.add(new SUBCLASS(str.substring(10,11), Integer.parseInt(str.substring(13,14)) *60 + Integer.parseInt(str.substring(16,17))));
        }
        if(str.length() == 10) {
            subclasses.add(new SUBCLASS(str.substring(1,2), Integer.parseInt(str.substring(4,5)) *60 + Integer.parseInt(str.substring(7,8))));
        }
    }

    public int solution(String[][] schedule){

        return ans;
    }
}
