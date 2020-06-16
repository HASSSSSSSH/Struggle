package bitwiseOperation.bitwiseOperators;

public class And {

    public static void main(String[] args) {
        byte[] a = new byte[10];
        // 11111111 11111111 11111111 10000001, Java符号数位数扩展时, 为保证十进制数值不变, 按符号位扩展
        a[0] = -127;
        System.out.println(a[0]);
        // 按0扩展, 即高位补0, 保证8位字节二进制存储不变
        int c = a[0] & 0xff;
        System.out.println(c);
        int d = -127 & 0xff;
        System.out.println(d);
        // byte与int进行运算时, 高位补1
        int e = a[0] & 0xffffffff;
        System.out.println(e);
        int f = a[0] & 0xfffffff;
        System.out.println(f);
        // 高位补1是不改变十进制数值的
        int g = a[0] | 0xffffff00;
        System.out.println(g);
    }
}
