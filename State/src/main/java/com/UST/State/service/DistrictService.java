package com.UST.State.service;

import com.UST.State.entity.District;
import com.UST.State.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;
    public List<District> getDistrictsByState(String state) {
        return districtRepository.findByState(state);
    }
}
