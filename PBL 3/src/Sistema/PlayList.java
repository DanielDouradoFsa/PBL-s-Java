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

import Excecoes.NenhumElementoEncontradoException;
import Excecoes.PlayListSemElementosException;
import br.uefs.ecomp.organizer.util.Tree;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Daniel Cavalcante Dourado
 */
public class PlayList {

    private String nomePlayList;//Diretorio onde será salvo a playlist de musicas
    private int numeroCabecalho = 0;
    private int encerrarPlaylist = 0;
    private boolean playListVazia = true;
    FileWriter fileWrite;
    BufferedWriter bufferedWriter;

    public PlayList(String diretorio) {
        this.nomePlayList = diretorio;
    }

    /**
     * Cria um cabeçalho para a playList, contendo um comentario do usuario,
     * data da criação da playlist e o diretório onde se encontram as musicas
     *
     * @param comentarioUsuario Comentario do usuario
     * @return true, caso seja a primeira criação do cabeçalho. False, se um
     * cabeçalho ja foi criado para o mesmo Objeto
     */
    public boolean cabecalhoPlayList(String comentarioUsuario) {
        if (numeroCabecalho == 0) {
            numeroCabecalho++;
            try {
                String diretorio = new File("Musica").getAbsolutePath();
                fileWrite = new FileWriter("./" + nomePlayList + ".txt", false);
                bufferedWriter = new BufferedWriter(fileWrite);
                //cria um objeto calendario
                Calendar calendario = Calendar.getInstance();
                //recebe a hora e a data atual
                Date dataHoraAtual = calendario.getTime();
                //cria um objeto que irá formatar a data e a hora
                DateFormat formatarDataHora = DateFormat.getDateTimeInstance();
                bufferedWriter.write(comentarioUsuario);
                bufferedWriter.newLine();
                bufferedWriter.write("Hora da Criacao: " + formatarDataHora.format(dataHoraAtual));
                bufferedWriter.newLine();
                bufferedWriter.write("Diretorio: " + diretorio);
                bufferedWriter.newLine();
                bufferedWriter.close();
                fileWrite.close();
                return true;
            } catch (IOException ex) {
            }
        }
        return false;
    }

    /**
     * Recebe como parametro uma palavra-chave e uma árvore. Será buscado, na
     * arvore , a palavra-chave e, caso retorne uma música, a mesma terá o nome
     * do seu arquivo escrito na playList
     *
     * @param tree Árvore AVL onde as músicas serão buscadas
     * @param find Palavra-Chave para buscar um música na árvore
     * @throws NenhumElementoEncontradoException Exceção caso a busca nao
     * retorne nenhuma música
     * @return true, caso a playList ainda não tenha sido encerrada, false caso
     * seja requisitado uma busca com a playList encerrada
     */
    public boolean adicionarBusca(Tree tree, String find) throws NenhumElementoEncontradoException {
        if (encerrarPlaylist == 0) {
            try {
                fileWrite = new FileWriter("./" + nomePlayList + ".txt", true);
                bufferedWriter = new BufferedWriter(fileWrite);
                String arquivoMusica = tree.find(find).nomeArquivoMp3;
                playListVazia = false;//A playList contianuará vazia caso a pesquisa lançe uma execeção 
                bufferedWriter.write("\n" + arquivoMusica);
                bufferedWriter.newLine();
                bufferedWriter.close();
                fileWrite.close();
                return true;
            } catch (IOException ex) {
            }
        }
        return false;
    }

    /**
     * Encerra a playList de músicas, gerando uma mensagem de agradecimento e
     * impedindo que novas músicas sejam adicionadas.
     *
     * @return true, se for a primeira vez que a playList for encerrada. False
     * se a playList ja tenha sido encerrada
     * @throws PlayListSemElementosException Caso a playList seja encerrada sem
     * que nenhuma música seja inserida
     */
    public boolean encerrarPlayList() throws PlayListSemElementosException {
        if (encerrarPlaylist == 0) {
            if (playListVazia) {
                throw new PlayListSemElementosException();
            }
            encerrarPlaylist++;
            try {
                fileWrite = new FileWriter("./" + nomePlayList + ".txt", true);
                bufferedWriter = new BufferedWriter(fileWrite);
                bufferedWriter.newLine();
                bufferedWriter.write("PLAYLIST ENCERRADA");
                bufferedWriter.newLine();
                bufferedWriter.write("Obrigado por utilizar o sistema gerador de PlayLists");
                bufferedWriter.close();
                fileWrite.close();
            } catch (IOException ex) {
            }
            return true;
        }
        return false;
    }
}
