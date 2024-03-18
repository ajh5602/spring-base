package com.taylor.project.base.common.constant.converter;

import com.taylor.project.base.common.constant.enumtype.Device;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Objects;
import java.util.stream.Stream;
import org.springframework.util.StringUtils;

@Converter(autoApply = true)
public class DeviceConverter implements AttributeConverter<Device, String> {

    @Override
    public String convertToDatabaseColumn(Device device) {
        if (Objects.isNull(device)) {
            return null;
        }
        return device.getValue();
    }

    @Override
    public Device convertToEntityAttribute(String value) {
        if (!StringUtils.hasText(value)) {
            return null;
        }

        return Stream.of(Device.values())
            .filter(device -> device.getValue().equals(value))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }

}
