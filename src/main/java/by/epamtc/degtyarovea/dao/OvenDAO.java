package by.epamtc.degtyarovea.dao;

import by.epamtc.degtyarovea.entity.Criteria;
import by.epamtc.degtyarovea.entity.Device;
import by.epamtc.degtyarovea.entity.Oven;
import by.epamtc.degtyarovea.parsers.DeviceParser;
import by.epamtc.degtyarovea.service.FindService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OvenDAO implements DeviceDAO {

    @Override
    public List<Device> find(Criteria criteria) {
        String attribute = criteria.getAttribute();
        String value = criteria.getValue().replace(".", "\\.");

        String ovenRegex = "Oven.+" + attribute + "=" + value + ".*";

        return findMatch(ovenRegex);
    }

    private List<Device> findMatch(String regex) {
        List<Device> devices = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FindService.DEVICES_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches(regex)) {
                    Oven oven = DeviceParser.parseOven(line);
                    devices.add(oven);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return devices;
    }
}
