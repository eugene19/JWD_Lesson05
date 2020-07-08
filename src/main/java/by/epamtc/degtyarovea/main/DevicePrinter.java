package by.epamtc.degtyarovea.main;

import by.epamtc.degtyarovea.entity.Device;

import java.util.List;

public class DevicePrinter {

    public void printToConsole(List<Device> devices) {
        for (Device device : devices) {
            System.out.println(device);
        }
    }
}
