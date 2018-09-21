import java.util.Scanner;
//dp显示的，在下标大小的包里能装的最大价值
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int v = in.nextInt();
        int[] dp = new int[v + 1];
        int[] price = new int[n + 1];
        int[] weight = new int[n + 1];
        long max = 0;
        for (int i = 1; i < n + 1; i++) {
            weight[i] = in.nextInt();
            price[i] = in.nextInt();
        }
        for (int i = 1; i < n + 1; i++)
            for (int j = v; j > 0; j--)
                if (j - weight[i] >= 0) {                                       //如果过能装下此物
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + price[i]);      //
//                    System.out.println("point1:dp[j]="+dp[j]+", dp[j-weight[i]]-price[i]="+(dp[j - weight[i]] + price[i]));
                }
                else {
                    dp[j] = dp[j];
//                    System.out.println("point2:dp[j]="+dp[j]);
                }
        for (int i = 0; i < v + 1; i++)
            max = max > dp[i] ? max : dp[i];
        System.out.println(max);
        for(int i = 0; i< v+1;i++)System.out.print(dp[i]+",");
    }
}
//3 60  物品数 承重
//20 10 重量  价值
//30 15
//25 13

// 3 6
// 2 3
// 3 5
// 2 4