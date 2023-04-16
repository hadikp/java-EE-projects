package canban.board;

import javax.decorator.Delegate;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("board")
@Produces(MediaType.APPLICATION_JSON)
public class BoardController {

    @Inject
    private BoardService boardService;

    @GET
    public List<Board> listBoard(){
        return boardService.listBoard();
    }

    @GET
    @Path("{id}")
    public Board getBoard(@PathParam("id") Long id){
        return boardService.findBoardById(id);
    }

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBoard(CreateBoardCommand command){
        Board board = boardService.createBoard(command);
        return Response.status(201).entity(board).build();
    }

    @PUT
    @Path("{id}")
    public Response updateBoard(@PathParam("id") long id, UpdateBoardCommand command){
        Board board = boardService.updateBoard(id, command);
        return Response.ok().entity(board).build();
    }

    @DELETE
    @Path("{id}")
    public void deleteBoard(@PathParam("id") Long id){
        boardService.deleteBoard(id);
        //return Response.noContent().build();
    }
}
