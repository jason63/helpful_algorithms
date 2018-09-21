import org.omg.CORBA.SystemException;

import java.util.Scanner;
//这里没有要求是连续的
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String aStr = in.nextLine();
        String bStr = in.nextLine();
        int aLen = aStr.length();
        int bLen = bStr.length();
        int[][] dp = new int[aLen + 1][bLen + 1];
        for (int i = 1; i < aLen + 1; i++)//aLen+1
            for (int j = 1; j < bLen + 1; j++)//bLen+1
                if (dp[i - 1][j] == dp[i][j - 1]                    //属于同一阶段，有相同历史
                        && aStr.charAt(i - 1) == bStr.charAt(j - 1) //取一个与一群对比
                        && dp[i - 1][j] == dp[i - 1][j - 1])        //  ？
                    dp[i][j] = dp[i - 1][j] + 1;//+1
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        int max = dp[aLen][bLen];
        StringBuilder sb = new StringBuilder();

        //计算偷偷用的矩阵
        for(int i = 0; i<aLen+1;i++){
            for (int j= 0; j<bLen+1;j++){
                System.out.print(dp[i][j]+" ") ;
            }
            System.out.print("\n") ;}

        while (max > 0) {
            if (dp[aLen - 1][bLen] == dp[aLen][bLen - 1] && dp[aLen - 1][bLen] + 1 == dp[aLen][bLen]) {
                sb.append(aStr.charAt(aLen - 1));
                max--;
                aLen--;
                bLen--;
            } else {
                if (dp[aLen][bLen - 1] == dp[aLen][bLen])
                    bLen--;
                else
                    aLen--;
            }
        }


        System.out.println(sb.reverse().toString());

    }

}
//        最长公共子序列Lcs
//        给出两个字符串A B，求A与B的最长公共子序列（子序列不要求是连续的）。
//        比如两个串为：
//
//        abcicba
//        zabdkscab
//
//        ab是两个串的子序列，abc也是，abca也是，其中abca是这两个字符串最长的子序列。