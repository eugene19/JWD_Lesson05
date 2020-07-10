package by.epamtc.degtyarovea.main;

import by.epamtc.degtyarovea.entity.Criteria;
import by.epamtc.degtyarovea.entity.Device;
import by.epamtc.degtyarovea.service.FindService;
import by.epamtc.degtyarovea.service.NoSuchDeviceTypeException;

import java.io.IOException;
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
        } catch (IOException e) {
            System.out.println("Error of reading file.");
        }
    }
}
