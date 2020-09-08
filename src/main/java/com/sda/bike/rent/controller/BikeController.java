package com.sda.bike.rent.controller;

import com.sda.bike.rent.dto.BikeDTO;
import com.sda.bike.rent.dto.Response;
import com.sda.bike.rent.dto.ResponseMapper;
import com.sda.bike.rent.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/rest/bike.svc")
@CrossOrigin
public class BikeController {

    private final BikeService bikeService;
    private final ResponseMapper responseMapper;

    @Autowired
    public BikeController(BikeService bikeService, ResponseMapper responseMapper) {
        this.bikeService = bikeService;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/bike")
    public Response createBike(@Valid @RequestBody BikeDTO bikeDTO) {
        if (bikeService.doesModelExist(bikeDTO.getBikeModel())) {
            return responseMapper.mapFail("Bike model: " + bikeDTO.getBikeModel() + " already exists", "WARNING");
        }
        return responseMapper
                .mapSuccess(bikeService.createBike(bikeDTO));
    }

    @GetMapping("/bikes")
    public Response getAllBikes() {
        return responseMapper
                .mapSuccess(bikeService.getBikes());
    }

    @GetMapping("/user({id})")
    public Response getBikeById(@PathVariable("id") Long id) {
        return responseMapper
                .mapSuccess(bikeService.getBikeById(id));
    }

    @PutMapping("/bike")
    public void updateBike(@RequestBody BikeDTO bikeDTO) {
        bikeService.createBike(bikeDTO);
    }

    @PostMapping("/bikes/search")
    public Response search(@RequestBody BikeDTO bikeDTO) {
        return responseMapper
                .mapSuccess(bikeService.search(bikeDTO));
    }

}
