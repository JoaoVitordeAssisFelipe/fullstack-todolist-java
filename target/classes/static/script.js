const API_URL = 'http://localhost:8080/api/tasks';

const taskForm = document.getElementById('task-form');
const taskList = document.getElementById('task-list');

async function fetchTasks() {
    try {
        const response = await fetch(API_URL);
        const tasks = await response.json();

        taskList.innerHTML = '';

        tasks.forEach(task => {
            const li = document.createElement('li');
            li.innerHTML = `
                <div>
                    <strong>${task.title}</strong>
                    <p>${task.description || ''}</p>
                </div>
                <div class="task-actions">
                    <button class="btn-complete" onclick="toggleComplete(${task.id}, ${!task.completed})">
                        ${task.completed ? 'Desmarcar' : 'Concluir'}
                    </button>
                    <button class="btn-delete" onclick="deleteTask(${task.id})">Excluir</button>
                </div>
            `;
            if (task.completed) {
                li.classList.add('completed');
            }
            taskList.appendChild(li);
        });
    } catch (error) {
        console.error('Erro ao buscar tarefas:', error);
    }
}

taskForm.addEventListener('submit', async (event) => {
    event.preventDefault();

    const title = document.getElementById('title').value;
    const description = document.getElementById('description').value;

    try {
        await fetch(API_URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ title, description, completed: false }),
        });
        taskForm.reset();
        fetchTasks();
    } catch (error) {
        console.error('Erro ao criar tarefa:', error);
    }
});

async function deleteTask(id) {
    if (confirm('Tem certeza que deseja excluir esta tarefa?')) {
        try {
            await fetch(`${API_URL}/${id}`, {
                method: 'DELETE',
            });
            fetchTasks();
        } catch (error) {
            console.error('Erro ao deletar tarefa:', error);
        }
    }
}

async function toggleComplete(id, isCompleted) {
    try {
        const response = await fetch(`${API_URL}`);
        const tasks = await response.json();
        const taskToUpdate = tasks.find(t => t.id === id);

        await fetch(`${API_URL}/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ ...taskToUpdate, completed: isCompleted }),
        });
        fetchTasks();
    } catch (error) {
        console.error('Erro ao atualizar tarefa:', error);
    }
}

document.addEventListener('DOMContentLoaded', fetchTasks);