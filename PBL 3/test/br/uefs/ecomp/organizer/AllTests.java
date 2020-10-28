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
package br.uefs.ecomp.organizer;

import SistemaTeste.TesteLeituraArquivosMp3;
import SistemaTeste.TestePlayList;
import SistemaTeste.TesteSalvarTags;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.uefs.ecomp.organizer.util.TreeTest;

/**
 * @author Daniel Cavalcante Dourado
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
    TesteLeituraArquivosMp3.class,
    TestePlayList.class,
    TesteSalvarTags.class,
    TreeTest.class,})
public class AllTests {
}
