package abc087.d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// この解法だとTLEする
public class Main {
    public static class InputData {
        public Integer L;
        public Integer R;
        public Integer D;
        public boolean done;
    }

    public static void dump(HashMap<Integer, Integer> in) {
        for (Integer k : in.keySet()) {
            System.out.println(k + " => " + in.get(k));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        List<InputData> input = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            InputData tmp = new InputData();
            tmp.L = sc.nextInt();
            tmp.R = sc.nextInt();
            tmp.D = sc.nextInt();
            tmp.done = false;
            input.add(tmp);
        }

        HashMap<Integer, Integer> defined = new HashMap();

        boolean first = true;
        int done_num = 0;
        int prev_done_num = 0;
        while(done_num != M) {
            // 相対距離が分かる集合が別に存在している
            if (done_num == prev_done_num) first = true;
            prev_done_num = done_num;
            for (InputData d : input) {
                if (d.done == true) continue;
                if (first && d.done == false) {
                    //System.out.println(d.R + "," + d.L);
                    defined.put(d.L, 0);
                    defined.put(d.R, d.D);
                    d.done = true;
                    first = false;
                    done_num++;
                    continue;
                }
                if (defined.containsKey(d.R) && defined.containsKey(d.L)) {
                    // 矛盾
                    if (defined.get(d.R) - defined.get(d.L) != d.D) {
                        System.out.println("No");
                        return;
                    }
                    d.done = true;
                    done_num++;
                    continue;
                }
                if (defined.containsKey(d.R) && !defined.containsKey(d.L)) {
                    defined.put(d.L, defined.get(d.R) - d.D);
                    d.done = true;
                    done_num++;
                    continue;
                }
                if (defined.containsKey(d.L) && !defined.containsKey(d.R)) {
                    defined.put(d.R, defined.get(d.L) + d.D);
                    d.done = true;
                    done_num++;
                    continue;
                }
            }
            //dump(defined);
        }
        System.out.println("Yes");
    }
}
