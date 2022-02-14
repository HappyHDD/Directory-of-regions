package com.example.Directoryofregions.controller;

import com.example.Directoryofregions.domain.Region;
import com.example.Directoryofregions.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/region/api")
@RestController
public class RegionRestController {

    @Autowired
    private RegionService regionService;

    @GetMapping("/all")
    @Cacheable(value = "region")
    List<Region> getAllRegion() {
        return regionService.getAll();
    }

    @PostMapping()
    @CachePut(value = "region", key ="#region.id")
    public void createRegion(@RequestBody Region region)  {
        regionService.createRegion(region);
    }

    @PutMapping("findById/{id}")
    @CachePut(value = "region", key ="#region.id")
    public ResponseEntity<Region> updateRegion(@PathVariable Long id, @RequestBody Region region) {
        regionService.updateRegion(new Region(id,region.getName(), region.getShortname()));
        return ResponseEntity.ok(regionService.getById(id));
    }

    @DeleteMapping("/users/{id}")
    @CacheEvict(value = "region", key ="#id")
    public String deleteUser(@PathVariable Long id) {
        regionService.deleteById(id);
        return "Регион "+ id +" удален" ;
    }

    @PostMapping("/addList")
    public void createRegion(@RequestBody List<Region> listRegion)  {
        for (Region region: listRegion) {
            regionService.createRegion(region);
        }
    }

    @GetMapping("findById/{id}")
    Region getRegionById(@PathVariable Long id) {
        return regionService.getById(id);
    }

    @GetMapping("findByName/{name}")
    Region getRegionByName(@PathVariable String name) {
        return regionService.getByName(name);
    }

    @GetMapping("findByShortName/{shortname}")
    Region getRegionByShortName(@PathVariable String shortname) {
        return regionService.getByShortName(shortname);
    }

}
