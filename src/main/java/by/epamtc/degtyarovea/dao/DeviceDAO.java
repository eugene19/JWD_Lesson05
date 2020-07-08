package by.epamtc.degtyarovea.dao;

import by.epamtc.degtyarovea.entity.Criteria;
import by.epamtc.degtyarovea.entity.Device;

import java.util.List;

public interface DeviceDAO {
    List<Device> find(Criteria criteria);
}
