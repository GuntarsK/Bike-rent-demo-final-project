package com.sda.bike.rent.mapper;

import com.sda.bike.rent.dto.BikeDTO;
import com.sda.bike.rent.model.Bike;
import com.sda.bike.rent.model.userTypeEnum.BikeCategory;
import org.springframework.stereotype.Component;

@Component
public class BikeMapper {

    public Bike fromDTO(BikeDTO bikeDTO) {
        Bike bike = new Bike();

        bike.setBikePk(bikeDTO.getBikePk());
        bike.setManufacturer(bikeDTO.getManufacturer());
        bike.setBikeModel(bikeDTO.getBikeModel());
        if (bikeDTO.getCategory() == null) {
            bike.setCategory(null);
        } else {
            bike.setCategory(BikeCategory.valueOf(bikeDTO.getCategory()));
        }
        bike.setPrice(bikeDTO.getPrice());
        bike.setPcsInStock(bikeDTO.getPcsInStock());
        bike.setStatus(bikeDTO.getStatus());

        return bike;
    }


    public BikeDTO toDTO(Bike bike) {
        BikeDTO bikeDTO = new BikeDTO();

        bikeDTO.setBikePk(bike.getBikePk());
        bikeDTO.setManufacturer(bike.getManufacturer());
        bikeDTO.setBikeModel(bike.getBikeModel());
        bikeDTO.setCategory(bike.getCategory().name());
        bikeDTO.setPrice(bike.getPrice());
        bikeDTO.setPcsInStock(bike.getPcsInStock());
        bikeDTO.setStatus(bike.getStatus());

        return bikeDTO;
    }


}
