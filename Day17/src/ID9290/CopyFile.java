package ID9290;

import java.io.*;

public class CopyFile {
    private static final String SOURCEFILENAME = "source.dat";
    private static final String TARGETFILENAME = "target.dat";

    private static void copyFile(File sourceFile, File targetFile) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sourceFile));
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(targetFile))) {
            oos.writeObject(ois.readObject());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File sourceFile = null;
        File targetFile = null;
        try {
            sourceFile = new File(SOURCEFILENAME);
            targetFile = new File(TARGETFILENAME);
            if (!sourceFile.exists()) sourceFile.createNewFile();
            if (!targetFile.exists()) targetFile.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        copyFile(new File("product.dat"), sourceFile);
        copyFile(sourceFile, targetFile);
    }

}
