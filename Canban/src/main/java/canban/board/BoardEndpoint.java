package canban.board;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

@WebService(targetNamespace = "http://hadikp.com/canban")
public class BoardEndpoint {

    @Inject
    private BoardService boardService;

    @WebMethod
    @WebResult(name = "board")
    public List<Board> listBoards(){
        return boardService.listBoard();
    }
}
