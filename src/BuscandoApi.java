import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class BuscandoApi {

    public double obterTaxaDeCambio(String moedaEntrada, String moedaEscolha) {
        try {
            String chaveApi = "c92c5c20d08341ebaa5002bb";
            String urlAPI = "https://v6.exchangerate-api.com/v6/" + chaveApi + "/latest/" + moedaEntrada;

            URL url = new URL(urlAPI);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            int status = conexao.getResponseCode();
            if (status != 200) {
                System.out.println("Erro ao obter dados da API. Código de resposta: " + status);
                return -1; // Retorna um valor negativo para indicar erro
            }

            JsonParser parser = new JsonParser();
            JsonElement raiz = parser.parse(new InputStreamReader(conexao.getInputStream()));
            JsonObject objetoJson = raiz.getAsJsonObject();

            JsonObject taxasDeConversao = objetoJson.getAsJsonObject("conversion_rates");

            if (!taxasDeConversao.has(moedaEscolha)) {
                System.out.println("Moeda inválida.");
                return -1; // Retorna um valor negativo para indicar erro
            }

            return taxasDeConversao.get(moedaEscolha).getAsDouble();
        } catch (Exception e) {
            System.out.println("Erro ao obter dados da API: " + e.getMessage());
            return -1; // Retorna um valor negativo para indicar erro
        }
    }
}



