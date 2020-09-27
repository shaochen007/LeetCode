package 数组.好数对的数目

import com.sun.org.apache.xml.internal.security.Init

/**
 * 1512. 好数对的数目
 * 给你一个整数数组 nums 。
 *
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 *
 * 返回好数对的数目。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 * 示例 3：
 *
 * 输入：nums = [1,2,3]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
fun main() {
    println("[1,2,3,1,1,3]的好数对数目为：${numIdenticalPairs1(arrayOf(1,2,3,1,1,3).toIntArray())}")
    println("[1,2,3,1,1,3]的好数对数目为：${numIdenticalPairs2(arrayOf(1,2,3,1,1,3).toIntArray())}")
}

/**
 * 方法1：双重循环直接比对
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
fun numIdenticalPairs1(nums: IntArray): Int {
    var result: Int = 0
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] == nums[j]) {
                result ++
            }
        }
    }

    return result
}

/**
 * 方法2：使用Map存储数字重复数量，再计算有多少个数据对
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
fun numIdenticalPairs2(nums: IntArray): Int {
    var result: Int = 0
    val map = mutableMapOf<Int, Int>()
    nums.forEach { item ->
        // 当map中该项为null时，将其记为0；不为null时，说明出现重复，依次增加1即可
        map[item] = if (map[item] == null) 0 else map[item]!!.plus(1)
        // 当数值开始重复之后，没增加1个，好数对均增加（重复数数量 - 1）
        result += map[item] ?: 0
    }

    return result
}