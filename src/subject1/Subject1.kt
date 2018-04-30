package subject1

/**
 * 1. 两数之和
 *
 * 给定一个整数数列，找出其中和为特定值的那两个数。
 * 你可以假设每个输入都只会有一种答案，同样的元素不能被重用。
 *
 * 示例:
 *     给定 nums = [2, 7, 11, 15], target = 9
 *     因为 nums[0] + nums[1] = 2 + 7 = 9
 *     所以返回 [0, 1]
 */
fun main(args: Array<String>) {
    twoSum(intArrayOf(3,2,4), 6).forEach {
        println(it)
    }

    Subject1().twoSum(intArrayOf(3,2,4), 6).forEach {
        println(it)
    }
    Subject1().twoSum(intArrayOf(2,7,11,15), 16).forEach {
        println(it)
    }


}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    // 将数组转化成map<value, index>
    nums.forEachIndexed { index, i ->
        map.put(i, index)
    }

    nums.forEachIndexed { index, i ->
        val numOther = target - i

        if (map.containsKey(numOther) && map[numOther] != index) {
            return intArrayOf(index, map[numOther] ?: -1)
        }
    }

    return IntArray(2)
}

