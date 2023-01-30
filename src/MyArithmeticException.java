public class MyArithmeticException extends ArithmeticException{
    public MyArithmeticException(ArithmeticException e) {
        super("Произошла ошибка "
        + e.getClass() + "-> " + e.getMessage());
    }
}
