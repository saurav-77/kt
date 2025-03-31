package saurav

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

fun Array<Long>.lowerBound(num: Long): Int {
    assert(this.isNotEmpty())
    var ans = this.size;
    var lo = 0;
    var hi = this.size - 1;
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

fun Array<Long>.upperBound(num: Long): Int {
    assert(this.isNotEmpty())
    var ans = this.size;
    var lo = 0;
    var hi = this.size - 1;
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
