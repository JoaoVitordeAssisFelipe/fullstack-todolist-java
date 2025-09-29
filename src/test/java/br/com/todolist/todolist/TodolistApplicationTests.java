package br.com.todolist.todolist;

import br.com.todolist.todolist.model.Task;
import br.com.todolist.todolist.repository.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TodolistApplicationTests {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskRepository taskRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void contextLoads() {
    }

    
    @Test
    public void getAllTasks_deveRetornarListaDeTarefas() throws Exception {
        Task task1 = new Task(1L, "Estudar integração de sistemas", "aprender testes de sistemas", false);
        Task task2 = new Task(2L, "Subir projeto no GitHub", "Organizar o repositório", false);
        List<Task> listaDeTarefas = Arrays.asList(task1, task2);

        given(taskRepository.findAll()).willReturn(listaDeTarefas);

        ResultActions response = mockMvc.perform(get("/api/tasks")
                .contentType(MediaType.APPLICATION_JSON));

        response.andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(listaDeTarefas.size()))
                .andExpect(jsonPath("$[0].title").value("Estudar integração de sistemas"))
                .andExpect(jsonPath("$[1].title").value("Subir projeto no GitHub"));
    }
}