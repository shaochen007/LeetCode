package 数组.转置矩阵867

/**
 * 867. 转置矩阵
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 *
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 *
 * 示例 2：
 *
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 */
fun main() {
    val start = System.currentTimeMillis()
    transpose(arrayOf(arrayOf(1,2,3).toIntArray(), arrayOf(4,5,6).toIntArray(), arrayOf(7,8,9).toIntArray()))
    transpose(arrayOf(arrayOf(1,2,3).toIntArray(), arrayOf(4,5,6).toIntArray()))
    println("cost time: ${System.currentTimeMillis() - start}ms")
}

fun transpose(A: Array<IntArray>): Array<IntArray> {
    val lenA = A.size
    val lenA0 = if (A.isEmpty()) 0 else A[0].size
    if ((A.isEmpty() || lenA > 1000) && (A[0].isEmpty() || lenA0 > 1000)) {
        return mutableListOf<IntArray>().toTypedArray()
    }
    val result = Array(lenA0) {
        IntArray(lenA)
    }

    A.forEachIndexed { i, ints ->
        ints.forEachIndexed { j, value ->
            result[j][i] = value
        }
    }

//    for (i in 0 until lenA) {
//        for (j in 0 until lenA0) {
//            result[j][i] = A[i][j]
//        }
//    }

    return result
}