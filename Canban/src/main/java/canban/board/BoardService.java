package canban.board;

import javax.annotation.Resource;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
@Transactional
public class BoardService {

    @PersistenceContext
    private EntityManager em;

    @Resource
    private DataSource dataSource;

    public List<Board> listBoard(){
        return em.createQuery("select b from Board b", Board.class).getResultList();
    }
}