import java.util.Arrays;

public class MinimumJumps {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        int res = minJumps(arr);
        System.out.println(res);
    }

    static int minJumps(int arr[]) {
        int n = arr.length;

        //t[j] denotes the minimum jumps needed to reach "j"
        int t[] = new int[n];
        Arrays.fill(t, Integer.MAX_VALUE);
        t[0] = 0;

        for(int j = 1; j < n; ++j) {
            for(int i = 0; i < j; ++i) {
                if(t[i] != Integer.MAX_VALUE && i + arr[i] >= j) {
                    int jumps = t[i] + 1;
                    if(jumps < t[j]) {
                        t[j] = jumps;
                    }
                }
            }
        }
        return t[n-1];
    }
}