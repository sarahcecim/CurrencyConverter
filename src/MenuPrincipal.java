import java.util.Scanner;

public class MenuPrincipal {
    public void exibir() {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Bem Vindo ao conversor de Moedas, Por favor escolha uma opção abaixo =]");
            System.out.println("(1) - Real Brasileiro (BRL) => Dólar (USD)");
            System.out.println("(2) - Dólar (USD) => Real Brasileiro (BRL)");
            System.out.println("(3) - Euro (EUR) => Dólar (USD)");
            System.out.println("(4) - Dólar (USD) => Euro (EUR)");
            System.out.println("(5) - Peso Colombiano (COP) => Dólar (USD)");
            System.out.println("(6) - Dólar (USD) => Peso Colombiano (COP)");
            System.out.println("(7) - Sair ");
            System.out.println("-----------------------------------------------------------------------");

            System.out.print("Escolha uma opção válida: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    ConversorDeMoeda.converterMoeda("BRL", "USD", scanner);
                    break;
                case 2:
                    ConversorDeMoeda.converterMoeda("USD", "BRL", scanner);
                    break;
                case 3:
                    ConversorDeMoeda.converterMoeda("EUR", "USD", scanner);
                    break;
                case 4:
                    ConversorDeMoeda.converterMoeda("USD", "EUR", scanner);
                    break;
                case 5:
                    ConversorDeMoeda.converterMoeda("COP", "USD", scanner);
                    break;
                case 6:
                    ConversorDeMoeda.converterMoeda("USD", "COP", scanner);
                    break;
                case 7:
                    System.out.println("Fechando o aplicativo");
                    break;
                default:
                    System.out.println("-----------------------------------------------------------------------");
                    System.out.println("Opção inválida.");
                    System.out.println("-----------------------------------------------------------------------");
            }

            // Agora, após cada operação, aguardamos a entrada do usuário para continuar
            if (escolha != 7) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine(); // Limpar o caractere de nova linha deixado pelo nextInt
                scanner.nextLine(); // Aguardar o usuário pressionar Enter
            }
        } while (escolha != 7);

        scanner.close();
        System.exit(0);
    }
}
