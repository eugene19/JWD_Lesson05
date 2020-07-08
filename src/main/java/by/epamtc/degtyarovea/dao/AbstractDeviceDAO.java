package by.epamtc.degtyarovea.dao;

import by.epamtc.degtyarovea.entity.Criteria;
import by.epamtc.degtyarovea.entity.Device;
import by.epamtc.degtyarovea.service.FindService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDeviceDAO {

    public List<Device> find(Criteria criteria) {
        List<Device> devices = new ArrayList<>();
        String deviceLineRegex = generateDeviceLineRegex(criteria);

        try (BufferedReader reader = new BufferedReader(new FileReader(FindService.DEVICES_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches(deviceLineRegex)) {
                    Device device = createDeviceFromString(line);
                    devices.add(device);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return devices;
    }

    private String generateDeviceLineRegex(Criteria criteria) {
        String productType = criteria.getProductType();
        String attribute = criteria.getAttribute();
        String value = criteria.getValue().replace(".", "\\.");

        return productType + ".+" + attribute + "=" + value + ".*";
    }

    public abstract Device createDeviceFromString(String line);
}
