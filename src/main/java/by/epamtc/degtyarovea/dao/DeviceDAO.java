package by.epamtc.degtyarovea.dao;

import by.epamtc.degtyarovea.entity.Criteria;
import by.epamtc.degtyarovea.entity.Device;

import java.io.File;
import java.util.List;

public interface DeviceDAO {
    String DEVICES_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "appliances_db.txt";

    List<Device> find(Criteria criteria);
}
