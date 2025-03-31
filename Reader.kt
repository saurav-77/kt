package saurav

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var br: BufferedReader = BufferedReader(InputStreamReader(System.`in`))
var st: StringTokenizer? = null

fun nextString(): String {
    while (st == null || !st!!.hasMoreElements()) {
        st = StringTokenizer(br.readLine())
    }
    return st!!.nextToken()
}

fun nextLong(): Long {
    return nextString().toLong()
}

fun nextDouble(): Double {
    return nextString().toDouble()
}


fun nextLongArray(len: Long): Array<Long> {
    val ans = Array<Long>(len.toInt()) { 0L }
    for (i in ans.indices) {
        ans[i] = nextLong()
    }
    return ans
}