class App{
    public static void main (String[] args){
        Assento a1 = new AssentoEconomica("Economica", 50.0);
        System.out.println("Valor do assento: R$" + a1.calcularPrecoFinal() + " (Classe " + a1.getClasse() + ")");

        Assento a2 = new AssentoExecutiva("Executiva", 50.0);
        System.out.println("Valor do assento: R$" + a2.calcularPrecoFinal() + " (Classe " + a2.getClasse() + ")");

        Assento a3 = new AssentoPrimeiraClasse("Primeira Classe", 50.0);
        System.out.println("Valor do assento: R$" + a3.calcularPrecoFinal()+ " (" + a3.getClasse() + ")");
    
    }
}