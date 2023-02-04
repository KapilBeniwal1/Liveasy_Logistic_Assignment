/*
DISCRIPTION :-
    The LoadService is a service class that contains business logic for creating, updating, and deleting Loads.
    It uses the LoadRepository to interact with the database.
 */

package com.Kapil.LiveasyLogisticAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadService {
    @Autowired
    private LoadRepository loadRepository;


    //The addLoad method creates a new Load in the database.
    public void addLoad(Load load) {
        loadRepository.save(load);
    }


    //The getLoads method returns the list of Loads for the given shipperId.
    public List<Load> getLoads(String shipperId) {
        return loadRepository.findByShipperId(shipperId);
    }


    //The getLoad method returns the Load for the given loadId.
    public Load getLoad(String loadId) {
        return loadRepository.findById(loadId).orElse(null);
    }


    //The updateLoad method updates the Load for the given loadId.
    public void updateLoad(String loadId, Load load) {
        Load loadToUpdate = loadRepository.findById(loadId).orElse(null);
        if (loadToUpdate != null) {
            loadToUpdate.setLoadingPoint(load.getLoadingPoint());
            loadToUpdate.setUnloadingPoint(load.getUnloadingPoint());
            loadToUpdate.setProductType(load.getProductType());
            loadToUpdate.setTruckType(load.getTruckType());
            loadToUpdate.setNoOfTrucks(load.getNoOfTrucks());
            loadToUpdate.setWeight(load.getWeight());
            loadToUpdate.setComment(load.getComment());
            loadToUpdate.setDate(load.getDate());
            loadRepository.save(loadToUpdate);
        }
    }


   //The deleteLoad method deletes the Load for the given loadId.
    public void deleteLoad(String loadId) {
        loadRepository.deleteById(loadId);
    }
}
