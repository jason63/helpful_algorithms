import java.util.*

fun merge(a:Array<Int>, low:Int, mid:Int, high:Int){
    var temp = IntArray(high-low+1)
    var i = low
    var j = mid+1
    var k = 0
    while( i<= mid && j<= high) temp[k++] = if(a[i]<a[j]) a[i++] else a[j++]
    while( i<= mid ) temp[k++] = a[i++]
    while( j<= high) temp[k++] = a[j++]
    for(k2 in temp.indices) a[low+k2] = temp[k2]
}
fun mergeSort(a:Array<Int>, low:Int, high:Int){
    var mid = (high+low)/2
    if(low< high){
        mergeSort(a,low, mid)
        mergeSort(a,mid+1,high)
        merge(a, low, mid, high)
    }
}

fun main(args:Array<String>){
    var a = arrayOf(51, 46, 20, 18, 7, 65, 97, 82, 30, 77, 50)
    mergeSort(a, 0, a.size-1)
    println("排序结果：${Arrays.toString(a)}")
}
