package by.epamtc.degtyarovea.service;

import by.epamtc.degtyarovea.dao.*;
import by.epamtc.degtyarovea.entity.Criteria;
import by.epamtc.degtyarovea.entity.Device;

import java.util.ArrayList;
import java.util.List;

public class FindService {

    public List<Device> find(Criteria criteria) {
        String product = criteria.getProduct();
        DeviceDAO dao = null;

        switch (product) {
            case "Oven":
                dao = new OvenDAO();
                break;
            case "Laptop":
                dao = new LaptopDAO();
                break;
            case "Refrigerator":
                dao = new RefrigeratorDAO();
                break;
            case "VacuumCleaner":
                dao = new VacuumCleanerDAO();
                break;
            case "TabletPC":
                dao = new TabletPCDAO();
                break;
            case "Speakers":
                dao = new SpeakersDAO();
                break;
        }

        return (dao != null) ? dao.find(criteria) : new ArrayList<>();
    }


}
