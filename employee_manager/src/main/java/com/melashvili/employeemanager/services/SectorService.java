package com.melashvili.employeemanager.services;

import com.melashvili.employeemanager.model.dto.AdminDTO;
import com.melashvili.employeemanager.model.dto.SectorDTO;
import com.melashvili.employeemanager.model.lib.Admin;
import com.melashvili.employeemanager.model.lib.Sector;
import com.melashvili.employeemanager.model.mapper.AdminMapper;
import com.melashvili.employeemanager.model.mapper.SectorMapper;
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

    public List<SectorDTO> getAllSectors() {
        Iterable<Sector> temp = sectorRepository.findAll();
        List<Sector> sectors = new ArrayList<>();
        for (Sector sector : temp) {
            sectors.add(sector);
            System.out.println(sector.toString());
        }
        List<SectorDTO> sectorDTOS = new ArrayList<>();
        for (Sector sector : sectors) {
            sectorDTOS.add(SectorMapper.sectorToSectorDTO(sector));
        }
        return sectorDTOS;
    }

    public SectorDTO getSectorById(Long id) {
        return SectorMapper.sectorToSectorDTO(sectorRepository.findById(id).orElse(null));
    }

    public void addSector(SectorDTO sector) {
        sectorRepository.save(SectorMapper.dtoToSector(sector));
    }

    public void updateSector(Long id, SectorDTO updatedSector) {
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
