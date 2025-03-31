import kotlin.math.abs

fun lcm(a: Long, b: Long): Long {
    return (a / gcd(a, b)) * b
}

fun gcd(a: Long, b: Long): Long {
    var a = abs(a);
    var b = abs(b);
    if (a == 0L || b == 0L) {
        return a xor b
    }
    var r = a % b
    while (r != 0L) {
        a = b;
        b = r;
        r = a % b;
    }
    return b
}