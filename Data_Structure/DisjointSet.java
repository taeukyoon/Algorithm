import java.util.Arrays;

/*
 Data Structure
 서로소 집합(DisJointSet), (Union-find)
 Date: 21-12-26
 */
public class DisjointSet {
    public static void main(String[] args) {
        int[] parent = MakeSet(5);
        System.out.println(Arrays.toString(parent));

        union(parent, 1, 2);
        System.out.println(Arrays.toString(parent));
        union(parent, 2, 3);
        System.out.println(Arrays.toString(parent));
        union(parent, 4, 5);
        System.out.println(Arrays.toString(parent));
        union(parent, 3, 5);
        System.out.println(Arrays.toString(parent));
        System.out.println(find(parent, 1));
        System.out.println(find(parent, 2));
        System.out.println(find(parent, 3));
        System.out.println(find(parent, 4));
        System.out.println(find(parent, 5));
    }

    private static int[] MakeSet(int size) {
        int[] arr = new int[size + 1];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private static void union(int[] parent, int a, int b) {
        int x1 = find(parent, a);
        int x2 = find(parent, b); //부모값 찾기

        //작은쪽으로 흡수
        if (x1 > x2) {
            parent[x1] = x2;
        } else {
            parent[x2] = x1;
        }
    }

    private static int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return find(parent, parent[x]);
        }
    }

}