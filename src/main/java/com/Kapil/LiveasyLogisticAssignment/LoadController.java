/*
class DISCRIPTION :-
    The LoadController is our RESTful web service class that handles HTTP requests and returns HTTP responses.
    It has methods for handling each of the endpoints described in the task.
 */

package com.Kapil.LiveasyLogisticAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/load")
public class LoadController {
    @Autowired
    private LoadService loadService;

    //The @PostMapping("/load") method handles the post "/load" endpoint and creates a new Load in the database by using the LoadService.
    @PostMapping
    public ResponseEntity<String> addLoad(@RequestBody Load load) {
        loadService.addLoad(load);
        return new ResponseEntity<>("Load details added successfully", HttpStatus.OK);
    }

    //The @GetMapping("/load") method handles the GET "/load" endpoint and returns the list of loads for the given shipperId by using the LoadService.
    @GetMapping
    public ResponseEntity<List<Load>> getLoads(@RequestParam("shipperId") String shipperId) {
        List<Load> loads = loadService.getLoads(shipperId);
        return new ResponseEntity<>(loads, HttpStatus.OK);
    }

    //The @GetMapping("/load/{loadId}") method handles the GET "/load/{loadId}" endpoint and returns the Load for the given loadId.
    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoad(@PathVariable("loadId") String loadId) {
        Load load = loadService.getLoad(loadId);
        return new ResponseEntity<>(load, HttpStatus.OK);
    }

    //The @PutMapping("/load/{loadId}") method handles the PUT "/load/{loadId}" endpoint and updates the Load for the given loadId.
    @PutMapping("/{loadId}")
    public ResponseEntity<String> updateLoad(@PathVariable("loadId") String loadId, @RequestBody Load load) {
        loadService.updateLoad(loadId, load);
        return new ResponseEntity<>("Load updated successfully", HttpStatus.OK);
    }

    //The @DeleteMapping("/load/{loadId}") method handles the DELETE "/load/{loadId}" endpoint and deletes the Load for the given loadId.
    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable("loadId") String loadId) {
        loadService.deleteLoad(loadId);
        return new ResponseEntity<>("Load deleted successfully", HttpStatus.OK);
    }
}
