//package com.UdemyProjectDev.UdemyProjectDev.service;
//
//import com.UdemyProjectDev.UdemyProjectDev.model.Task;
//import com.UdemyProjectDev.UdemyProjectDev.repository.TaskRepository;
//import com.UdemyProjectDev.UdemyProjectDev.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TaskService {
//
//    @Autowired
//    private TaskRepository taskRepository;
//
//    public Task createTask(Task task) {
//        return taskRepository.save(task);
//    }
//
//    public Task updateTask(Long taskId, Task updatedTask) {
//        Optional<Task> existingTaskOptional = taskRepository.findById(taskId);
//        if (existingTaskOptional.isPresent()) {
//            Task existingTask = existingTaskOptional.get();
//            existingTask.setDescription(updatedTask.getDescription());
//            existingTask.setStatus(updatedTask.getStatus());
//            // Update other task attributes as needed
//            return taskRepository.save(existingTask);
//        } else {
//            throw new IllegalArgumentException("Task not found with ID: " + taskId);
//        }
//    }
//
//    public void assignTask(Task task)
//        {
//
//        }
//
//    public void completeTask(Long taskId) {
//
//    public void deleteTask(Long taskId) {
//        taskRepository.deleteById(taskId);
//    }
//
////    public List<Task> getAllTasks() {
////        return taskRepository.findAll();
////    }
//
//    public Task getTaskById(Long taskId) {
//        return taskRepository.findById(taskId)
//                .orElseThrow(() -> new IllegalArgumentException("Task not found with ID: " + taskId));
//    }
//
//}
