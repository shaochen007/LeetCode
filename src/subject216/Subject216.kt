package subject216

/**
 * 216. 组合总和 III
 *
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 *
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 *
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
fun main() {
    val startTime37 = System.currentTimeMillis()
    println(combinationSum3(3, 7).toString())
    println("3,7 end with ${System.currentTimeMillis() - startTime37}ms")
}

fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    if (k < 2 || k > 9 || n < 3 || n > 45 || n < (1 + k) * k / 2) {
        return mutableListOf()
    }

    val result = mutableListOf<List<Int>>()
    dfs(result, mutableListOf<Int>(), 1, k, n)

    return result
}

/**
 * 递归方法
 *
 * @param result 最终结果集
 * @param tempList 单个符合条件的结果集
 * @param start 该层递归循环开始数值
 * @param k 题目中的K
 * @param sv 计算到该层递归时剩余值
 */
fun dfs(result: MutableList<List<Int>>, tempList: MutableList<Int>, start: Int, k: Int, sv: Int) {
    if (tempList.size == k && sv == 0) {
        result.add(ArrayList(tempList))
        return
    }

    for (i in start..9) {
        if (i <= sv) {
            tempList.add(i)
            dfs(result, tempList, i + 1, k, sv - i)
            tempList.remove(i)
        } else {
            break
        }
    }
}