package subject3

import subject1.Subject1
import subject1.twoSum
import kotlin.math.max

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。

 * 示例：
 *     给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 *     给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 *     给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 */
fun main(args: Array<String>) {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("pwwkew"))
    println(lengthOfLongestSubstring("adgaljsglajbagjowe"))
    println(lengthOfLongestSubstring("oeglaaorugannvjah"))
    println(lengthOfLongestSubstring("hbaoelwlg"))
}

fun lengthOfLongestSubstring(s: String): Int {
    var result = 0
    // 记录不含有重复字符的子串
    var tempStr = StringBuilder()

    s.forEach {
        val containsIndex = tempStr.indexOf(it)

        // 如果字符在tempStr存在，则将改字符及其之前的字符从tempStr中删除
        if (containsIndex >= 0) {
            // 记录新的子串之前，记录最长子串的长度
            result = Math.max(result, tempStr.length)
            tempStr = tempStr.removeRange(0, containsIndex + 1) as StringBuilder
        }

        tempStr.append(it)
    }

    return Math.max(result, tempStr.length)
}