package by.epamtc.degtyarovea.dao;

import by.epamtc.degtyarovea.entity.Device;
import by.epamtc.degtyarovea.parsers.DeviceParser;

public class SpeakersDAO extends AbstractDeviceDAO {

    @Override
    public Device createDeviceFromString(String line) {
        return DeviceParser.parseSpeakers(line);
    }
}
