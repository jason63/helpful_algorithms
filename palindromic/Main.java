public class Main {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("abcds"));
    }
    /*******************暴力破解*********************/
    public static String longestPalindrome1(String s) {
        int changdu = 0;
        String longe = null;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int len = j - i;
//               注意在截取字串的时候好是包头不包尾
                String curr = s.substring(i, j+1);
                if (isRalindrome(curr)&& len > changdu) {
                    longe = curr;
                }
            }
        }
        return longe;
    }
    public static boolean isRalindrome(String s) {
        for (int i = 0; i < s.length() - 1; i++)
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        return true;
    }
    /********************************************/
    /*******************中心扩展*******************/
    public  static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        String longest = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
        }
        return longest;
    }

    // Given a center, either one letter or two letter,
    // Find longest palindrome
    public static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1
                && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        String subS = s.substring(begin + 1, end);
        return subS;
    }
    /************************************************************/
}
