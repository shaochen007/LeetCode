package subject5

import subject3.lengthOfLongestSubstring

/**
 * 6. Z字形变换
 *
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：
 *     P   A   H   N
 *     A P L S I I G
 *     Y   I   R
 * 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"
 *
 * 实现一个将字符串进行指定行数变换的函数:
 *
 * string convert(string s, int numRows);
 *
 * 示例 1:
 *
 *      输入: s = "PAYPALISHIRING", numRows = 3
 *      输出: "PAHNAPLSIIGYIR"
 *
 * 示例 2:
 *
 *      输入: s = "PAYPALISHIRING", numRows = 4
 *      输出: "PINALSIGYAHRPI"
 *
 *      解释:
 *
 *          P     I    N
 *          A   L S  I G
 *          Y A   H R
 *          P     I
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

    var longestPalindrome = "${s[0]}"
    for ((index, value) in s.withIndex()) {
        val palindrome = StringBuffer().append(value)
        // 相同字符长度
        var repLen = 1
        while (index + repLen < s.length && value == s[index + repLen]) {
            palindrome.append(s[index + repLen])
            repLen ++
        }

        // 回文子串两边长
        var outLen = 0
        while (index - 1 - outLen >= 0 && index + repLen + outLen < s.length && s[index - 1 - outLen] == s[index + repLen + outLen]) {
            palindrome.insert(0, s[index - 1 - outLen])
            palindrome.append(s[index + repLen + outLen])
            outLen ++
        }

        longestPalindrome = if (longestPalindrome.length > palindrome.length) longestPalindrome else palindrome.toString()
    }

    return longestPalindrome
}