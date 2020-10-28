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
import Sistema.SalvarTxt;
import br.uefs.ecomp.organizer.util.Tree;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Daniel Cavalcate Dourado
 */
public class TesteSalvarTags {

    SalvarTxt lerTxt;
    Tree tree;

    @Before
    public void setUp() throws ArquivoNaoEcontradoException, FalhaGeracaoInformacoesException {//(expected = NenhumElementoEncontradoException.class)
        lerTxt = new SalvarTxt();
        tree = lerTxt.salvarTxt();
    }

    /**
     * Testa a insercao das TAGS em uma arvore AVL
     *
     * @throws ArquivoNaoEcontradoException Excecao para caso o arquivo nao seja
     * encontrado
     * @throws FalhaGeracaoInformacoesException Excecao para caso o diretorio
     * nao contenha arquivos esperados
     */
    @Test
    public void testeLerInserir() throws ArquivoNaoEcontradoException, FalhaGeracaoInformacoesException {
        assertEquals(12, tree.altura(tree.getRaiz()));
    }
}
