package com.rickdev.DevTasks.Service;

import com.rickdev.DevTasks.Dto.TaskDto;
import com.rickdev.DevTasks.Model.TaskModel;
import com.rickdev.DevTasks.Repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskModel salvar(TaskDto dto) {
        TaskModel task = new TaskModel();
        task.setTitulo(dto.titulo());
        task.setDescricao(dto.descricao());
        task.setStatus(dto.status());
        return taskRepository.save(task);
    }

    public List<TaskModel> listarTodos() {
        return taskRepository.findAll();
    }

    public TaskModel acharPorId(Long id) {
        return taskRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Id nao encontrado na base de dados"));
    }

    public TaskModel atualizarPorId(Long id, TaskDto dto) {
        TaskModel task = taskRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Task Nao existente"));

        task.setTitulo(dto.titulo());
        task.setDescricao(dto.descricao());
        task.setStatus(dto.status());

        return taskRepository.saveAndFlush(task);
    }

    public void deletarPorId(Long id) {
        if (taskRepository.existsById(id)){
            taskRepository.deleteById(id);
        }else {
            throw new RuntimeException("Task nao existe");
        }
    }
}
