import java.math.BigInteger;

def call (String text, Int mod){
    BigInteger bigInt = new BigInteger(text.getBytes());
    return mod(bigInt);
}