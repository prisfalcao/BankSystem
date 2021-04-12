public class CorrentistaPessoaFisica extends Correntista{


    public CorrentistaPessoaFisica(String nome, Conta conta) {
        super(nome, conta);
    }

    public void exibeIdentificao() {
        System.out.println("Eu sou um correntista pessoa física: " + getCodigo() + " - " + getNome());
    }
}
