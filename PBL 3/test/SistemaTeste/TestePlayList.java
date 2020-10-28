/** *
 * Autor: Daniel Cavalcante Dourado.
 * Componente Curricular: MI - Programação II
 * Concluido em: 02/12/2018
 * Declaro que este código foi elaborado por mim de forma individual e não contém nenhum
 * trecho de código de outro colega ou de outro autor, tais como provindos de livros e
 * apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
 * de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
 * do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
 */
package SistemaTeste;

import Excecoes.ArquivoNaoEcontradoException;
import Excecoes.FalhaGeracaoInformacoesException;
import Excecoes.NenhumElementoEncontradoException;
import Excecoes.PlayListSemElementosException;
import Sistema.PlayList;
import Sistema.SalvarTxt;
import br.uefs.ecomp.organizer.util.Tree;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Daniel Cavalcante Dourado
 */
public class TestePlayList {

    PlayList playList;
    Tree tree;

    @Before
    public void setUp() throws ArquivoNaoEcontradoException, FalhaGeracaoInformacoesException {
        tree = new SalvarTxt().salvarTxt();
        playList = new PlayList("PlayList");
    }

    /**
     * Teste para a excecao "PlayListSemElementosException"
     *
     * @throws PlayListSemElementosException Excecao criada caso a playlist seja
     * criada e encerrada sem nenhuma busca inserida
     */
    @Test(expected = PlayListSemElementosException.class)
    public void playListSemElementos() throws PlayListSemElementosException {
        playList.cabecalhoPlayList("PlayList da Doidera");
        playList.encerrarPlayList();

    }

    /**
     * Testa o metodo desenvolvido para que so possa ser criado um cabeçalho e
     * encerrar o arquivo somente uma vez
     *
     * @throws Excecoes.PlayListSemElementosException
     */
    @Test
    public void testarFormatoPlayList() throws PlayListSemElementosException {
        assertTrue(playList.cabecalhoPlayList("PlayList"));
        //Criação do cabeçalho
        assertFalse(playList.cabecalhoPlayList("PlayList"));
        //Tentativa sem sucesso de criar outro cabeçalho
        try {
            assertTrue(playList.adicionarBusca(tree, "M"));
            assertTrue(playList.adicionarBusca(tree, "G"));
            //Busca realizada porém, não há uma  musica contendo a palavra chave
            assertTrue(playList.encerrarPlayList());
            //Encerrando PlayList
            assertFalse(playList.encerrarPlayList());
            //Tentativa falha de encerrar a PlayList novamente
            assertFalse(playList.adicionarBusca(tree, "G"));
            //Tentativa falha de buscar uma música com a playList encerrada
        } catch (NenhumElementoEncontradoException ex) {
            System.out.println("Usuario, nenhuma musica comeca com a palavra chave escolhida");
        }
    }
}
