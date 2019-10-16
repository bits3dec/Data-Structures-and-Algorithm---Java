package co.practice.dp.matrixChaining;

public class MatrixUtil {
	public static int minOperations(int arr[]) {
		//Number of matrices
		 int n = arr.length - 1; ;
         
         //t[i,j] denotes the minimum scalar multiplication needed to multiply {Ai,....Aj} where Ai is a matrix
         int t[][] = new int[n + 1] [n + 1];

         //Chain length from 2 to the number of matrices n
         for(int l = 2; l <= n; ++l)
         {
             for (int i = 1; i <= n - l + 1; ++i)
             {
                 int j = i + l - 1;
                 int minCost = Integer.MAX_VALUE;
                 for(int k = i; k < j; ++k)
                 {
                     int cost = t[i][k] + t[k + 1][j] + (arr[i - 1] * arr[k] * arr[j]);
                     if(cost < minCost)
                     {
                         minCost = cost;
                         t[i][j] = minCost;
                     }
                 }
             }
         }

         return t[1][n];
	}
}
