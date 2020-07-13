package com.p12.toitdesaines.mapper;

import com.p12.toitdesaines.DTO.MaisonDTO;
import com.p12.toitdesaines.entity.Maison;
import org.mapstruct.BeanMapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface MaisonMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    MaisonDTO toMaison(Maison entity);

    Maison toDto(MaisonDTO dto);
}
