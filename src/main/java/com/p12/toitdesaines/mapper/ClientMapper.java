package com.p12.toitdesaines.mapper;

import com.p12.toitdesaines.DTO.ClientDTO;
import com.p12.toitdesaines.entity.Client;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClientMapper {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    ClientDTO toClient(Client entity);

    Client toDto(ClientDTO dto);

}
