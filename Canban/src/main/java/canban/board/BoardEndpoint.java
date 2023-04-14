package canban.board;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService
public class BoardEndpoint {

    @Inject
    private BoardService boardService;

    @WebMethod
    public List<Board> listBoards(){
        return boardService.listBoard();
    }
}
