import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
 BOJ 17471 게리 맨더링
 */
public class Main {
    static int n;
    static int res = Integer.MAX_VALUE;
    static int[] peopleNum;
    static ArrayList<Integer>[] list;
    static boolean[] isArea;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        peopleNum = new int[n + 1];
        list = new ArrayList[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            peopleNum[i] = Integer.parseInt(st.nextToken());
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        isArea = new boolean[n + 1];
        permutation(1);
        System.out.println((res == Integer.MAX_VALUE) ? -1 : res);
    }

    public static void permutation(int idx) {
        if (idx == n + 1) {
            if (check()) {
                int sumA = 0, sumB = 0;

                for (int i = 1; i <= n; i++) {
                    if (isArea[i]) {
                        sumA += peopleNum[i];
                    } else {
                        sumB += peopleNum[i];
                    }
                }
                res = Math.min(res, Math.abs(sumA - sumB));
            }
            return;
        }

        //A 선거구
        isArea[idx] = true;
        permutation(idx + 1);

        //B 선거구
        isArea[idx] = false;
        permutation(idx + 1);
    }

    public static boolean check() {
        boolean[] visited = new boolean[n + 1];

        int areaA = 0;
        for (int i = 1; i <= n; i++) {
            if (isArea[i]) {
                areaA = i;
                break;
            }
        }

        int areaB = 0;
        for (int i = 1; i <= n; i++) {
            if (!isArea[i]) {
                areaB = i;
                break;
            }
        }

        if (areaA == 0 || areaB == 0) { //선거구는 하나이상 있어야 한다
            return false;
        }

        //a구역 연결확인
        Queue<Integer> qu = new LinkedList<>();
        qu.add(areaA);
        visited[areaA] = true;
        while (!qu.isEmpty()) {
            int cur = qu.poll();

            for (int i = 0; i < list[cur].size(); i++) { //인접한 지역만큼
                if (visited[list[cur].get(i)]) continue;

                if (isArea[list[cur].get(i)]) {
                    visited[list[cur].get(i)] = true;
                    qu.add(list[cur].get(i));
                }
            }
        }

        Queue<Integer> qu2 = new LinkedList<>();
        qu2.add(areaB);
        visited[areaB] = true;
        while (!qu2.isEmpty()) {
            int cur = qu2.poll();

            for (int i = 0; i < list[cur].size(); i++) {
                if (visited[list[cur].get(i)]) continue;;

                if (!isArea[list[cur].get(i)]) {
                    visited[list[cur].get(i)] = true;
                    qu2.add(list[cur].get(i));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}