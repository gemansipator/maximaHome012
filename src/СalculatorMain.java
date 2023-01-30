import java.util.Scanner;

public class СalculatorMain {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc(num1,num2,operation);
        if (result == 0){
            System.out.println();
        }else {
            System.out.println("Результат операции: "+ result);
        }

    }

    public static int getInt(){
        System.out.println("Введите число:");
        int num;
        if(scanner.hasNextInt()){   //Метод hasNextInt проверяет, что следующая последовательность символов является
            // int-ом и в этом случае возвращает true , иначе false
            num = scanner.nextInt();
        } else {

            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getInt();
        }
        return num;

    }

    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }

    public static int calc(int num1, int num2, char operation){
        int result = 0;
        try {
            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                            result = num1 / num2;
                    break;
                default:
                    System.out.println("Операция не распознана. Повторите ввод.");
                    result = calc(num1, num2, getOperation());//рекурсия
            }
            return result;

        } catch (ArithmeticException ex) {
            throw new MyArithmeticException(ex);

        }

    }
}
/*
Ответ учителя:
... [30.01.2023 23:36]
Ну в данном контексте конечно нет смысла кидать ошибку дальше. Лучше просто вывести об этом сообщение в консоль и программу завершить

//(как я понял в данном случае рекомендация:
//
//        } catch (ArithmeticException ex) {
//            System.out.println("На ноль делить нельзя!!!");
//
//        }
//
//        return result;
//    }
//    то есть без своих исключений)

...[30.01.2023 23:36]
Но в целом, если ты не покинешь ошибку, то программа не остановится :)

... [30.01.2023 23:36]
Она пойдёт дальше блока try

... [30.01.2023 23:37]
Так что . для практики. Ошибку отловил. Свою обернул. Смысл понял и прекрасно
 */

