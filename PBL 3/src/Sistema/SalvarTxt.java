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
package Sistema;

import Excecoes.ArquivoNaoEcontradoException;

import br.uefs.ecomp.organizer.util.Tree;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Daniel Cavalcante Dourado
 */
public class SalvarTxt {

    /**
     * Le o arquivo "ArquivoComTags.txt" com as TAGS, armazena as TAGS em
     * objetos do tipo música e as salva em uma Árvore AVL
     *
     * @return Árvore contendo as músicas inseridas
     * @throws ArquivoNaoEcontradoException Caso o arquivo com TAGS não seja
     * encontrado
     */
    public Tree salvarTxt() throws ArquivoNaoEcontradoException {
        Tree tree = new Tree();
        BufferedReader lerLinha;
        FileReader lerArquivo;
        try {
            lerArquivo = new FileReader("./Musicas/ArquivoComTags.txt");
            lerLinha = new BufferedReader(lerArquivo);
            Musica musica;//Objeto musica que sera inserido na lista encadeada auxiliar
            String linha = lerLinha.readLine();
            while (linha != null) {
                String[] tags = linha.split(";");
                musica = new Musica(tags[0], tags[1], tags[2], tags[3], tags[4]);
                tree.inserir(musica);
                linha = lerLinha.readLine();
            }
        } catch (FileNotFoundException ex) {
            throw new ArquivoNaoEcontradoException();
        } catch (IOException ex) {

        }
        return tree;

    }
}
