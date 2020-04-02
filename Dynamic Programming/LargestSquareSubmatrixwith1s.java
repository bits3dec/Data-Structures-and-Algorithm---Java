public class LargestSquareSubmatrixwith1s {
    public static void main(String[] args) {
        int arr[][] = {{0, 1, 1, 0, 1},  
        {1, 1, 0, 1, 0},  
        {0, 1, 1, 1, 0},  
        {1, 1, 1, 1, 0},  
        {1, 1, 1, 1, 1},  
        {0, 0, 0, 0, 0}};

        int maxArea = largestSquareSubmatrixwith1s(arr);
        System.out.println(maxArea);
    }

    static int largestSquareSubmatrixwith1s(int arr[][]) {
        if(arr == null) {
            return -1;
        }

        int m = arr.length;
        int n = arr[0].length;
        //t[i][j] denotes the largest square submatrix with all 1s with arr[i][j] as the right most bottom entry
        int t[][] = new int[m][n];
        int maxArea = Integer.MIN_VALUE;

        for(int j = 0; j < n; ++j) {
            if(arr[0][j] == 1) {
                t[0][j] = 1;
                if(t[0][j] > maxArea) {
                    maxArea = t[0][j];
                }
            }
        }

        for(int i = 0; i < m; ++i) {
            if(arr[i][0] == 1) {
                t[i][0] = 1;
                if(t[i][0] > maxArea) {
                    maxArea = t[i][0];
                }
            }
        }

        for(int i = 1; i < m; ++i) {
            for(int j = 1; j < n; ++j) {
                if(arr[i][j] == 1) {
                    t[i][j] = min(t[i][j-1], t[i-1][j-1], t[i-1][j]) + 1;
                    if(t[i][j] > maxArea) {
                        maxArea = t[i][j];
                    }
                }
            }
        }
        return maxArea;
    }

    private static int min(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }
}