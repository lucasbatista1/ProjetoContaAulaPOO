public class Conta {
    private String numConta;
    private String agencia;
    private double saldo;
    private String nomeCliente;

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public int sacar(double valor){
        if(valor<=saldo){
            saldo -= valor;
            return 1;
        }
        return 0;
    }
    public void depositar(double valor){
        saldo += valor;
    }

    //Métodos de negócios
    public boolean registrarDeposito(double qtdEntrada){
        if(qtdEntrada > 0){
            saldo += qtdEntrada;
            return true;
        }
        return false;
    }
    public boolean registrarSaque(double qtdSaida){
        if(qtdSaida <= saldo){
            saldo -= qtdSaida;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Dados da conta: " + numConta + "\n" +
                "Nome Cliente: " + nomeCliente + "\n" +
                "Agencia: " + agencia + "\n" +
                "Saldo: " + saldo + "\n";
    }
}
