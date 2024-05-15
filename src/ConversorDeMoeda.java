import java.text.DecimalFormat;
import java.util.Scanner;

public class ConversorDeMoeda {
    public static void converterMoeda(String moedaEntrada, String moedaEscolha, Scanner scanner) {
        BuscandoApi buscandoApi = new BuscandoApi();
        double taxaDeCambio = buscandoApi.obterTaxaDeCambio(moedaEntrada, moedaEscolha);

        if (taxaDeCambio < 0) {
            // Se houver erro ao obter a taxa de câmbio, sair do método
            return;
        }

        System.out.print("Digite o valor em " + moedaEntrada + ": ");
        double valor = scanner.nextDouble();

        double valorConvertido = valor * taxaDeCambio;

        // Formatar os valores para exibição
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String valorFormatadoEntrada = getMoedaFormatada(valor, moedaEntrada);
        String valorFormatadoSaida = getMoedaFormatada(valorConvertido, moedaEscolha);

        // Exibir o resultado da conversão
        System.out.println("-------------------Resultado------------------");
        System.out.println(valorFormatadoEntrada + " é igual a " + valorFormatadoSaida);
        System.out.println("----------------------------------------------");
    }

    private static String getMoedaFormatada(double valor, String moeda) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        switch (moeda) {
            case "BRL":
                return "R$ " + df.format(valor);
            case "USD":
                return "$ " + df.format(valor);
            case "EUR":
                return "€ " + df.format(valor);
            case "COP":
                return "COP " + df.format(valor);
            default:
                return df.format(valor) + " " + moeda;
        }
    }
}
