public class ContaPessoaJuridica implements Conta {

    private double saldo = 0.0;
    public static final double jurosPessoaJuridica = 0.05;

    @Override
    public void extrato() {
        System.out.println("Saldo da conta: " + saldo);
    }

    @Override
    public synchronized void deposito(double valor) {
        saldo += valor;
        System.out.println("Valor depositado: " + valor);
    }

    @Override
    public synchronized void saque(double valor) {
        saldo -= valor;
        if(valor <= saldo) {
            System.out.println("Valor sacado: " + valor);
        }
        else {
            System.out.println("Saldo insuficiente");
        }

    }

    public double simulaEmprestimo(double capitalFinanciado, int numeroMeses) throws IllegalArgumentException {

        if(capitalFinanciado <= 0.0 || numeroMeses <= 0.0) {

            throw new IllegalArgumentException();
        }
        else {
            return jurosPessoaJuridica/(1-1/Math.pow(1+jurosPessoaJuridica, numeroMeses))* capitalFinanciado;
        }
    }
}
