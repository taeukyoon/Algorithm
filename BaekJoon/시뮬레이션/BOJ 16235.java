import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 BOJ 16235 나무 재테크
 Date: 21-11-07
 solve: 시뮬레이션, 구현
 feedBack: 나무의 좌표 정보입력을 1로했는데 map의 시작 좌표를 0으로 설정해서 실패함
 */
public class Main{
    static int N, M, K, year;
    static int[][] A, map;
    static LinkedList<Tree> trees;
    static Queue<Tree> dead;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        A = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = 5;
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        trees = new LinkedList<>();
        dead = new LinkedList<>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            trees.add(
                    new Tree(
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken())
                    )
            );
        }
        year = 0;
        process();
        System.out.println(trees.size());
    }
    public static void process() {
        while (true) {
            if(K == year) return;

            //Spring
            Iterator<Tree> iter = trees.iterator();
            while (iter.hasNext()) {
                Tree tree = iter.next();
                int x = tree.x;
                int y = tree.y;
                int age = tree.age;

                if(map[x][y] - age < 0) { //양분 > 나이 -> 나이만큼 양분먹고 나이증가
                    dead.offer(tree);
                    iter.remove();
                } else {
                    map[x][y] -= age;
                    tree.age += 1;
                }
            }

            //Summer
            while(!dead.isEmpty()) { //죽은나무 꺼낸후 그 좌표에 나무의 나이 나누기 2한값을 더해준다
                Tree tree = dead.poll();
                map[tree.x][tree.y] += tree.age / 2;
            }

            //Fall
            LinkedList<Tree> newTree = new LinkedList<>();
            for(Tree tree : trees) {
                int x = tree.x;
                int y = tree.y;

                if (tree.age % 5 != 0) continue;
                for (int k = 0; k < 8; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
                    newTree.add(new Tree(nx, ny, 1));
                }
            }
            trees.addAll(0, newTree);

            //Winter
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    map[i][j] += A[i][j];
                }
            }
            year++;
        }
    }
}

class Tree {

    public Tree(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }

    int x, y, age;
}