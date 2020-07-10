package by.epamtc.degtyarovea.dao;

import by.epamtc.degtyarovea.entity.Criteria;
import by.epamtc.degtyarovea.entity.Device;
import by.epamtc.degtyarovea.service.DeviceFileReader;
import by.epamtc.degtyarovea.service.FindService;
import by.epamtc.degtyarovea.service.NoSuchDeviceTypeException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDeviceDAO {

    /**
     * Factory method to create DAO by device type.
     *
     * @param deviceType - type of device.
     * @return concrete device DAO.
     * @throws NoSuchDeviceTypeException when there isn't such device type.
     */
    public static AbstractDeviceDAO getDeviceDAO(String deviceType) throws NoSuchDeviceTypeException {
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
                throw new NoSuchDeviceTypeException("No such device type: " + deviceType);
        }
    }

    /**
     * @param criteria - criteria of search.
     * @return List of devices match searching criteria.
     */
    public List<Device> find(Criteria criteria) throws IOException {
        List<Device> devices = new ArrayList<>();
        DeviceFileReader reader = new DeviceFileReader(new File(FindService.DEVICES_FILE_PATH));

        String deviceLineRegex = generateDeviceLineRegex(criteria);
        List<String> deviceLines = reader.readMatchesLine(deviceLineRegex);

        for (String deviceLine : deviceLines) {
            devices.add(createDeviceFromString(deviceLine));
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
