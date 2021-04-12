public class ContaPessoaFisica implements Conta {

    private double saldo = 0.0;
    private static final double jurosPessoaFisica = 0.03;

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

    @Override
    public double simulaEmprestimo(double capitalFinanciado, int numeroMeses) throws IllegalArgumentException {

        if(capitalFinanciado <= 0.0 || numeroMeses <= 0.0) {

            throw new IllegalArgumentException();
        }
        else {
            return jurosPessoaFisica / (1 - 1 / Math.pow(1 + jurosPessoaFisica, numeroMeses)) * capitalFinanciado;
        }
    }

    static class SaqueATM extends Thread {

        private Conta conta;
        private double saque;

        public SaqueATM(Conta conta, double saque) {
            this.conta = conta;
            this.saque = saque;
        }

        public void run() {
            conta.saque(saque);
        }
    }
}
