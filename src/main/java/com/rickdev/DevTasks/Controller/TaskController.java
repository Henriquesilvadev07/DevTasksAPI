package com.rickdev.DevTasks.Controller;

import com.rickdev.DevTasks.Dto.TaskDto;
import com.rickdev.DevTasks.Model.TaskModel;
import com.rickdev.DevTasks.Service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {


    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskModel> salvar(@RequestBody @Valid TaskDto dto, UriComponentsBuilder uriBuilder) {
        var task = taskService.salvar(dto);
        var uri = uriBuilder.path("/task/{id}").buildAndExpand(task.getId()).toUri();
        return ResponseEntity.created(uri).body(task);
    }

    @GetMapping
    public ResponseEntity<List<TaskModel>> listar(){
        var task = taskService.listarTodos();
        return ResponseEntity.status(201).body(task);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskModel> acharPorId(@PathVariable Long id){
        var task = taskService.acharPorId(id);
        return ResponseEntity.status(201).body(task);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskModel> atualizarPorId(@PathVariable Long id,@RequestBody @Valid TaskDto dto){
        var task = taskService.atualizarPorId(id, dto);
        return ResponseEntity.status(201).body(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        taskService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }


}
