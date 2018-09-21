import java.util.Scanner;

public class Main {
    public static void greedyGiveMoney(int money) {

        int[] moneyLevel = {1, 5, 10, 20, 50, 100};
        //从钱大的开始找
        for (int i = moneyLevel.length - 1; i >= 0; i--) {
            int num = money/ moneyLevel[i];
            int mod = money % moneyLevel[i];
            money = mod;
            if (num > 0) {
                System.out.println("需要" + num + "张" + moneyLevel[i] + "块的");
            }
        }
    }
    public static void main(String[] args){
        System.out.println("需要找零: ");
        Scanner in = new Scanner(System.in) ;
        int mon = in.nextInt() ;
        greedyGiveMoney(mon);
    }
}
