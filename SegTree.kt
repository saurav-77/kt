var given = IntArray(3) { 0 };
var tree = IntArray(4 * given.size);
var n = given.size;
fun build(ind: Int, l: Int, r: Int) {
    if (l == r) {
        tree[ind] = given[l];
        return;
    }
    var mid = l + (r - l) / 2;
    build(2 * ind + 1, l, mid);
    build(2 * ind + 2, mid + 1, r);
    tree[ind] = maxOf(tree[2 * ind + 1], tree[2 * ind + 2]);
}
fun update(ind: Int, l: Int, r: Int, tind: Int, tv: Int) {
    if (l == r && l == tind) {
        tree[ind] = tv;
        return;
    }
    var mid = l + (r - l) / 2;
    if (tind <= mid) {
        update(2 * ind + 1, l, mid, tind, tv);
    } else {
        update(2 * ind + 2, mid + 1, r, tind, tv);
    }
    tree[ind] = maxOf(tree[2 * ind + 1], tree[2 * ind + 2]);
}

fun update(tind: Int, tv: Int) {
    update(0, 0, n - 1, tind, tv);
}

fun get(ind: Int, l: Int, r: Int, ql: Int, qr: Int): Int {
    if (r < ql || l > qr) {
        return Int.MIN_VALUE;
    }
    if (l >= ql && r <= qr) {
        return tree[ind];
    }
    var mid = l + (r - l) / 2;
    var lhs = get(2 * ind + 1, l, mid, ql, qr);
    var rhs = get(2 * ind + 2, mid + 1, r, ql, qr);
    return maxOf(lhs, rhs);
}

fun get(ql: Int, qr: Int): Int {
    return get(0, 0, n - 1, ql, qr);
}