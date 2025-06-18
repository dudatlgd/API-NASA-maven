package com.batata;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) {
        String apiKey = "DEMO_KEY"; // chave gratis colocada do jeito errado! normalmente se esconde a chave em variaveis de ambiente ou arquivos de configuração
        String url = "https://api.nasa.gov/planetary/apod?api_key=" + apiKey;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            // 1️⃣ Faz a requisição para a API da NASA
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            // 2️⃣ Converte o JSON em objeto
            JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

            // 3️⃣ Pega a URL da imagem (pelo site da nasa ent eu n escolho é automatica)
            String imageUrl = jsonObject.get("url").getAsString();
            System.out.println("\n URL da imagem: " + imageUrl);

            // 4️⃣ Faz o download da imagem
            InputStream inputStream = new URL(imageUrl).openStream();

            // 5️⃣ Cria o arquivo onde a imagem será salva
            FileOutputStream outputStream = new FileOutputStream("nasa_image.jpg");

            // 6️⃣ Lê os dados da internet (site da nasa) e escreve no arquivo
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // close itens 
            inputStream.close();
            outputStream.close();

            System.out.println("\n Imagem baixada com sucesso como 'nasa_image.jpg' \n ");

        } catch (IOException e) {
            System.out.println("❌ Erro de I/O: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(" Requisição interrompida: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" Erro não identificado... socorro " + e.getMessage());
        }
    }
}
// Esse código faz uma requisição para a API da Nasa, obtem a URL da imagem do dia e baixa ela e mostra para o usuario 
//Aplicacoes reais devem esconder a chave da API mas como aqui é so um exemplo eu deixei ela visivel
//Para rodar esse exemplo, é necessario ter o Java 11 ou um superior instalado!!
//para compilar e rodar o exemplo ultilize os seguintes comandos: 
//entra na sua pasta (cd nomedaPasta/) q esta o arquivo e rode no terminal: mvn compile e depois mvn exec:java 
// ESPERO QUE DE CERTO!