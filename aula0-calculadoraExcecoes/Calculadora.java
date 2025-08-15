import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Calculadora {
    private int memoria;

    public Calculadora() {
        this.memoria = 0;
    }

    public Calculadora(int memoria) {
        this.memoria = memoria;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public void soma(int valor) {
        this.memoria += valor;
        // this.memoria = this.memoria + valor;
    }

    public void dividir(int valor) throws CalculadoraException {
        if(valor <= 0) {
            throw new CalculadoraException();
        }
        
        this.memoria /= valor;  
    }
}
