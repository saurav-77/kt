package saurav

import java.util.*
import java.util.stream.Stream

fun String.toStringBuilder(): StringBuilder = StringBuilder(this)

fun Long.toStringBuilder(): StringBuilder = StringBuilder(this.toString())

fun Array<Int>.toLongArray(): Array<Long> {
    var n = this.size
    var res = Array<Long>(this.size) { 0L }
    for (i in this.indices) {
        res[i] = this[i].toLong()
    }
    return res
}

fun IntArray.toLongArray(): Array<Long> {
    var n = this.size
    var res = Array<Long>(this.size) { 0L }
    for (i in this.indices) {
        res[i] = this[i].toLong()
    }
    return res
}

fun Array<Long>.lowerBound(num: Long, low: Int = 0, high: Int = this.size - 1): Int {
    assert(this.isNotEmpty())
    var ans = this.size;
    var lo = low;
    var hi = high
    while (lo <= hi) {
        val mid = lo + (hi - lo) / 2;
        if (this[mid] >= num) {
            ans = mid;
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return ans;
}

fun Array<Long>.upperBound(num: Long, low: Int = 0, high: Int = this.size - 1): Int {
    assert(this.isNotEmpty())
    var ans = this.size;
    var lo = low;
    var hi = high;
    while (lo <= hi) {
        val mid = lo + (hi - lo) / 2;
        if (this[mid] > num) {
            ans = mid;
            hi = mid - 1;
        } else {
            lo = mid + 1;
        }
    }
    return ans;
}

fun Array<Long>.stream(): Stream<Long> {
    return Arrays.stream(this)
}


