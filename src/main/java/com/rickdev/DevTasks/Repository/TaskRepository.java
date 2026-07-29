package com.rickdev.DevTasks.Repository;

import com.rickdev.DevTasks.Model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
}
