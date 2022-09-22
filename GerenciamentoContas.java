import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoContas {
    private List<Conta> contas = new ArrayList<>();
    public Conta cc = new Conta();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciamentoContas teste = new GerenciamentoContas();
        int opc = 0;
        do{
            opc = getMenu(sc, teste);
        }while(opc!=9);
    }

    private static int getMenu(Scanner sc, GerenciamentoContas teste) {
        int opc;
        System.out.println("Menu Principal");
        System.out.println("1. Cadastrar nova conta");
        System.out.println("2. Sacar");
        System.out.println("3. Depositar");
        System.out.println("4. Consultar Contas");
        System.out.println("5. Apresentar Patrimonio do Banco ");
        System.out.println("9. Sair");
        System.out.println("Digite sua opcao: ");
        opc = Integer.parseInt(sc.nextLine());
        switch (opc){
            case 1:
                teste.execCadastrar(sc);
                break;
            case 2:
                teste.execSacar(sc);
                break;
            case  3:
                teste.execDepositar(sc);
                break;
            case 4:
                teste.execConsultar(sc);
                break;
            case 5:
                break;
            case 9:
                System.out.println("FIM");
                break;
            default:
                System.out.println("Opcao invalida");
        }
        return opc;
    }
    public void execCadastrar(Scanner sc){
        Conta conta = new Conta();
        System.out.println("Digite o numero da conta");
        conta.setNumConta(sc.nextLine());
        System.out.println("Digite o nome do cliente");
        conta.setNomeCliente(sc.nextLine());
        System.out.println("Digite a agencia");
        conta.setAgencia(sc.nextLine());

        System.out.println("Conta cadastrada com sucesso");
        contas.add(conta);
    }

    public void execConsultar(Scanner sc){
        for (Conta c : contas){
            System.out.println(c.toString());
        }
    }
    public void execSacar(Scanner sc){
        double valor;
        System.out.println("Digite o valor do saque");
        valor = Double.parseDouble(sc.nextLine());
        int ok = cc.sacar(valor);
        if(ok==1){
            System.out.println("Saque efetuado com sucesso");
        }else{
            System.out.println("Sem saldo suficiente");
        }
    }
    public void execDepositar(Scanner sc){
        System.out.println("Digite o numero da conta: ");
        String codigo = (sc.nextLine());
        //varrer a lista a procura da conta
        Conta contaEncontrada = null;
        contaEncontrada = procurarNaLista(codigo);
        if (contaEncontrada != null) {
            System.out.println("Digite o valor para deposito: ");
            double entrada = Double.parseDouble(sc.nextLine());
            contaEncontrada.setSaldo(entrada);
            boolean ok = contaEncontrada.registrarDeposito(entrada);
            if (ok) {
                System.out.println("Deposito efetuado com sucesso");
            } else {
                System.out.println("Valor invalido para deposito");
            }
            return;
        } else {
            System.out.println("Conta nao encontrada ");
        }
    }
    private Conta procurarNaLista(String codigo) {
        for (Conta c : contas) {
            if (codigo == c.getNumConta()) return c;
        }
        return null;
    }

}