package by.epamtc.degtyarovea.service;

import by.epamtc.degtyarovea.dao.AbstractDeviceDAO;
import by.epamtc.degtyarovea.entity.Criteria;
import by.epamtc.degtyarovea.entity.Device;
import by.epamtc.degtyarovea.validator.CriteriaValidator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FindService {

    public static final String DEVICES_FILE_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "appliances_db.txt";
    private CriteriaValidator criteriaValidator = new CriteriaValidator();

    /**
     * @param criteria - criteria of search.
     * @return List of devices match searching criteria.
     * @throws NoSuchDeviceTypeException when there isn't such device type.
     */
    public List<Device> find(Criteria criteria) throws NoSuchDeviceTypeException, IOException {
        String productType = criteria.getDeviceType();
        AbstractDeviceDAO dao = null;

        if (criteriaValidator.isValid(criteria)) {
            dao = AbstractDeviceDAO.getDeviceDAO(productType);
        }

        return (dao != null) ? dao.find(criteria) : new ArrayList<>();
    }
}
