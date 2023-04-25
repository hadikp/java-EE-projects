package canban.squad;

import canban.board.Board;
import canban.board.BoardService;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EnumType;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;

@Singleton
public class SquadService {

    @PersistenceContext
    private EntityManager em;

    @Resource
    private DataSource dataSource;

    @Inject
    private BoardService boardService;



    @Transactional
    public Squad createSquad(CreateSquadCommand command) {
        Squad squad = new Squad(command.getName(), command.getDescription(), command.getStartDate());
        Board board = boardService.findBoardById(command.getBoardId());
        squad.setBoard(board);
        em.persist(squad);
        return squad;
    }
}
