import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Início do programa");
        Calculadora calc = new Calculadora(30);

        Scanner entrada = new Scanner(System.in);
        boolean erro = false;

        do {
            
            try {
                System.out.print("Informe o valor para dividir: ");
                String valorStr = entrada.nextLine();
                int valor = Integer.parseInt(valorStr);

                calc.dividir(valor);
                erro = false;
            }catch(Exception ex2) {
                System.out.println("Entrada inválida");
                ex2.printStackTrace();
                erro = true;
            }
            // }catch(ArithmeticException ex) {
            //     System.out.println("Não é possível dividir por zero");
            //     erro = true;
            // }catch(NumberFormatException ex2) {
            //     System.out.println("Infome somente digitos (números)");
            //     erro = true;
            // }
        }while(erro);


        System.out.println(calc.getMemoria());
        System.out.println("Fim do programa");
    }
    
}