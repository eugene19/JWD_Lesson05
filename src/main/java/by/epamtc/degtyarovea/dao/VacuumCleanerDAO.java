package by.epamtc.degtyarovea.dao;

import by.epamtc.degtyarovea.entity.Criteria;
import by.epamtc.degtyarovea.entity.Device;
import by.epamtc.degtyarovea.entity.TabletPC;
import by.epamtc.degtyarovea.entity.VacuumCleaner;
import by.epamtc.degtyarovea.parsers.DeviceParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VacuumCleanerDAO implements by.epamtc.degtyarovea.dao.DeviceDAO {

    @Override
    public List<Device> find(Criteria criteria) {
        String attribute = criteria.getAttribute();
        String value = criteria.getValue().replace(".", "\\.");

        String vacuumCleanerRegex = "VacuumCleaner.+" + attribute + "=" + value + ".*";

        return findMatch(vacuumCleanerRegex);
    }

    private List<Device> findMatch(String regex) {
        List<Device> devices = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(DEVICES_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches(regex)) {
                    VacuumCleaner vacuumCleaner = DeviceParser.parseVacuumCleaner(line);
                    devices.add(vacuumCleaner);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return devices;
    }
}
