import java.io.Serializable;

public abstract class Correntista implements Serializable {

    private static int proximoCodigo = 1;
    private Conta conta;
    private int codigo;
    private String nome;

    public Correntista(String nome, Conta conta) {
        codigo = getProximoCodigo();
        this.nome = nome;
        this.conta = conta;
    }

    public abstract void exibeIdentificao();

    public static int getProximoCodigo() {
        return proximoCodigo++;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
