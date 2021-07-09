public class permutation {

    /*
    순열 알고리즘
     */

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        perm(arr,0,4,4);
    }

    public static void perm(int[] arr, int depth, int n, int k) {

        if(depth == k) {
            print(arr,k);
            return;
        }
        for(int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k); //재귀
            swap(arr, i , depth);
        }
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void print(int[] arr, int k) {
        for(int i = 0; i < k; i++) {
            if(i == k-1) {
                System.out.println(arr[i]);
            }else {
                System.out.print(arr[i] + ",");
            }
        }
    }
}
