package com.example.Directoryofregions.service;

import com.example.Directoryofregions.domain.Region;
import com.example.Directoryofregions.mapper.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    RegionRepository regionRepository;

    public List<Region> getAll(){
        return  regionRepository.findAll();
    }

    public Region getById(Long id){
        return  regionRepository.findById(id);
    }

    public Region getByName(String name){
        return  regionRepository.findByName(name);
    }

    public Region getByShortName(String shortname){
        return  regionRepository.findByShortName(shortname);
    }

    public int deleteById(Long id){
        return regionRepository.deleteById(id);
    }

    public int createRegion(Region region){
        return  regionRepository.insertRegion(region);
    }

    public int updateRegion(Region region){
        return regionRepository.update(region);
    }
}
