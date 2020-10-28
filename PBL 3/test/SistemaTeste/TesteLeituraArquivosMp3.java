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
import Sistema.Leitura;
import Sistema.Musica;
import br.uefs.ecomp.organizer.util.Tree;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author administrador1
 */
public class TesteLeituraArquivosMp3 {

    Leitura leitura;
    BufferedReader lerLinha;
    FileReader lerArquivo;
    Musica musica;
    Tree tree;
    String[] tags;
    String linha;

    @Before
    public void setUp() {//(expected = NenhumElementoEncontradoException.class)
        leitura = new Leitura();
        tree = new Tree();
    }

    @Test
    public void testarEscrita() throws FalhaGeracaoInformacoesException, ArquivoNaoEcontradoException, FileNotFoundException, IOException {
        leitura.lerArmazenar();
        lerArquivo = new FileReader("./Musicas/ArquivoComTags.txt");
        lerLinha = new BufferedReader(lerArquivo);

        linha = lerLinha.readLine();
        tags = linha.split(";");
        assertEquals("Battery", tags[0]);

        linha = lerLinha.readLine();
        tags = linha.split(";");
        assertEquals("Fight Fire With Fire", tags[0]);

        linha = lerLinha.readLine();
        tags = linha.split(";");
        assertEquals("Hit The Lights", tags[0]);

        linha = lerLinha.readLine();
        tags = linha.split(";");
        assertEquals("Master Of Puppets", tags[0]);

    }
}
