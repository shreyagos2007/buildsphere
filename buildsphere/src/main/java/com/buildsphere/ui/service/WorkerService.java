package com.buildsphere.ui.service;

import com.buildsphere.ui.model.Worker;
import com.buildsphere.ui.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public Worker saveWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    public Optional<Worker> getWorkerById(Long id) {
        return workerRepository.findById(id);
    }

    public Worker updateWorker(Worker worker) {
        return workerRepository.save(worker);
    }

    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
    }
}