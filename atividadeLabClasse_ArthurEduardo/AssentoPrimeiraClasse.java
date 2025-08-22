public class AssentoPrimeiraClasse extends Assento{
    public AssentoPrimeiraClasse(String classe, double precoBase){
        super(classe, precoBase);
    }

    public double calcularPrecoFinal(){
        double precoFinal = getPrecoBase() + (getPrecoBase() * 0.5);
        return precoFinal;
    }
}