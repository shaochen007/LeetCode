package 数组.数组异或操作

/**
 * 1486. 数组异或操作
 *给你两个整数，n 和 start 。
 *
 *数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 *
 *请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 *
 *
 *
 *示例 1：
 *
 *输入：n = 5, start = 0
 *输出：8
 *解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 *"^" 为按位异或 XOR 运算符。
 *示例 2：
 *
 *输入：n = 4, start = 3
 *输出：8
 *解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 *示例 3：
 *
 *输入：n = 1, start = 7
 *输出：7
 *示例 4：
 *
 *输入：n = 10, start = 5
 *输出：2
 *
 *
 *提示：
 *
 *1 <= n <= 1000
 *0 <= start <= 1000
 *n == nums.length
 */
fun main() {
    println("fun1 for n = 5, start = 0, result = ${xorOperation1(5, 0)}")
    println("fun1 for n = 4, start = 3, result = ${xorOperation1(4, 3)}")
    println("fun1 for n = 1, start = 7, result = ${xorOperation1(1, 7)}")
    println("fun1 for n = 10, start = 5, result = ${xorOperation1(10, 5)}")
}

/**
 * 方法1：暴力解法，循环异或
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
fun xorOperation1(n: Int, start: Int): Int {
    var result = start
    for (i in 1 until n) {
        result = result xor (start + 2 * i)
    }

    return result
}

/**
 * 方法1：利用异或操作特性【2x^(2x+1)=1】，详细见 [题解.md]
 * 时间复杂度：O(1)
 * 空间复杂度：O(1)
 */
fun xorOperation2(n: Int, start: Int): Int {
    var result = start
    for (i in 1 until n) {
        result = result xor (start + 2 * i)
    }

    return result
}