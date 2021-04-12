import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Banco {

    private ArrayList<Correntista> listaDeCorrentistas;

    public Banco() {
        listaDeCorrentistas = new ArrayList<Correntista>();
    }

    public ArrayList<Correntista> getListaDeCorrentistas() {
        return listaDeCorrentistas;
    }

    public void setListaDeCorrentistas(ArrayList<Correntista> listaDeCorrentistas) {
        this.listaDeCorrentistas = listaDeCorrentistas;
    }

    public void salvaCorrentistas() throws IOException {
        File file = new File("database.dat");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        for(Correntista c : listaDeCorrentistas) {
            oos.writeObject(c);
        }
        oos.close();
    }

    public void lerCorrentistas() throws IOException, ClassNotFoundException {
        File file = new File("database.dat");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Object obj = null;
        try {
            while ((obj = ois.readObject()) != null) {
                this.listaDeCorrentistas.add((Correntista) obj);
            }
        }
         catch(EOFException e) {

        }
        finally {
            ois.close();
        }

    }

    public static void main(String args[]) {

        Banco banco = new Banco();

        ContaPessoaFisica conta = new ContaPessoaFisica();
        conta.deposito(1000);

        CorrentistaPessoaFisica Joy = new CorrentistaPessoaFisica("Joy", conta);
        CorrentistaPessoaFisica Pris = new CorrentistaPessoaFisica("Pris", conta);

        /*CorrentistaPessoaFisica correntista1 = new CorrentistaPessoaFisica("Pinti", new ContaPessoaFisica());
        banco.getListaDeCorrentistas().add(correntista1);

        CorrentistaPessoaFisica correntista2 = new CorrentistaPessoaFisica("Pudol", new ContaPessoaFisica());
        banco.getListaDeCorrentistas().add(correntista2);

        CorrentistaPessoaFisica correntista3 = new CorrentistaPessoaFisica("Princesa", new ContaPessoaFisica());
        banco.getListaDeCorrentistas().add(correntista3);

        CorrentistaJuridico correntistaJuridico = new CorrentistaJuridico("TecnoPinti", "Pinti", new ContaPessoaJuridica());
        banco.getListaDeCorrentistas().add(correntistaJuridico);*/

        /*try {
            banco.salvaCorrentistas();
        }
        catch (IOException e) {

        }

        try {
            banco.lerCorrentistas();

            for(Correntista c : banco.getListaDeCorrentistas()) {
                System.out.println(c.getNome());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } */

        ContaPessoaFisica.SaqueATM saqueJoy = new ContaPessoaFisica.SaqueATM(Joy.getConta(), 500);
        ContaPessoaFisica.SaqueATM saquePris = new ContaPessoaFisica.SaqueATM(Pris.getConta(), 300);

        saqueJoy.start();
        saquePris.start();
    }
}
