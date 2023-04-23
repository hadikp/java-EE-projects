import canban.board.Board;
import junit.framework.TestCase;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CreateDbTest extends TestCase {

    @PersistenceContext
    private EntityManager em;

    public void testCreate(){
        Board board = new Board("Board1", 11);
        em.persist(board);
    }
}
