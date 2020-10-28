/***
Autor: Daniel Cavalcante Dourado.
Componente Curricular: MI - Programação II
Concluido em: 02/12/2018
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum 
trecho de código de outro colega ou de outro autor, tais como provindos de livros e 
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
*/
package br.uefs.ecomp.organizer.util;

import java.util.Comparator;

/**
 * @author Daniel Cavalcante Dourado
 */
public class ComparatorString implements Comparator{
    
    @Override
    public int compare(Object t, Object t1) {
        return ((String)t).compareTo(((String)t1));
    }
    
}
