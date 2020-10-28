/***
Autor: Daniel Cavalcante Dourado.
Componente Curricular: MI - Programação II
Concluido em: 12/11/2018
Declaro que este código foi elaborado por mim de forma individual e não contém nenhum 
trecho de código de outro colega ou de outro autor, tais como provindos de livros e 
apostilas, e páginas ou documentos eletrônicos da Internet. Qualquer trecho de código
de outra autoria que não a minha está destacado com uma citação para o autor e a fonte
do código, e estou ciente que estes trechos não serão considerados para fins de avaliação.
*/
package Comparators;

import br.uefs.ecomp.organizer.model.Produto;
import java.util.Comparator;

/**
 * @author Daniel Cavalcante Dourado
 */
public class OrdenaPelaData implements Comparator{
    /**
     * Compara a data de chegada entre dois objetos
     * @param t Objeto1
     * @param t1 Objeto2
     * @return 1 se t<t1, -1 se t>t1 e 0 se forem iguais
     */
    @Override
    public int compare(Object t, Object t1) {
        if(((Produto)t).getDataChegada().before(((Produto)t1).getDataChegada()))
            return 1;
        else if(((Produto)t).getDataChegada().after(((Produto)t1).getDataChegada()))
            return -1;
        return 0;
    }
}
