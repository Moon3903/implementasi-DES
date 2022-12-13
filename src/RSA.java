import java.math.*;
import java.util.*;
 
class RSA {
    private int d;
    private int e;
    private final int n;
    RSA()
    {
        int p, q, z, i;
        d = 0;
 
        // 1st prime number p
        p = 7;
 
        // 2nd prime number q
        q = 17;
        n = p * q;
        z = (p - 1) * (q - 1);
        System.out.println("the value of z = " + z);
 
        for (e = 2; e < z; e++) {
 
            // e is for public key exponent
            if (gcd(e, z) == 1) {
                break;
            }
        }
        System.out.println("the value of e = " + e);
        for (i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
 
            // d is for private key exponent
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        System.out.println("the value of d = " + d);
    }

    public String encryptString (String msg) {
        String result = "";
        for(int i = 0; i < msg.length(); i++){
            result+=encrypt(msg.charAt(i));
        }
        System.out.println("ENC "+ result);
        return result;
    }

    public StringBuilder decryptString (StringBuilder msg) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < msg.length(); i++){
            result.append(decrypt(msg.charAt(i)));
        }
        System.out.println("DEC "+ result);
        return result;
    }

    public char encrypt (char msg) {
        double c = ((Math.pow(msg, e)) % n);
        char result = (char)c;
        return result;
    }

    public char decrypt (char c) {
        // converting int value of n to BigInteger
        BigInteger N = BigInteger.valueOf(n);

        // converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        char msgback = (char)((C.pow(d)).mod(N)).intValue();
        return msgback;
    }
 
    static int gcd(int e, int z)
    {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }
}