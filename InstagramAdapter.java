public class InstagramAdapter implements GerenciadorMidiaSocial {
    private InstagramAPI instagramApi;

    public InstagramAdapter(InstagramAPI instagramApi) {
        this.instagramApi = instagramApi;
    }

    @Override
    public RespostaAPI publicarConteudo(Conteudo conteudo) {
        InstagramAPI.InstagramMedia instagramMedia = new InstagramAPI.InstagramMedia();
        instagramMedia.caption = conteudo.getTexto() + " #AgenciaUnified";
        instagramMedia.mediaBytes = (conteudo.getMidia() != null) ? "base64:" + conteudo.getMidia().length : "";

        int statusCode = instagramApi.uploadMedia(instagramMedia);

        if (statusCode == 201) {
            String idPublicacaoInsta = "INSTA-" + System.currentTimeMillis();
            return new RespostaAPI(true, idPublicacaoInsta, "Mídia publicada no Instagram.");
        } else {
            return new RespostaAPI(false, null, "Erro de upload no Instagram. Código: " + statusCode);
        }
    }

    @Override
    public Estatisticas obterEstatisticas(String idPublicacao) {
        System.out.println("[InstagramAdapter] Obtendo estatísticas para: " + idPublicacao);
        return new Estatisticas(500, 45, 8);
    }
}