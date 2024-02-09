//package com.ReservasparaRestaurante.API.restaurant.controllers;
//
//import com.ReservasparaRestaurante.API.restaurant.entities.DinnerEntity;
//import com.ReservasparaRestaurante.API.restaurant.services.DinnerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/dinner")
//public class DinnerController {
//    private final DinnerService dinnerService;
//
//
//    @Autowired
//    public DinnerController(DinnerService dinnerService) {
//
//        this.dinnerService = dinnerService;
//    }
//
//    @RequestMapping("/create")
//    @ResponseStatus(HttpStatus.CREATED)
//    public DinnerEntity createDinner(@RequestBody DinnerEntity dinnerEntity){
//        return dinnerService.createNewDinner(dinnerEntity.getIdDinner(),dinnerEntity.getName(), dinnerEntity.getDescription(), dinnerEntity.getPrice());
//    }
//
//    @GetMapping("/getAll")
//    public List<DinnerEntity> getDinners(){
//        return dinnerService.getAllDinners();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getById(@PathVariable Long id) {
//        try {
//            DinnerEntity dinnerEntity = (DinnerEntity) dinnerService.getDinnerById(id);
//            if (dinnerEntity != null) {
//                return new ResponseEntity<>(dinnerEntity, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>("Dinner with id " + id + " does not exist.", HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>("An error occurred while fetching the menu: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @PutMapping(path = "/update/{id}")
//    public DinnerEntity updateUserByID(@RequestBody DinnerEntity request, @PathVariable Long id) {
//        return dinnerService.updateMenuById(request, id);
//    }
//}
