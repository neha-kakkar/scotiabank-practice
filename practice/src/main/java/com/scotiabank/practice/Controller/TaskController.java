package com.scotiabank.practice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


    @RestController
    class TaskController {
        private static Logger log = Logger.getLogger("Solution");
        // log.info("You can use 'log' for debug messages");

        @Autowired
        private TaskRepository tasksRepository;


        ResponseEntity responseEntity = null;


        @PostMapping("/accounts/balance/inquiry")
        public ResponseEntity getAccountLatestBalance(@RequestBody Task task){

          ResponseEntity  responseEntity =  ResponseEntity.status(400).contentType(MediaType.APPLICATION_JSON).body("{\"status\":\"111\",\"description\":\"account not found.\"}");

          return responseEntity;
        }

        @PutMapping(value = "/tasks/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
        @ResponseBody
        public ResponseEntity<String> updateTask(@RequestBody Task taskRequest, @PathVariable(name = "id") Long id) {
            if (taskRequest.getDescription() == null) {
                return new ResponseEntity("{\"message\":\"Task description is required\",\"status\":\"400\"}", HttpStatus.BAD_REQUEST);
            }
            Boolean ispresent = tasksRepository.existsById(id);
            if (!ispresent) {
                return new ResponseEntity("{\"message\":\"Cannot find task with given id\",\"status\":\"404\"}",HttpStatus.NOT_FOUND);
            } else {
                Task task = new Task();
                task = tasksRepository.findById(id).get();
                task.setDescription(taskRequest.getDescription());
                task.setPriority(taskRequest.getPriority());
                tasksRepository.save(task);
                return new ResponseEntity("{\"description\":\""+taskRequest.getDescription()+"\",\"priority\":\""+taskRequest.getPriority()+"\"}",HttpStatus.OK);

            }
        }

    }
