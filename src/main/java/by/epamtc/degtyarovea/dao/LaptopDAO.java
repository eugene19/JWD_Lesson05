package by.epamtc.degtyarovea.dao;

import by.epamtc.degtyarovea.entity.Criteria;
import by.epamtc.degtyarovea.entity.Device;
import by.epamtc.degtyarovea.entity.Laptop;
import by.epamtc.degtyarovea.parsers.DeviceParser;
import by.epamtc.degtyarovea.service.FindService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LaptopDAO implements DeviceDAO {

    @Override
    public List<Device> find(Criteria criteria) {
        String attribute = criteria.getAttribute();
        String value = criteria.getValue().replace(".", "\\.");

        String laptopRegex = "Laptop.+" + attribute + "=" + value + ".*";

        return findMatch(laptopRegex);
    }

    private List<Device> findMatch(String regex) {
        List<Device> devices = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FindService.DEVICES_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches(regex)) {
                    Laptop laptop = DeviceParser.parseLaptop(line);
                    devices.add(laptop);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return devices;
    }
}
