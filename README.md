# AULA

 📷 NASA IMAGE DOWNLOADER – Projeto Java com API

 Este programa realiza uma requisição HTTP para a API pública da NASA (APOD – Astronomy Picture of the Day),
 obtém os dados em formato JSON, extrai automaticamente a URL da imagem astronômica do dia
 e baixa essa imagem, salvando no computador do usuário com o nome 'nasa_image.jpg'.

 🌐 A API utilizada retorna informações diárias sobre o universo, e inclui campos como:
 - data, explicação, título, tipo de mídia (imagem ou vídeo), e a URL da mídia.

 Para a realização desse codigo usei o código fornecido pelo professor em aula que esta disponivel no seguinte repositório (https://github.com/AlexandreAlvesUnipam/JavaApp.git) lá possui todas as informações iniciais.

 ⚠️ IMPORTANTE:
 - Em aplicações reais, a chave da API (apiKey) deve ser protegida e não deixada visível no código.
 - Aqui, como é apenas um exemplo didático, utilizamos a chave pública gratuita: "DEMO_KEY".

 ✅ REQUISITOS:
 - Java 11 ou superior instalado.
 - Apache Maven (gerenciador de dependências e build do projeto) também instalado.
 (Maven é pago)


 ▶️ COMO EXECUTAR O PROJETO:
 1. Abra o terminal (ou prompt de comando).
 2. Navegue até a pasta onde está seu projeto com o comando:
      cd nomedapasta/
 3. Compile o projeto com Maven:
      mvn compile
 4. Execute o projeto com:
      mvn exec:java

 ✔️ Se tudo estiver correto, você verá no terminal a URL da imagem do dia,
    e a imagem será salva na mesma pasta com o nome: nasa_image.jpg.

 🚀 Espero que de certo!
 