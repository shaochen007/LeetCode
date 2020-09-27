package 数组.一维数组的动态和1480

/**
 * 1480. 一维数组的动态和
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 *
 * 请返回 nums 的动态和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 *
 * 示例 2：
 *
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 *
 * 示例 3：
 *
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 */
fun main() {
    runningSum(arrayOf(1,2,3,4).toIntArray())
}

fun runningSum(nums: IntArray): IntArray {
    val numSize = nums.size
    if (numSize < 2 || numSize > 1000) {
        return nums
    }

    return nums.apply {
        for (i in 1 until numSize) {
            // 当前值 = 前值 + 当前值，如此计算之后几位累加值
            this[i] = this[i - 1] + this[i]
        }
    }
}