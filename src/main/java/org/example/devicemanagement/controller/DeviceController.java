package org.example.devicemanagement.controller;

import org.example.devicemanagement.dto.DeviceDto;
import org.example.devicemanagement.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @PostMapping
    public ResponseEntity<DeviceDto> addDevice(@RequestBody DeviceDto deviceDto) {
        return ResponseEntity.ok(deviceService.addDevice(deviceDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeviceDto> getDeviceById(@PathVariable Long id) {
        return ResponseEntity.ok(deviceService.getDeviceById(id));
    }

    @GetMapping
    public ResponseEntity<List<DeviceDto>> listAllDevices() {
        return ResponseEntity.ok(deviceService.listAllDevices());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceDto> updateDevice(@PathVariable Long id, @RequestBody DeviceDto deviceDto) {
        return ResponseEntity.ok(deviceService.updateDevice(id, deviceDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DeviceDto> partialUpdateDevice(@PathVariable Long id, @RequestBody DeviceDto deviceDto) {
        return ResponseEntity.ok(deviceService.partialUpdateDevice(id, deviceDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<DeviceDto>> searchDeviceByBrand(@RequestParam String brand) {
        return ResponseEntity.ok(deviceService.searchDeviceByBrand(brand));
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<DeviceDto>> listAllDevicesPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(deviceService.listAllDevicesPaginated(page, size));
    }
}