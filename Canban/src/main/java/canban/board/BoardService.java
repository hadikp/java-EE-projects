package canban.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
@Transactional
public class BoardService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PersistenceContext
    private EntityManager em;

    @Resource
    private DataSource dataSource;

    public List<Board> listBoard(){
        logger.info("List Board");
        logger.debug("List Board without parameters");
        return em.createQuery("select b from Board b", Board.class).getResultList();
    }

    public Board findBoardById(Long id) {
        Board board = em.find(Board.class, id);
        if (board == null){
            throw new EntityNotFoundException("Can't find board for id: " + id);
        }
        return board;
    }


    public Board createBoard(CreateBoardCommand command) {
        Board board = new Board(command.getName(), command.getPositionNumber());
        em.persist(board);
        return board;
    }
}
