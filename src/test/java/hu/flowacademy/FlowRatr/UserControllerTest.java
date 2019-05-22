package hu.flowacademy.FlowRatr;

import hu.flowacademy.FlowRatr.controller.UserController;
import hu.flowacademy.FlowRatr.domain.User;
import hu.flowacademy.FlowRatr.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Test
    public void userToSave_thenReturnJsonArray() throws Exception {
        User userToSave = new User("Marcsi", "Marcsi X", "nincs", "meg ez se");

        given(userToSave).willReturn(userToSave);

        mvc.perform(post("/user/add")).andExpect(status().isOk());
    }





/*
    @Test
    public void givenTodoItems_whenTodoItems_thenReturnJsonArray() throws Exception {

        TodoItem todoItemShouldBeFound = new TodoItem("ExTest1", "TestTodoItem", false);

        List<TodoItem> allTodoItemShouldBeFound = Arrays.asList(todoItemShouldBeFound);

        given(todolistService.listItems()).willReturn(allTodoItemShouldBeFound);

        mvc.perform(get("/todolist/list-items")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].description", is(todoItemShouldBeFound.getDescription())));
    }


 */
}
