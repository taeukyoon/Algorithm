import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 BOJ 14274 
 */
public class Main {
    static int n;
    static class Tree implements Comparable<Tree> {
        int height, growth;

        public Tree(int height, int growth) {
            this.height = height;
            this.growth = growth;
        }
        @Override
        public int compareTo(Tree o) {
            return this.growth - o.growth;
        }
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        Tree[] trees = new Tree[n];

        String[] h = br.readLine().split(" ");
        String[] g = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int height = Integer.parseInt(h[i]);
            int growth = Integer.parseInt(g[i]);
            trees[i] = new Tree(height, growth);
        }
        Arrays.sort(trees);

        long sum = 0;
        int day = 0;
        for (int i = 0; i < trees.length; i++) {
            sum += trees[i].height + (long) trees[i].growth * day;
            day++;
        }
        System.out.println(sum);
    }
}
