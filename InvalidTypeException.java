public class InvalidTypeException extends Exception{
    public InvalidTypeException(String s) throws Exception {
        throw new Exception(s);
    }
}
