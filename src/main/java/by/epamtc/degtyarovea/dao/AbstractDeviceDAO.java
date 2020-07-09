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

    /**
     * Factory method to create DAO by device type.
     *
     * @param deviceType - type of device.
     * @return concrete device DAO.
     */
    public static AbstractDeviceDAO getDeviceDAO(String deviceType) {
        switch (deviceType) {
            case "Oven":
                return new OvenDAO();
            case "Laptop":
                return new LaptopDAO();
            case "Refrigerator":
                return new RefrigeratorDAO();
            case "VacuumCleaner":
                return new VacuumCleanerDAO();
            case "TabletPC":
                return new TabletPCDAO();
            case "Speakers":
                return new SpeakersDAO();
            default:
                throw new IllegalArgumentException("No such product type.");
        }
    }

    /**
     * @param criteria - criteria of search.
     * @return List of devices match searching criteria.
     */
    public List<Device> find(Criteria criteria) {
        List<Device> devices = new ArrayList<>();
        String deviceLineRegex = generateDeviceLineRegex(criteria);

        try (BufferedReader reader = new BufferedReader(new FileReader(FindService.DEVICES_FILE_PATH))) {
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

    /**
     * @param criteria - criteria of search.
     * @return regex string for searching device.
     */
    private String generateDeviceLineRegex(Criteria criteria) {
        String productType = criteria.getDeviceType();
        String attribute = criteria.getAttribute();
        String value = criteria.getValue().replace(".", "\\.");

        return productType + ".+" + attribute + "=" + value + ".*";
    }

    /**
     * @param line - string with device.
     * @return Device object.
     */
    public abstract Device createDeviceFromString(String line);
}
