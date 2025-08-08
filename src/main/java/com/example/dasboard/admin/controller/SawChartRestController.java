package com.example.dasboard.admin.controller;

import com.example.dasboard.admin.model.HasilSAW;
import com.example.dasboard.admin.service.SawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/saw")
public class SawChartRestController {

    @Autowired
    private SawService sawService;

    @GetMapping("/chart-data")
    public List<Map<String, Object>> getChartData() {
        List<HasilSAW> hasilList = sawService.getAllHasilSAW();

        return hasilList.stream().map(h -> {
            Map<String, Object> map = new HashMap<>();
            map.put("nama", h.getHakim().getNama());
            map.put("skor", h.getSkor());
            return map;
        }).collect(Collectors.toList());
    }
}
