public interface Tributavel{

    double getValorImposto();


}
public class CalculadorDeImposto{

    private double totalImposto;

    public void registra(Tributavel t){
        double valor = t.getValorImposto();
        this.totalImposto += valor;
    }

    public double getTotalImposto(){
        return totalImposto;
    }

}

public class ContaCorrente implements Tributavel{

    @Override
    public double getValorImposto(){
        return super.saldo * 0.01;
    }
}

public class SeguroDeVida implements Tributavel{

    @Override
    public double getValorImposto(){
        return 0;
    }
}

public class TesteTributaveis{

    public static void main(String[] args){
        ContaCorrente cc = new ContaCorrente(222, 333);
        cc.deposita(100.0);

        SeguroDeVida seguro = new SeguroDeVida();

        CalculadorDeImposto calc = new CalculadorDeImposto();

        calc.registra(cc);
        calc.registra(seguro);

        System.out.println(calc.getTotalImposto());
    }
}
