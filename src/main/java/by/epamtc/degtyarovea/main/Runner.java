package by.epamtc.degtyarovea.main;

import by.epamtc.degtyarovea.entity.Criteria;
import by.epamtc.degtyarovea.entity.Device;
import by.epamtc.degtyarovea.exception.NoSuchDeviceTypeException;
import by.epamtc.degtyarovea.service.FindService;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        String productType = "Oven";
        String attribute = "CAPACITY";
        String value = "33";

        Criteria criteria = new Criteria(productType, attribute, value);
        FindService findService = new FindService();

        try {
            List<Device> devices = findService.find(criteria);
            DevicePrinter printer = new DevicePrinter();
            printer.printToConsole(devices);
        } catch (NoSuchDeviceTypeException e) {
            System.out.println(e.getMessage());
        }
    }
}
