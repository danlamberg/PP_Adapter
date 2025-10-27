public class RespostaAPI {
    private boolean sucesso;
    private String idPublicacao;
    private String mensagem;

    public RespostaAPI(boolean sucesso, String idPublicacao, String mensagem) {
        this.sucesso = sucesso;
        this.idPublicacao = idPublicacao;
        this.mensagem = mensagem;
    }

    public boolean isSucesso() {
        return sucesso;
    }

    public String getIdPublicacao() {
        return idPublicacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public String toString() {
        return "RespostaAPI{" + "sucesso=" + sucesso +
                ", idPublicaco=" + idPublicacao + "\'" +
                ", mensagem=" + mensagem + "\"" + "}";
    }

}
