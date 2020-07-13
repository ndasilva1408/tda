package com.p12.toitdesaines.mapper;


import com.p12.toitdesaines.DTO.AdresseDTO;
import com.p12.toitdesaines.entity.Adresse;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AdresseMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    AdresseDTO toAdresse (Adresse entity);

    Adresse toDto(AdresseDTO dto);

}
