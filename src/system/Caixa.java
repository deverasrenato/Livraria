package system;


public class Caixa {
    private static Double valorEmCaixa = 0.0;

    public static Double getValorEmCaixa() {
        return valorEmCaixa;
    }

    public static void adicionarDinheiro(Double quantia){

        valorEmCaixa += quantia;
        System.out.println("Dinheiro adicionado ao caixa");
    }

    public static void retirarDinheiro (Double quantia){
        if (valorEmCaixa - quantia < 0){
            System.out.println("Saldo insuficiente");
        } else {
            valorEmCaixa -= quantia;
            System.out.println("Dinheiro retirado do caixa!");
        }
    }
    public static void mostrarCaixa(){
        System.out.printf("Valor em caixa: $%.2f\n", valorEmCaixa);
    }
}
