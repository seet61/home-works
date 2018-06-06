package com.sbt.javaschool.homeworks.serialization;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String filename = "point.ser";

        //serialization
        ConvenientPoint convenientPoint = new ConvenientPoint("Test", 1, 2);
        try(FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(convenientPoint);
            System.out.println(convenientPoint.toString());
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

        //deserialization
        convenientPoint = null;
        try(FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream oos = new ObjectInputStream(fis)) {
            convenientPoint = (ConvenientPoint) oos.readObject();
            System.out.println(convenientPoint.toString());
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
