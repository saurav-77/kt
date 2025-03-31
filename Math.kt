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

fun power(a: Long, b: Long): Long {
    var a = a;
    var b = b;
    var ans = 1L;
    while (b > 0) {
        if (b.and(1L) == 1L) {
            ans *= a;
        }
        a *= a;
        b = b.shr(1);
    }
    return ans;
}

fun modPower(a: Long, b: Long, mod: Long): Long {
    var a = a % mod;
    var b = b;
    var ans = 1L;
    while (b > 0) {
        if (b.and(1L) == 1L) {
            ans *= a;
            ans %= mod;
        }
        a *= a;
        a %= mod;
        b = b.shr(1);
    }
    return ans;
}