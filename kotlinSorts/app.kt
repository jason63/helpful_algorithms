fun getNext(t: String):IntArray{
    var next = IntArray(t.length,{0})
    var suffix: Int = 0
    var prefix: Int = -1
    next[0] = -1
    while( suffix < t.length-1){
        if( prefix == -1 || t[suffix] == t[prefix]){
            suffix++
            prefix++
            next[suffix] = prefix
        }
        else prefix = next[prefix]
    }
    return next
}

fun KMP(s:String, t:String):Int{
    var next:IntArray = getNext(t)
    var i:Int = 0
    var j:Int = 0
    while(i< s.length && j< t.length){
        if( j== -1 || s[i] == t[j]){
            i++
            j++
        }
        else j = next[j]
    }
    return if(j== t.length) i-j else -1
}

fun main(args: Array<String>){
    var s:String =  "when will we have the chance to have a wonderful vacation?"
    var t:String =  "ha"
    println(KMP(s,t))

}