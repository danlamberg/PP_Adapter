public class Cliente {

    public static void main(String[] args) {

        // Conteúdo Unificado a ser publicado
        byte[] imagemSimulada = new byte[1024];
        Conteudo postDoDia = new Conteudo("Confira nosso novo produto!", imagemSimulada);

        System.out.println("--- Iniciando Publicação Unificada ---");

        // 1. Criação das APIs (Adaptees)
        TwitterAPI twitterApi = new TwitterAPI();
        InstagramAPI instagramApi = new InstagramAPI();

        // 2. Criação dos Adapters (injetando as APIs)
        GerenciadorMidiaSocial twitterManager = new TwitterAdapter(twitterApi);
        GerenciadorMidiaSocial instagramManager = new InstagramAdapter(instagramApi);

        // 3. O Cliente usa a interface unificada

        // Teste no Twitter
        System.out.println("\nPublicando no Twitter...");
        RespostaAPI respostaTwitter = twitterManager.publicarConteudo(postDoDia);
        System.out.println("Resposta Unificada: " + respostaTwitter);

        if (respostaTwitter.isSucesso()) {
            Estatisticas stats = twitterManager.obterEstatisticas(respostaTwitter.getIdPublicacao());
            System.out.println("Estatísticas: " + stats);
        }

        // Teste no Instagram
        System.out.println("\nPublicando no Instagram...");
        RespostaAPI respostaInstagram = instagramManager.publicarConteudo(postDoDia);
        System.out.println("Resposta Unificada: " + respostaInstagram);

        if (respostaInstagram.isSucesso()) {
            Estatisticas stats = instagramManager.obterEstatisticas(respostaInstagram.getIdPublicacao());
            System.out.println("Estatísticas: " + stats);
        }

        System.out.println("\n--- Fim da Publicação Unificada ---");
    }
}