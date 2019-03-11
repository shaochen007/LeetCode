package subject5

import subject3.lengthOfLongestSubstring

/**
 * 6. 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
fun main(args: Array<String>) {
    println(longestPalindrome("PAYPALISHIRING"))
    println(longestPalindrome("gajgjsg"))
    println(longestPalindrome("woeglajsx"))
    println(longestPalindrome("babad"))
    println(longestPalindrome("cbbd"))
    println(longestPalindrome("bb"))
    println(longestPalindrome("bbb"))
    println(longestPalindrome("bbbb"))
    println(longestPalindrome("bbbbb"))
//    println(convert("A", 1))
}

fun longestPalindrome(s: String): String {
    if (s.isEmpty()) {
        return ""
    }

    if (s.length == 1) {
        return s
    }

    var start = 0
    var end = 0
    for ((index, value) in s.withIndex()) {
        // 相同字符长度
        var repLen = 1
        while (index + repLen < s.length && value == s[index + repLen]) {
            repLen ++
        }

        // 回文子串两边长
        var outLen = 0
        while (index - 1 - outLen >= 0 && index + repLen + outLen < s.length && s[index - 1 - outLen] == s[index + repLen + outLen]) {
            outLen ++
        }

        if (repLen + outLen + outLen > end - start) {
            start = index - outLen
            end = index + repLen + outLen
        }
    }

    return s.substring(start, end)
}