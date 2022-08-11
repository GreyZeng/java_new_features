package git.snippets.jdk7;

/**
 * @since 1.7
 */
public class BinaryTest {
    public static void main(String[] args) {
        // 0b是二进制的开头
        // 所以num表示7
        int num = 0b111;
        System.out.println(num);

        // 二进制0110转换成十进制是6
        num = 0B0110;
        System.out.println(num);

        // An 8-bit 'byte' value:
        byte aByte = (byte) 0b00100001;

// A 16-bit 'short' value:
        short aShort = (short) 0b1010000101000101;

// Some 32-bit 'int' values:
        int anInt1 = 0b10100001010001011010000101000101;
        int anInt2 = 0b101;
        int anInt3 = 0B101; // The B can be upper or lower case.

// A 64-bit 'long' value. Note the "L" suffix:
        long aLong = 0b1010000101000101101000010100010110100001010001011010000101000101L;

    }
}