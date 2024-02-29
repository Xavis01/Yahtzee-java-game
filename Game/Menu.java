package Yahtzee.Game;

public class Menu {

    public void menuPrincipal() {
        System.out.println("\n======= Menu =======" +
        "\n1) Jogar!" +
        "\n2) Cadastrar Jogadores" +
        "\n3) Gerenciar Jogadores" +
        "\n4) Ver Regras" +
        "\n0) Fechar Programa");
    }

    public void menuGerenciar() {
        System.out.println("\n======= Gerenciar Jogador =======" +
        "\n1) Alterar Nome" +
        "\n2) Apagar Jogador" +
        "\n3) Apagar Todos os Jogadores" +
        "\n0) Voltar");
    }

    public void menuJogo() {
        System.out.println("\n======= Gerenciar Jogo =======" +
        "\n1) Continuar Jogo" +
        "\n2) Novo Jogo" +
        "\n0) Voltar");
    }

    public void menuRegras() {
        System.out.println("\n           ======================== Regras ========================" +
        "\nO jogo Yahtzee é composto por 13 rodadas. Em cada rodada, você lança 5 dados e"+
        "\nescolhe em qual categoria de pontos você prefere marcar a pontuação, dentre as 13"+
        "\ndisponíveis."+
        "\nDurante uma rodada, você pode alterar um ou mais dados até duas vezes antes de"+
        "\nmarcar. Essa opção é totalmente livre, você pode rerrolar um ou mais dados na segunda"+
        "\nrerrolagem que não tenha(m) sido rerrolado(s) na primeira vez."+
        "\nExistem 13 categorias de pontuação, e cada uma deve ser utilizado para uma das 13"+
        "\nrodadas. Portanto, escolha sabiamente. Não raramente, você obterá pontuação zero em"+
        "\nalgumas categorias (por não ter disponível uma categoria que lhe renda pontos para a"+
        "\ncombinação de dados obtida na rodada)."+
        "\nAs 13 categorias de pontuação são:"+
        "\n\n 1-6: há uma categoria para cada número do dado. Nessas categorias o resultado"+
        "\né a soma dos dados com o número relacionado. Por exemplo, uma rolagem de 1-"+
        "\n1-2-5-5 poderia ser marcado como 2 pontos na categoria 1 (dois dados com o"+
        "\nnúmero 1), 2 pontos na categoria 2 (um dado com o número 2), 10 pontos na"+
        "\ncategoria 5 (dois dados com o número cinco), ou 0 pontos nas categorias 3, 4 ou"+
        "\n6 (nenhum dado com esses números). Se um jogador marca um total de pelo"+
        "\nmenos 63 pontos na soma dessas categorias, um bônus de 35 pontos é"+
        "\nadicionado à pontuação total."+
        "\n\n 7. Trinca: Pelo menos três dados mostrando o mesmo número. Pontuação: Soma"+
        "\nde todos os dados (e não só dos dados da trinca)."+
        "\n\n 8. Quadra: Pelo menos quatro dados mostrando o mesmo número. Pontuação:"+
        "\nSoma de todos os dados (e não só dos dados da quadra)."+
        "\n\n 9. Full House: Uma trinca e um par. Pontuação: 25 pontos."+
        "\n\n 10. Sequência curta: Quatro dados em sequência (1-2-3-4, 2-3-4-5 ou 3-4-5-6)."+
        "\nPontuação: 30 pontos."+
        "\n\n 11. Sequência longa: Cinco dados em sequência (1-2-3-4-5 ou 2-3-4-5-6)."+
        "\nPontuação: 40 pontos."+
        "\n\n 12. Yahtzee: Cinco dados mostrando o mesmo número. Pontuação: 50 pontos."+
        "\n\n 13. Sorte: Qualquer combinação de dados. Pontuação: Soma de todos os dados.");
    }
}
