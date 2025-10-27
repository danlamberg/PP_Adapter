public class TwitterAdapter implements GerenciadorMidiaSocial {

    private TwitterAPI twitterApi;

    public TwitterAdapter(TwitterAPI twitterApi) {
        this.twitterApi = twitterApi;
    }

    @Override
    public RespostaAPI publicarConteudo(Conteudo conteudo) {
        TwitterAPI.TwitterPost twitterPost = new TwitterAPI.TwitterPost();
        twitterPost.tweetText = conteudo.getTexto() + " #UnifiedPost";
        twitterPost.mediaId = (conteudo.getMidia() != null) ? "TWT-MEDIA-" + conteudo.getMidia().length : null;

        String idPublicacaoTwitter = twitterApi.postTweet(twitterPost);
        if (idPublicacaoTwitter != null && idPublicacaoTwitter.startsWith("TWT-")) {
            return new RespostaAPI(true, idPublicacaoTwitter, "Tweet publicado com sucesso.");
        } else {
            return new RespostaAPI(false, null, "Erro ao publicar no Twitter.");
        }
    }

    @Override
    public Estatisticas obterEstatisticas(String idPublicacao) {
        System.out.println("[TwitterAdapter] Obtendo estatísticas para: " + idPublicacao);
        return new Estatisticas(100, 5, 12);
    }
}