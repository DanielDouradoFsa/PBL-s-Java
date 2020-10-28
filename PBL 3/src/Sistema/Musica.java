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

/**
 * @author Daniel Cavalcante Dourado
 */
public class Musica {

    String nomeAutor;
    String nomeMusica;
    String albumMusica;
    String ano;
    String nomeArquivoMp3;

    public Musica(String nomeMusica, String nomeAutor, String albumMusica, String ano, String nomeArquivoMp3) {
        this.nomeAutor = nomeAutor;
        this.nomeMusica = nomeMusica;
        this.albumMusica = albumMusica;
        this.ano = ano;
        this.nomeArquivoMp3 = nomeArquivoMp3;
    }

    /**
     * Retorna o nome da Musica
     *
     * @return Nome da Musica
     */
    public String getNomeMusica() {
        return nomeMusica;
    }

    /**
     * Retorna o nome do autor da musica
     *
     * @return Autor da musica
     */
    public String getNomeAutor() {
        return nomeAutor;
    }

    /**
     * Retorna o album da musica
     *
     * @return Album da Musica
     */
    public String getAlbumMusica() {
        return albumMusica;
    }

    /**
     * Retorna o ano da musica
     *
     * @return Ano da musica
     */
    public String getAno() {
        return ano;
    }

    /**
     * Retorna o nome do arquivo MP3
     *
     * @return Nome do arquivo MP3
     */
    public String getNomeArquivoMp3() {
        return nomeArquivoMp3;
    }

    /**
     * Método auxiliar, baseado no comparable, utilizado pela árvore AVL para
     * inserir elementos
     *
     * @param o Musica que será comparada.
     * @return 1 se a primeira música vier antes da segunda, -1 se vier depois e
     * 0 se forem iguais.
     */
    public int comparaMusicas(Musica o) {
        return this.nomeMusica.compareTo(o.nomeMusica);
    }
}
