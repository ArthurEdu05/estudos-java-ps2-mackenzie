public class AssentoExecutiva extends Assento{

    public AssentoExecutiva(String classe, double precoBase){
        super(classe, precoBase);
    }

    public double calcularPrecoFinal(){
        double precoFinal = getPrecoBase() + (getPrecoBase() * 0.3);
        return precoFinal;
    }
}