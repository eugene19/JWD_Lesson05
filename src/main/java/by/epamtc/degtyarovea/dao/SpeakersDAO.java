package by.epamtc.degtyarovea.dao;

import by.epamtc.degtyarovea.entity.Criteria;
import by.epamtc.degtyarovea.entity.Device;
import by.epamtc.degtyarovea.entity.Speakers;
import by.epamtc.degtyarovea.parsers.DeviceParser;
import by.epamtc.degtyarovea.service.FindService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpeakersDAO implements DeviceDAO {

    @Override
    public List<Device> find(Criteria criteria) {
        String attribute = criteria.getAttribute();
        String value = criteria.getValue().replace(".", "\\.");

        String speakersRegex = "Speakers.+" + attribute + "=" + value + ".*";

        return findMatch(speakersRegex);
    }

    private List<Device> findMatch(String regex) {
        List<Device> devices = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FindService.DEVICES_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.matches(regex)) {
                    Speakers speakers = DeviceParser.parseSpeakers(line);
                    devices.add(speakers);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return devices;
    }
}
