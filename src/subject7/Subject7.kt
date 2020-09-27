package subject7

import java.util.*

/**
 * 7. 整数反转
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 *      输入: 123
 *      输出: 321
 *
 * 示例 2:
 *
 *      输入: -123
 *      输出: "PINALSIGYAHRPI"
 *
 * 示例 3:
 *
 *      输入: 120
 *      输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
fun main() {
    println(reverse(4))
    println(reverse( -1))
    println(reverse( -123))
    println(reverse( 120))
    println(reverse( 2345))
    println(reverse( 2147447412))
    println(reverse( 2147447415))
}

fun reverse(x: Int): Int {
    val startTime = System.currentTimeMillis()
    println("start time = ${Date()} $startTime")
    val s = x.toString()
    val buffer = StringBuffer()
    when {
        x >= 10 -> for (i in s.indices) {
            buffer.insert(0, s[i])
        }
        x <= -10 -> {
            buffer.append('-')
            for (i in 1 until s.length) {
                buffer.insert(1, s[i])
            }
        }
        else -> return x
    }

    var long = buffer.toString().toLong()
    long =  if (long > Int.MAX_VALUE || long < Int.MIN_VALUE) {
        0
    } else {
        long
    }

    println("end time = ${Date()}, use time = ${System.currentTimeMillis() - startTime}")
    return long.toInt()
}

fun reverse2(x: Int): Int {
    val startTime = System.currentTimeMillis()
    println("start time = ${Date()} $startTime")

    var tempX = x
    var result = 0
    var digits = 0
    while (true) {
        if (tempX >= -9 && tempX <= 9) {
            val test = result
            result = result * 10 + tempX
            result = if (digits == 9 && result / 10 != test) {
                0
            } else {
                result
            }

            println("end time = ${Date()}, use time = ${System.currentTimeMillis() - startTime}")
            return result
        }
        result = result * 10 + tempX % 10
        digits += 1
        tempX /= 10
    }
}