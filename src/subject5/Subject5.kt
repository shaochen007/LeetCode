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
        if (index == 0 && value == s[index + 1]) {
            longestPalindrome = "$value${s[index + 1]}"
            continue
        }

        if (index == 0 || index == s.length -1) {
            continue
        }

        val palindrome = StringBuffer()
        if (value == s[index - 1] && value == s[index + 1]) { // 回文中间为叠字——两边
            palindrome.append(s[index - 1]).append(value).append(s[index + 1])
            var subIndex = index - 2
            var count = 1
            val indexPost = subIndex + 2 * count + 2
            while (subIndex >= 0 && indexPost < s.length && s[subIndex] == s[indexPost]) {
                palindrome.insert(0, s[subIndex]).append(s[indexPost])
                subIndex--
                count++
            }
        } else if (value == s[index - 1]) { // 回文中间为叠字——左边
            palindrome.append(s[index - 1]).append(value)
            var subIndex = index - 2
            var count = 1
            val indexPost = subIndex + 2 * count + 1
            while (subIndex >= 0 && indexPost < s.length && s[subIndex] == s[indexPost]) {
                palindrome.insert(0, s[subIndex]).append(s[indexPost])
                subIndex--
                count++
            }
        }
        else if (value == s[index + 1]) { // 回文中间为叠字——右边
            palindrome.append(value).append(s[index + 1])
            var subIndex = index - 1
            var count = 1
            val indexPost = subIndex + 2 * count + 1
            while (subIndex >= 0 && indexPost < s.length && s[subIndex] == s[indexPost]) {
                palindrome.insert(0, s[subIndex]).append(s[indexPost])
                subIndex--
                count++
            }
        } else {
            palindrome.append(value)
            var subIndex = index - 1
            var count = 1
            val indexPost = subIndex + 2 * count
            while (subIndex >= 0 && indexPost < s.length && s[subIndex] == s[indexPost]) {
                palindrome.insert(0, s[subIndex]).append(s[indexPost])
                subIndex--
                count++
            }
        }
        longestPalindrome = if (longestPalindrome.length > palindrome.length) longestPalindrome else palindrome.toString()
    }

    return longestPalindrome
}