package org.hbrs.se1.ws24.uebung4;

import java.io.*;
import java.util.List;

public class PersistenceStrategyStream<T> {
    public void save(List<T> items, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(items);
        }
    }

    public List<T> load(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (List<T>) ois.readObject();
        }
    }
}
