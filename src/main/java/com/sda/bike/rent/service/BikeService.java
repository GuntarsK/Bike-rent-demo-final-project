package com.sda.bike.rent.service;

import com.sda.bike.rent.dto.BikeDTO;
import com.sda.bike.rent.mapper.BikeMapper;
import com.sda.bike.rent.model.Bike;
import com.sda.bike.rent.repository.BikeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BikeService {

    private final BikeRepository bikeRepository;
    private final BikeMapper bikeMapper;

    @Autowired
    public BikeService(BikeRepository bikeRepository, BikeMapper bikeMapper) {
        this.bikeRepository = bikeRepository;
        this.bikeMapper = bikeMapper;
    }

    public BikeDTO createBike(BikeDTO bikeDTO) {
        Bike bike = bikeMapper.fromDTO(bikeDTO);
        Bike cratedBike = bikeRepository.save(bike);
        return bikeMapper.toDTO(cratedBike);
    }

    public void updateBike(BikeDTO bikeDTO) {
        Bike bikeToUpdate = bikeMapper.fromDTO(bikeDTO);
        Bike bikeFromDB = bikeRepository.getOne(bikeDTO.getBikePk());
        BeanUtils.copyProperties(bikeToUpdate, bikeFromDB, "bikePk");
        bikeRepository.save(bikeFromDB);
    }

    public List<BikeDTO> getBikes() {
        List<Bike> bikes = bikeRepository.findAll();
        return bikes.stream()
                .map(bikeMapper::toDTO)
                .filter(t -> "ACTIVE".equals(t.getStatus()))
                .collect(Collectors.toList());
    }

    public BikeDTO getBikeById(Long id) {
        Optional<Bike> optionalBike = bikeRepository.findById(id);
        Bike bike = optionalBike.orElseGet(Bike::new);
        return bikeMapper.toDTO(bike);
    }

    public List<BikeDTO> search(BikeDTO bikeDTO) {
        Bike bike = bikeMapper.fromDTO(bikeDTO);
        Example<Bike> bikeExample = Example.of(bike);
        List<Bike> bikes = bikeRepository.findAll(bikeExample);
        return bikes.stream()
                .map(bikeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public BikeDTO deleteBike(Long id) {
        Bike bike = bikeRepository.getOne(id);
        bike.setStatus("DELETED");
        bikeMapper.toDTO(bike);
        Bike deletedBike = bikeRepository.save(bike);
        return bikeMapper.toDTO(deletedBike);

    }

    public Boolean doesModelExist(String model) {
        Bike bike = bikeRepository.findByBikeModel(model);
        return bike != null;
    }


}
