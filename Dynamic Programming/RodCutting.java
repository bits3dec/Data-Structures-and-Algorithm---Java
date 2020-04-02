import java.util.Arrays;

public class RodCutting {
    public static void main(String[] args) {
        int prices[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
        int rodLength = prices.length;
        int res = maxProfit(prices, rodLength);
        System.out.println(res);
    }

    static int maxProfit(int prices[], int length) {
        int n = length;
        //t[j] denotes the maximum profit we can get by cutting a rod of length "j"
        int t[] = new int[n+1];

        Arrays.fill(t, Integer.MIN_VALUE);
        t[0] = 0;

        for(int j = 1; j <= n; ++j) {
            for(int i = 1; i <= j; ++i) {
                int price = prices[i-1] + t[j-i];
                if(price > t[j]) {
                    t[j] = price;
                }
            }
        }
        return t[n];
    }
}