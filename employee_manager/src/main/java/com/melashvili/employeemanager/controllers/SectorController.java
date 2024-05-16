package com.melashvili.employeemanager.controllers;

import com.melashvili.employeemanager.model.lib.Sector;
import com.melashvili.employeemanager.services.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SectorController {

    private final SectorService sectorService;

    @Autowired
    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @GetMapping("/get/sector")
    public ResponseEntity<List<Sector>> getAllSectors(){
        List<Sector> sectors = sectorService.getAllSectors();
        return new ResponseEntity<>(sectors, HttpStatus.OK);
    }

    @GetMapping("/get/sector/{id}")
    public ResponseEntity<Sector> getSectorById(@PathVariable Long id){
        Sector sector = sectorService.getSectorById(id);
        return new ResponseEntity<>(sector, HttpStatus.OK);
    }

    @PostMapping("/post/sector")
    public ResponseEntity<Void> saveSector(@RequestBody Sector sector) {
        sectorService.addSector(sector);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/put/sector/{id}")
    public ResponseEntity<Void> updateSector(@PathVariable Long id,
                                             @RequestBody Sector sector) {
        sectorService.updateSector(id, sector);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/sector/{id}")
    public ResponseEntity<Void> deleteSector(@PathVariable Long id) {
        sectorService.deleteSectorById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
