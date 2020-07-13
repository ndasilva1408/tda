package com.p12.toitdesaines.mapper;

import com.p12.toitdesaines.DTO.IntervenantDTO;
import com.p12.toitdesaines.entity.Intervenant;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)

public interface IntervenantMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    IntervenantDTO toIntervenant(Intervenant entity);

    Intervenant toDto(IntervenantDTO dto);
}
