package com.melashvili.employeemanager.model.mapper;

import com.melashvili.employeemanager.model.dto.SectorDTO;
import com.melashvili.employeemanager.model.lib.Sector;
import org.springframework.stereotype.Component;

@Component
public class SectorMapper {

    public static Sector dtoToSector(SectorDTO dto) {
        Sector sector = new Sector();

        sector.setSectorName(dto.getSectorName());
        sector.setSectorLocation(dto.getSectorLocation());

        return sector;
    }

    public static SectorDTO sectorToSectorDTO(Sector sector) {
        SectorDTO sectorDTO = new SectorDTO();

        sectorDTO.setSectorName(sector.getSectorName());
        sectorDTO.setSectorLocation(sector.getSectorLocation());

        return sectorDTO;
    }
}
