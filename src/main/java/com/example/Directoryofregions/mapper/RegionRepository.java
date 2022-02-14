package com.example.Directoryofregions.mapper;

import com.example.Directoryofregions.domain.Region;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface RegionRepository {

    @Select("SELECT id, name, shortname FROM region")
    List<Region> findAll();

    @Select("SELECT id, name, shortname FROM region WHERE id = #{id}")
    Region findById(@Param("id") Long id);

    @Select("SELECT id, name, shortname FROM region WHERE name = #{name}")
    Region findByName(@Param("name") String name);

    @Select("SELECT id, name, shortname FROM region WHERE shortname = #{shortname}")
    Region findByShortName(@Param("shortname") String shortname);

    @Delete("DELETE FROM region WHERE id = #{id}")
    int deleteById(Long id);

    @Insert("INSERT INTO region(name, shortname) " +
            " VALUES (#{name}, #{shortname})")
    int insertRegion(Region region);

    @Update("Update region set name=#{name}, " +
            " shortname=#{shortname} where id=#{id}")
    int update(Region region);
}
