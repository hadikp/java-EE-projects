package todo;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("todo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TodoRest {

    @Inject
    private TodoService todoService;


    @Path("new")
    @POST
    public Response createTodo(Todo todo){
        todoService.saveTodo(todo);
        return Response.ok(todo).build();
    }

    @Path("update")
    @PUT
    public Response updateTodo(Todo todo){
        todoService.updateTodo(todo);
        return Response.ok(todo).build();
    }

    @Path("{id}")
    public Todo getTodo(@PathParam("id") Long id){
        return todoService.findTodoById(id);
    }

    @Path("list")
    @GET
    public List<Todo> listTodo(){
        return todoService.listTodo();
    }
}
