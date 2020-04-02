import java.util.*;

public class LargestRectangularSubmatrixWith1s {
    public static void main(String[] args) {
        int arr[][] = {{0, 1, 1, 0},
                         {1, 1, 1, 1},
                         {1, 1, 1, 1},
                        };
        int maxArea = largestRectangularWith1s(arr);
        System.out.println(maxArea);
    }

    static int largestRectangularWith1s(int arr[][]) {
        if(arr == null) {
            return -1;
        }

        int m = arr.length;
        int n = arr[0].length;
        //t[j] denotes the height with all 1s with arr[j] as the bottom row
        int t[] = new int[n];
        int maxArea = Integer.MIN_VALUE;
        
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(i == 0) {
                    t[j]  = arr[i][j];
                } else {
                    if(arr[i][j] == 1) {
                        t[j] = t[j] + 1;
                    } else {
                        t[j] = 0;
                    }
                }
            }
            int area = getMaxHistogramArea(t);
            if(area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    private static int getMaxHistogramArea(int arr[]) {
        int maxArea = Integer.MIN_VALUE;
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while(i < n) {
            if(stack.isEmpty() || arr[i] > arr[stack.peek()]) {
                stack.push(i);
                ++i;
            } else {
                int top = stack.pop();
                int area = 0;
                if(stack.isEmpty()) {
                    area = arr[top] * i;
                } else {
                    int j = stack.peek();
                    area = arr[top] * (i - j - 1);
                }

                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        while(stack.isEmpty() == false) {
            int top = stack.pop();
            int area = 0;
            if(stack.isEmpty()) {
                area = arr[top] * i;
            } else {
                int j = arr[stack.peek()];
                area = arr[top] * (i - j - 1);
            }

            if(area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }
}