fun quicksort(arr:Array<Int>, _left:Int, _right:Int ){
    var left:Int = _left
    var right:Int  = _right
    var temp:Int = 0
    if(left <= right){
        temp = arr[left]
        while(left != right){
            while(left< right && arr[right]>= temp)
                right--
            arr[left] = arr[right]
            while(left< right && arr[left]<= temp)
                left++
            arr[right] = arr[left]
        }
        arr[right] = temp
        quicksort(arr, _left, left-1)
        quicksort(arr, right+1,_right)
    }
}

fun main(args:Array<String>){
    var arr= arrayOf(2, 4, 1, 5, 6, 66, 45)
    quicksort(arr, 0, arr.size-1)
    for(i:Int in arr) print("${i} ")
}