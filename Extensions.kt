fun String.toStringBuilder(): StringBuilder = StringBuilder(this)

fun Array<Int>.toLongArray(): Array<Long> {
    var res = Array<Long>(this.size) { 0 };
    for (i in 0 until this.size) {
        res[i] = this[i].toLong()
    }
    return res;
}

fun IntArray.toLongArray(): LongArray {
    var n = this.size;
    var res = LongArray(n) { 0 };
    for (i in 0..n - 1) {
        res[i] = this[i].toLong()
    }
    return res;
}
