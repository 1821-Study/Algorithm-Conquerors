import java.util.*;
import java.io.*;

/**
 * 마인크래프트
 * https://www.acmicpc.net/problem/18111
 */
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        Minecraft.n = Integer.parseInt(st.nextToken());
        Minecraft.m = Integer.parseInt(st.nextToken());
        Minecraft.baseLeft = Integer.parseInt(st.nextToken());
        Minecraft.map = new int[Minecraft.n][Minecraft.m];
        Minecraft answer = null;
        int maxHeight = Integer.MIN_VALUE;
        int minHeight = Integer.MAX_VALUE;

        for (int i = 0; i < Minecraft.n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < Minecraft.m; j++) {
                Minecraft.map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, Minecraft.map[i][j]);
                minHeight = Math.min(minHeight, Minecraft.map[i][j]);
            }
        }

        for (int i = minHeight; i <= maxHeight; i++) {
            Minecraft minecraft = new Minecraft(i);
            minecraft.flat();
            if(Objects.isNull(answer) || answer.compareTo(minecraft) > 0){
                answer = minecraft;
            }
        }

        System.out.println(answer);
    }

    static class Minecraft implements Comparable<Minecraft>{
        static int n;
        static int m;
        static int[][] map;
        static int baseLeft;
        int left;
        int time;
        int height = 0;

        public Minecraft(int height) {
            this.height = height;
            left = Minecraft.baseLeft;
            this.time = 0;
        }

        void flat(){
            actionFlat(height, (i, j, h) -> {
                int gap = map[i][j] - h;
                time += (gap * 2);
                left += gap;
            }, (i, j, h) -> {
                int gap = h - map[i][j];
                time += gap;
                left -= gap;
            });

            if(left < 0) time = Integer.MAX_VALUE;
        }

        private void actionFlat(int height, TriConsumer<Integer, Integer, Integer> higher,
                                TriConsumer<Integer, Integer, Integer> lower) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j] > height) higher.apply(i, j, height);
                    else lower.apply(i, j, height);
                }
            }
        }

        @Override
        public int compareTo(Minecraft o) {
            if(Integer.compare(this.time, o.time) == 0){
                return Integer.compare(this.height, o.height);
            } else {
                return Integer.compare(this.time, o.time);
            }
        }

        @Override
        public String toString() {
            return time + " " + height;
        }
    }

    @FunctionalInterface
    interface TriConsumer<T, U, V>{
        void apply(T t, U u, V v);
    }
}
