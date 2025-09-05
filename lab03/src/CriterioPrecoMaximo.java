public class CriterioPrecoMaximo implements CriterioBusca{
    public boolean testar(Produto p, String valor) {
        if(p.getPreco() <= Double.parseDouble(valor)){
            return true;
        }
        else{
            return false;
        }
    }
}