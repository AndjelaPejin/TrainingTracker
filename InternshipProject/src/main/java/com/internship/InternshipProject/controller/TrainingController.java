package com.internship.InternshipProject.controller;

import com.internship.InternshipProject.DTO.TrainingDTO;
import com.internship.InternshipProject.service.ITrainingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/training")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@Secured("ROLE_USER")
public class TrainingController {

    private final ITrainingService trainingService;

    @PostMapping
    public ResponseEntity<TrainingDTO> create(@RequestBody @Valid TrainingDTO trainingDTO) {
        TrainingDTO createdTraining = trainingService.create(trainingDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTraining);
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(trainingService.getAll());
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<TrainingDTO> getById(@PathVariable String id)  {
        TrainingDTO trainingDTO = trainingService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(trainingDTO);
    }

}
