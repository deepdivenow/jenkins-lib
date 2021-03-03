import java.math.BigInteger;

def call (String text, int mod){
    BigInteger bigInt = new BigInteger(text.getBytes());
    return bigInt.mod(mod).intValue();
}