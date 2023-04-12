package canban.board;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
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
        return em.find(Board.class, id);
    }

    @Transactional
    public Board createBoard(CreateBoardCommand command) {
        Board board = new Board(command.getName(), command.getPositionNumber());
        em.persist(board);
        return board;
    }
}
