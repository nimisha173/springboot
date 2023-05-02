package com.UST.State.controller;

import com.UST.State.entity.District;
import com.UST.State.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @GetMapping("/district/state")
    public List<District> getDistrictsByState(@RequestParam("state") String state) {
        return districtService.getDistrictsByState(state);
    }
}
