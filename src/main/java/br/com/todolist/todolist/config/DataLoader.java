package br.com.todolist.todolist.config;

import br.com.todolist.todolist.model.Task;
import br.com.todolist.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- CARREGANDO DADOS DE TESTE INICIAIS ---");

        Task taskTeste = new Task();
        taskTeste.setTitle("Tarefa de Teste Direto");
        taskTeste.setDescription("Esta tarefa foi salva pelo CommandLineRunner.");
        taskTeste.setCompleted(false);

        try {
            Task taskSalva = taskRepository.save(taskTeste);

            System.out.println("SUCESSO: Tarefa de teste salva com ID: " + taskSalva.getId());

        } catch (Exception e) {
            System.out.println("ERRO AO SALVAR: Uma exceção ocorreu durante o save!");
            e.printStackTrace(); // Isso vai imprimir o erro completo e detalhado no console
        }

        System.out.println("--------------------------------------------");
    }
}