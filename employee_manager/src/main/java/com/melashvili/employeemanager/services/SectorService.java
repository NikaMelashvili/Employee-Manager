package com.melashvili.employeemanager.services;

import com.melashvili.employeemanager.model.Sector;
import com.melashvili.employeemanager.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SectorService {

    private final SectorRepository sectorRepository;

    @Autowired
    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    public List<Sector> getAllSectors() {
        Iterable<Sector> temp = sectorRepository.findAll();
        List<Sector> sectors = new ArrayList<>();
        for (Sector sector : temp) {
            sectors.add(sector);
            System.out.println(sector.toString());
        }
        return sectors;
    }

    public Sector getSectorById(Long id) {
        return sectorRepository.findById(id).orElse(null);
    }

    public void addSector(Sector sector) {
        sectorRepository.save(sector);
    }

    public void updateSector(Long id, Sector updatedSector) {
        Optional<Sector> optionalSector = sectorRepository.findById(id);

        if (optionalSector.isPresent()) {
            Sector sector = optionalSector.get();

            sector.setSectorName(updatedSector.getSectorName());
            sector.setSectorLocation(updatedSector.getSectorLocation());

            sectorRepository.save(sector);
        } else {
            System.out.println("Sector not found");
        }
    }

    public void deleteSectorById(Long id) {
        sectorRepository.deleteById(id);
    }
}
