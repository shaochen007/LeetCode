package subject6

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
    println(convert("PAYPALISHIRING", 4))
    println(convert("A", 1))
}

fun convert(s: String, numRows: Int): String {
    if (s.isEmpty() || numRows <= 1) {
        return s
    }

    val resultSb = StringBuilder()
    val len = s.length
    // 遍历字符串的步长（一个Z字形的子串长度）
    val step = 2 * (numRows - 1)
    // 以行数为循环条件，每次循环插入一行的字符
    for (row in 0 until numRows) {
        // 每一行都从头开始，以step的步长遍历整个字符串
        for (i in row until len step step) {
            // 第一行和最后一行
            resultSb.append(s[i])
            // 中间行，判断是否存在第二个字符。规律为：当前行第一个字符下标 - 2 * 行下标 + 步长
            if (row != 0 && row != numRows - 1 && i - 2 * row + step < len) {
                resultSb.append(s[i - 2 * row + step])
            }
        }
    }

    return resultSb.toString()
}