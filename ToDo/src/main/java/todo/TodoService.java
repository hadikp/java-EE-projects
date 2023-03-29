package todo;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TodoService {

    @PersistenceContext
    private EntityManager em;

    public List<Todo> listTodo(){
        return em.createQuery("select t from Todo t", Todo.class).getResultList();
    }

    public Todo findTodoById(Long id){
        return em.find(Todo.class, id);
    }
    public Todo saveTodo(Todo todo){
        em.persist(todo);
        return todo;
    }

    public Todo updateTodo(Todo todo){
        em.merge(todo);
        return todo;
    }

}
