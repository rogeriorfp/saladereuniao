package com.digital.crud.saladereuniao.saladereuniao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.digital.crud.saladereuniao.saladereuniao.exception.ResourceNotFoundException;
import com.digital.crud.saladereuniao.saladereuniao.model.Room;
import com.digital.crud.saladereuniao.saladereuniao.repository.RoomRepository;



@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin(origins = "http://localhost:4200")
public class RoomController {
    
    @Autowired private RoomRepository roomRepository;

    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable long roomId) {
        Room room  = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room not found: " + roomId));
        return ResponseEntity.ok(room);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Room createRoom(@Valid @RequestBody Room room) {
         return roomRepository.save(room);        
    }

    @PutMapping("/{roomId}")
    public ResponseEntity<Room> updateRoom(@PathVariable Long roomId, @Valid @RequestBody Room room) {
        Room existingRoom = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room not found for this id: " + roomId));
        BeanUtils.copyProperties(room, existingRoom, "id");
        final Room updatedRoom = roomRepository.save(existingRoom);
        return ResponseEntity.ok(updatedRoom);
    }

    @DeleteMapping("/{roomId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoom(@PathVariable Long roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException("Room not found for this id: " + roomId));
        roomRepository.delete(room);
    }
}
