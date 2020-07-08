package by.epamtc.degtyarovea.service;

import by.epamtc.degtyarovea.dao.*;
import by.epamtc.degtyarovea.entity.Criteria;
import by.epamtc.degtyarovea.entity.Device;
import by.epamtc.degtyarovea.validator.CriteriaValidator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindService {

    public static final String DEVICES_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "appliances_db.txt";
    private CriteriaValidator criteriaValidator = new CriteriaValidator();

    public List<Device> find(Criteria criteria) {
        String productType = criteria.getProductType();
        DeviceDAO dao = null;

        if (criteriaValidator.isValid(criteria)) {
            switch (productType) {
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
        }

        return (dao != null) ? dao.find(criteria) : new ArrayList<>();
    }
}
