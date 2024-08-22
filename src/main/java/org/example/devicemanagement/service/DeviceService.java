package org.example.devicemanagement.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.devicemanagement.dto.DeviceDto;
import org.example.devicemanagement.entity.Device;
import org.example.devicemanagement.mapper.DeviceMapper;
import org.example.devicemanagement.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;


    private DeviceMapper deviceMapper;
    @Autowired
    public DeviceService(DeviceMapper deviceMapper) {
        this.deviceMapper = deviceMapper;
    }
    public DeviceDto addDevice(DeviceDto deviceDto) {
        Device device = deviceMapper.toDevice(deviceDto);
        device.setCreationTime(LocalDateTime.now());
        return deviceMapper.toDeviceDto(deviceRepository.save(device));
    }

    public DeviceDto getDeviceById(Long id) {
        return deviceRepository.findById(id)
                .map(deviceMapper::toDeviceDto)
                .orElseThrow(() -> new EntityNotFoundException("Device not found"));
    }

    public List<DeviceDto> listAllDevices() {
        return deviceRepository.findAll().stream()
                .map(deviceMapper::toDeviceDto)
                .collect(Collectors.toList());
    }

    public DeviceDto updateDevice(Long id, DeviceDto deviceDto) {
        Device existingDevice = deviceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Device not found"));
        existingDevice.setName(deviceDto.getName());
        existingDevice.setBrand(deviceDto.getBrand());
        return deviceMapper.toDeviceDto(deviceRepository.save(existingDevice));
    }

    public DeviceDto partialUpdateDevice(Long id, DeviceDto deviceDto) {
        Device existingDevice = deviceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Device not found"));
        if (deviceDto.getName() != null) {
            existingDevice.setName(deviceDto.getName());
        }
        if (deviceDto.getBrand() != null) {
            existingDevice.setBrand(deviceDto.getBrand());
        }
        return deviceMapper.toDeviceDto(deviceRepository.save(existingDevice));
    }

    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }

    public List<DeviceDto> searchDeviceByBrand(String brand) {
        return deviceRepository.findByBrand(brand).stream()
                .map(deviceMapper::toDeviceDto)
                .collect(Collectors.toList());
    }

    public Page<DeviceDto> listAllDevicesPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return deviceRepository.findAll(pageable)
                .map(deviceMapper::toDeviceDto);
    }
}

