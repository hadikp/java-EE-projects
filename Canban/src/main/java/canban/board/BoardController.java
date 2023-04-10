package canban.board;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("board")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BoardController {

    @Inject
    private BoardService boardService;

    @GET
    public List<Board> listBoard(){
        return boardService.listBoard();
    }

    @Path("{id}")
    public Board getBoard(@PathParam("id") Long id){
        return boardService.findBoardById(id);
    }

    @Path("create")
    public Board createBoard(CreateBoardCommand command){
        return boardService.createBoard(command);
    }
}
