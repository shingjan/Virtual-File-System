package hk.edu.polyu.comp3222.vfs.client;
import hk.edu.polyu.comp3222.vfs.core.VisualDisk;
//import hk.edu.polyu.comp3222.vfs.core.fileSystem;

import java.io.*;

/**
 * Created by Isaac on 2/16/17.
 */
public class SerializationController {
    private static SerializationController instance;

    private static final String fsSerializedName = "JFileSystem.vfs";

    public static SerializationController getInstance() {
        if (instance == null)
            instance = new SerializationController();
        return instance;
    }

    public void serialize(VisualDisk fileSystem) {
        try {
            FileOutputStream fos;
            ObjectOutputStream oos = null;
            try {
                fos = new FileOutputStream(fsSerializedName);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(fileSystem);
            } finally {
                if (oos != null)
                    oos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public VisualDisk deserialize() {
        try {
            FileInputStream fis;
            ObjectInputStream ois = null;

            File file = new File(fsSerializedName);
            if (!file.exists() || !file.isFile())
                return null;

            try {
                fis = new FileInputStream(fsSerializedName);
                ois = new ObjectInputStream(fis);
                return (VisualDisk) ois.readObject();
            } finally {
                if (ois != null)
                    ois.close();
            }
        } catch (InvalidClassException ignored) {
            System.out.println("\nERROR: Your .vfs backup is outdated! " +
                    "Please, delete it before launch the program!");
            System.exit(0);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
