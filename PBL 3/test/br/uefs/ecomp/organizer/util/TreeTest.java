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
package br.uefs.ecomp.organizer.util;

import Excecoes.NenhumElementoEncontradoException;
import Sistema.Musica;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Daniel Cavalcante Dourado
 */
public class TreeTest {

    Tree tree;
    Musica musica;
    Musica musica1;
    Musica musica2;
    Musica musica3;
    Musica musica4;
    Musica musica5;
    Musica musica6;

    @Before
    public void setUp() {
        musica = new Musica("Beatiful", "Eminem", "Relapse", "2009", "Eminem - Beautiful.mp3");
        musica1 = new Musica("Capitulo 4 Versiculo 3", "Racionais MCs", "Sobrevivendo no inferno", "1997", "Capítulo 4 Versículo 3 - Racionais Mcs.mp3");
        musica2 = new Musica("Humble", "Kendrick Lamar", "Damn", "2017", "Humble- Kendrick Lamar.mp3");
        musica3 = new Musica("Heavy", "Linkin Park", "One More Light", "2017", "Heavy (Official Video) - Linkin Park (feat. Kiiara).mp3");
        musica4 = new Musica("Chop Suey!", "System Of A Down", "Toxicity", "2001", "Chop Suey!.mp3");
        musica5 = new Musica("Boss", "LIL PUMP", "LIL PUMP", "2017", "Lil Pump - Boss (Official Music Video).mp3");
        musica6 = new Musica("Phantom Lord", "Metallica", "Kill 'em All", "1983", "07 - Phantom Lord.mp3");
        tree = new Tree();
    }

    /**
     * Testa o metodo de inserir e balancear da arvore AVL
     */
    @Test
    public void testeInsercao() {
        assertEquals(-1, tree.altura(tree.getRaiz()));

        tree.inserir(musica);

        assertEquals(0, tree.altura(tree.getRaiz()));

        tree.inserir(musica1);

        assertEquals(1, tree.altura(tree.getRaiz()));

        tree.inserir(musica2);
        tree.inserir(musica3);

        assertEquals(2, tree.altura(tree.getRaiz()));

        tree.inserir(musica4);
        tree.inserir(musica5);
        tree.inserir(musica6);
        assertEquals(3, tree.altura(tree.getRaiz()));
    }

    /**
     * Testa o metodo de buscar uma musica na arvore AVL
     *
     * @throws NenhumElementoEncontradoException
     */
    @Test(expected = NenhumElementoEncontradoException.class)
    public void testeBusca() throws NenhumElementoEncontradoException {
        tree.inserir(musica);
        tree.inserir(musica1);
        tree.inserir(musica2);
        tree.inserir(musica3);
        tree.inserir(musica4);
        tree.inserir(musica5);
        tree.inserir(musica6);

        assertEquals("Beatiful", tree.find("Be").getNomeMusica());
        assertFalse("Beatiful".equals(tree.find("Humble").getNomeMusica()));
        assertEquals("Chop Suey!", tree.find("Chop").getNomeMusica());
        assertEquals("Beatiful", tree.find("XY").getNomeMusica());//Testando exceção NenhumElementoEncontradoException
    }
}
