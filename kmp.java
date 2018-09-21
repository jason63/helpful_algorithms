public class kmp {
    public static int[] getNext(String t){
        int[] next = new int[t.length()] ;
        int suffix = 0 ;
        int prefix = -1 ;
        next[0] = -1 ;
        while(suffix < t.length()-1){
            if( prefix == -1 || t.charAt(suffix) == t.charAt(prefix)){
                suffix++ ;
                prefix++ ;
                next[suffix] = prefix ;
            }
            else prefix = next[prefix] ;
        }
        return next ;
    }

    public static int KMP(String s, String t){
        int[] next = getNext(t) ;
        int i = 0 ;
        int j = 0 ;
        while( i< s.length() && j< t.length()){
            if( j== -1 || s.charAt(i) == t.charAt(j)){
                i++ ;
                j++ ;
            }
            else j = next[j] ;
        }
        return j==t.length() ? i-j : -1 ;
    }

    public static void main(String[] args){
        String s = "when will we have the chance to have a wonderful vacation?" ;
        String t = "ha" ;
        System.out.println(KMP(s, t ));
    }
}




//    public static int[] getNext(String t){
//        int[] next = new int[t.length()] ;  // to be return
//        int suffix = 0 ;                    //下标
//        int prefix = -1 ;                   //数组中的值
//        next[0] = -1 ;                      //初始一个
//        while( suffix < t.length()-1 ){     //还没越界
//            if(prefix == -1 || t.charAt(suffix)== t.charAt(prefix)){    //还开始后前后缀有相同
//                ++prefix ;                  //嘉嘉
//                ++suffix ;                  //佳佳
//                next[suffix] = prefix ;     //
//            }
//            else prefix = next[prefix] ;        //
//        }
//        return next ;
//    }
//    public static int KMP(String s, String t){
//        int[] next = getNext(t) ;                       //得到next
//        int i = 0 ;                                     //s下标
//        int j = 0 ;                                     //t下标
//        while( i< s.length() && j< t.length()){         //没越界
//            if( j== -1 || s.charAt(i)== t.charAt(j)){   //还开始或两数组相同
//                i++ ;                                   //嘉嘉
//                j++ ;                                   //佳佳
//            }
//            else j = next[j] ;                          //利用next[]
//        }
//        return j == t.length() ? i-j : -1 ;             //t到达结尾为成功，返回开头的下标
//    }