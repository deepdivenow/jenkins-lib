import java.math.BigInteger;

def call (String text, int mod){
    BigInteger bigInt = new BigInteger(text.getBytes());
    return mod(bigInt).intValue();
}