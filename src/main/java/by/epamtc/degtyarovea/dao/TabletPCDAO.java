package by.epamtc.degtyarovea.dao;

import by.epamtc.degtyarovea.entity.Criteria;
import by.epamtc.degtyarovea.entity.Device;
import by.epamtc.degtyarovea.entity.Speakers;
import by.epamtc.degtyarovea.entity.TabletPC;
import by.epamtc.degtyarovea.parsers.DeviceParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TabletPCDAO implements DeviceDAO {

    @Override
    public List<Device> find(Criteria criteria) {
        String attribute = criteria.getAttribute();
        String value = criteria.getValue().replace(".", "\\.");

        String tabletPCRegex = "TabletPC.+" + attribute + "=" + value + ".*";

        return findMatch(tabletPCRegex);
    }

    private List<Device> findMatch(String regex) {
        List<Device> devices = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(DEVICES_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches(regex)) {
                    TabletPC tabletPC = DeviceParser.parseTabletPC(line);
                    devices.add(tabletPC);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return devices;
    }
}
