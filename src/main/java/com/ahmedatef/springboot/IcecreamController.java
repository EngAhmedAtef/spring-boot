package com.ahmedatef.springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class IcecreamController {

    private List<Flavor> flavors = new ArrayList<>(Arrays.asList(
            new Flavor(1, "Strawberry"),
            new Flavor(2, "Mint Chocolate")
    ));

    @GetMapping("/flavors")
    public List<Flavor> getFlavors() {
        return flavors;
    }

    @PutMapping("/update-flavor/{id}")
    public ResponseEntity<Flavor> updateFlavor(@PathVariable int id, @RequestBody Flavor updatedFlavor) {
        try {
            flavors.set(id - 1, updatedFlavor);
            return ResponseEntity.ok(flavors.get(id - 1));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add-flavor")
    public ResponseEntity<?> addFlavor(@RequestBody Flavor flavor) {
        if (!flavors.contains(flavor)) {
            flavors.add(flavor);
            return ResponseEntity.ok(flavor);
        } else
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Flavor " + flavor.flavorName() + " already exists.");
    }

    @DeleteMapping("/delete-flavor/{id}")
    public ResponseEntity<String> deleteFlavor(@PathVariable int id) {
        try {
            flavors.remove(id - 1);
            return ResponseEntity.ok("Successfully delete the flavor");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No flavor found with the id " + id);
        }
    }

}