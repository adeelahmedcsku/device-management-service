package org.example.devicemanagement.mapper;


import org.example.devicemanagement.dto.DeviceDto;
import org.example.devicemanagement.entity.Device;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface DeviceMapper {
    DeviceMapper INSTANCE = Mappers.getMapper(DeviceMapper.class);

    DeviceDto toDeviceDto(Device device);

    Device toDevice(DeviceDto deviceDto);
}
