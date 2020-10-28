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
import Excecoes.FalhaGeracaoInformacoesException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Daniel Cavalcante Dourado
 */
public class Leitura {

    File arquivo = new File("./Musicas");

    /**
     * Acessa o arquivo "Musicas" da memória do computador, lê suas tags e as
     * salva em "ArquivoComTags.txt", no mesmo local onde estão as musicas
     *
     * @throws ArquivoNaoEcontradoException Caso a pasta com as músicas nao seja
     * encontrada
     * @throws FalhaGeracaoInformacoesException Caso exista dificuldades para
     * criar o arquivo com TAGS
     */
    public void lerArmazenar() throws ArquivoNaoEcontradoException, FalhaGeracaoInformacoesException {
        String[] musicas = arquivo.list();
        File arquivoMusica;
        //Cria variaveis vazias
        String listaMusica = "";
        try {
            for (String nomeDoArquivoMp3 : musicas) {
                if (nomeDoArquivoMp3.contains(".mp3")) {//Verifica se o arquivo do diretório é um MP3
                    arquivoMusica = new File("./Musicas/" + nomeDoArquivoMp3);//Arquivo auxiliar que irá ler cada uma das músicas
                    FileInputStream arquivoEscritaDeTexto;
                    try {
                        arquivoEscritaDeTexto = new FileInputStream(arquivoMusica);//Recebe uma música
                        arquivoEscritaDeTexto.skip(arquivoMusica.length() - 128);//Pula os bytes que não contém as TAGS
                        byte[] tags = new byte[128];//Armazena as TAGS
                        arquivoEscritaDeTexto.read(tags);
                        listaMusica = new String(tags);
                        String nomeMusica = dadosMusica(listaMusica, 3, 32);
                        String nomeArtista = dadosMusica(listaMusica, 33, 62);
                        String categoriaMusica = dadosMusica(listaMusica, 63, 92);
                        String anoLancamento = dadosMusica(listaMusica, 93, 97);
                        BufferedWriter escreverTxt = new BufferedWriter(new FileWriter("./Musicas/ArquivoComTags.txt", true));
                        escreverTxt.write(nomeMusica);
                        escreverTxt.write(nomeArtista);
                        escreverTxt.write(categoriaMusica);
                        escreverTxt.write(anoLancamento);
                        escreverTxt.write(nomeDoArquivoMp3);
                        escreverTxt.newLine();
                        escreverTxt.flush();
                        /*Escreve cada tag de cada Musica em um arquivo ".txt"*/
                    } catch (FileNotFoundException ex) {
                        throw new ArquivoNaoEcontradoException();
                    } catch (IOException ex) {
                        System.out.println("Usuario, houve um erro inesperado no sistema, aconselha-se checar a pasta de musicas");
                    }
                }
            }
        } catch (NullPointerException ex) {
            throw new FalhaGeracaoInformacoesException();
        }
    }

    /**
     * Método auxiliar que divide uma linha de tags, às separa, salvando em
     * váriaveis específicas
     *
     * @param text String com as TAGS desorganizadas
     * @param inicio Início de uma secção na TAG
     * @param fim Fim de uma secção na TAG
     * @return Uma secção da TAG
     */
    public String dadosMusica(String text, int inicio, int fim) {
        String dado = text.substring(inicio, fim);
        dado = dado.trim();//Remore os espaços
        dado = dado + ";";//Concatena um ";" no final de cada parametro
        return dado;
    }
}
