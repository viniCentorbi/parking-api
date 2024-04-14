package com.api.parkingcontrol.controller;

import com.api.parkingcontrol.model.dto.vehicle.VehicleDto;
import com.api.parkingcontrol.service.vehicle.VehicleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("vehicle")
public class VehicleController {

    private final VehicleService service;

    @Autowired
    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<VehicleDto> save(@RequestBody @Valid VehicleDto postDto){
        return ResponseEntity.ok(this.service.save(postDto));
    }

    @PutMapping
    public ResponseEntity<VehicleDto> update(@RequestBody @Valid VehicleDto putDto) {
        return ResponseEntity.ok(this.service.update(putDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> findById(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.ok(this.service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") UUID id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
