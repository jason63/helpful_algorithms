//回溯法解N皇后问题
/*
 * 回溯法解N皇后问题
 * 使用一个一维数组表示皇后的位置
 * 其中数组的下标表示皇后所在的行
 * 数组元素的值表示皇后所在的列
 * 这样设计的棋盘，所有皇后必定不在同一行
 *
 * 假设前n-1行的皇后已经按照规则排列好
 * 那么可以使用回溯法逐个试出第n行皇后的合法位置
 * 所有皇后的初始位置都是第0列
 * 那么逐个尝试就是从0试到N-1
 * 如果达到N，仍未找到合法位置
 * 那么就置当前行的皇后的位置为初始位置0
 * 然后回退一行，且该行的皇后的位置加1，继续尝试
 * 如果目前处于第0行，还要再回退，说明此问题已再无解
 *
 * 如果当前行的皇后的位置还是在0到N-1的合法范围内
 * 那么首先要判断该行的皇后是否与前几行的皇后互相冲突
 * 如果冲突，该行的皇后的位置加1，继续尝试
 * 如果不冲突，判断下一行的皇后
 * 如果已经是最后一行，说明已经找到一个解，输出这个解
 * 然后最后一行的皇后的位置加1，继续尝试下一个解
 *
 *
 */
public class NQueen {
    private static final int N = 4;
    private int[] x = new int[N];
    int sum  = 0;

    void backTack(int n) {
        if(n == N) {
            for (int i = 0; i < N; ++i) {
                System.out.print("x["+i+"] = " +x[i]);
                String a =(i==N-1?";":",") ;
                System.out.print(a) ;
            }
            System.out.println();
            sum ++;
        }
        else {
            for (int i = 0; i < N; ++i) {
                x[n] = i;
                if(isPlace(n)) {//如果第n行可以放，继续看n + 1行;不能放就在前面一行+1s
                    backTack(n + 1);
                }
            }
        }
    }
    //    检查第n行的皇后与前n-1行的皇后是否有冲突
//    发生冲突的充分必要条件是：
//    a) 两皇后处于同一列，即a[i] == a[n]
//    b) 两皇后处于同一斜线，即|a[i] - a[n]| == |i - n| == n - i
    private boolean isPlace(int i) {
        for (int j = 0; j < i; j++) {
            if(Math.abs(i - j) == Math.abs(x[i] - x[j])  || x[i] == x[j])  {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueen queen = new NQueen();
        queen.backTack(0);
        System.out.println(queen.sum);
    }
}