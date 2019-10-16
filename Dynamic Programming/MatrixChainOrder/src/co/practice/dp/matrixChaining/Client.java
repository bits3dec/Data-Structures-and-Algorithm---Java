package co.practice.dp.matrixChaining;

public class Client {
	public static void main(String[] args) {
		int arr[] = new int[] {1, 2, 3, 4}; 
		
		int res = MatrixUtil.minOperations(arr);
		System.out.println(res);
	}
}
