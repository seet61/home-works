package com.sbt.javaschool.homeworks.serialization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;

import java.io.*;

public class CumbersomePointSerialize {
    @Test
    public void serialize() {
        String filename = "point.ser";

        ConvenientPoint convenientPoint = new ConvenientPoint("Test", 1, 2);
        try(FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(convenientPoint);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deserialize() {
        String filename = "point.ser";

        ConvenientPoint convenientPoint = null;
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
