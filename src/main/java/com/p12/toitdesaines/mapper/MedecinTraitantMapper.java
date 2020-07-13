package com.p12.toitdesaines.mapper;

import com.p12.toitdesaines.DTO.MedecinTraitantDTO;
import com.p12.toitdesaines.entity.MedecinTraitant;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MedecinTraitantMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    MedecinTraitantDTO toAdresse (MedecinTraitant entity);

    MedecinTraitant toDto(MedecinTraitantDTO dto);

}
