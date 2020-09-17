package com.health.metrics.api;

import com.health.metrics.dto.MobileDeviceDTO;
import com.health.metrics.entity.MobileDevice;
import com.health.metrics.mapper.MobileDeviceMapper;
import com.health.metrics.service.MobileDeviceService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ravibeli
 * @project accessing-data-rest
 * @created on 11 Sep, 2020 5:47 PM
 **/

@Slf4j
@RestController
@RequestMapping(value = "/mobile")
public class MobileDeviceController {


    @Autowired
    MobileDeviceService mobileDeviceService;

    @RequestMapping(value="/{mobileNumber}", params = "mobileNumber")
    public ResponseEntity<MobileDeviceDTO> getDevice(@RequestParam("mobileNumber") Integer mobileNumber) {
        MobileDevice mobileDevice = mobileDeviceService.getDeviceByMobileNumber(mobileNumber);
        MobileDeviceDTO mobileDeviceDTO =  Mappers.getMapper(MobileDeviceMapper.class).toMobileDeviceDTO(mobileDevice);
        if (mobileDeviceDTO != null) {
            return new ResponseEntity<>(mobileDeviceDTO, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @RequestMapping
    public ResponseEntity<List<MobileDeviceDTO>> getDevices() {
        List<MobileDeviceDTO> mobileDeviceDTOList = mobileDeviceService.getDevices();
        return new ResponseEntity<>(mobileDeviceDTOList, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MobileDeviceDTO> createMobileDevice(@RequestBody
                                                                  MobileDeviceDTO mobileDeviceDTO) {
        log.info("In MobileDeviceController.createMobileDevice({})", mobileDeviceDTO);
        MobileDeviceDTO mobileDevice = mobileDeviceService.createMobileDevice(mobileDeviceDTO);
        if (mobileDevice != null) {
            return new ResponseEntity<>(mobileDevice, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
