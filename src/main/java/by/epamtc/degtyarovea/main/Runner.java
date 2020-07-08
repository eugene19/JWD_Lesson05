package by.epamtc.degtyarovea.main;

import by.epamtc.degtyarovea.entity.Criteria;
import by.epamtc.degtyarovea.entity.Device;
import by.epamtc.degtyarovea.service.FindService;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        String productType = "TabletPC";
        String attribute = "";
        String value = "";

        Criteria criteria = new Criteria(productType, attribute, value);
        FindService findService = new FindService();

        List<Device> devices = findService.find(criteria);

        for (Device device : devices) {
            System.out.println(device);
        }
    }
}
