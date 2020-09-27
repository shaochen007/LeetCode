import kotlin.math.abs

fun main() {
    var array1 = intArrayOf(-1, 0, 1)
    println(size(array1))
    array1 = intArrayOf(9, 9, 9, 9, 5)
    println(size(array1))
    array1 = intArrayOf(9, 9, 4, 5, 4, 9, 8, 9, 8, 5)
    println(size(array1))
}

fun size(array: IntArray?): Int {
    if (array == null) {
        return 0
    }
    var length = array.size
    var j: Int
    for (i in 0 until length) {
        j = i + 1
        while (j < length) {
            if (abs(array[i]) == abs(array[j])) {
                array[j] = array[length - 1]
                length--
                continue
            }
            j++
        }
    }
    return length
}