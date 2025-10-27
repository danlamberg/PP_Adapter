public interface GerenciadorMidiaSocial {
    RespostaAPI publicarConteudo(Conteudo conteudo);

    Estatisticas obterEstatisticas(String idPublicacao);
}