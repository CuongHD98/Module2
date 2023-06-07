package ID9282;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderWriterFile {
    public List<String> readFile(String filePath) {
        List<String> strings = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                strings.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File does not exit or content file error!");
        }
        return strings;
    }

    public void writeFile(String filePath, List<String> strings) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (String str : strings) {
                bufferedWriter.write(str + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ReaderWriterFile readerWriterFile = new ReaderWriterFile();
        List<String> strings = readerWriterFile.readFile("C:\\Users\\HDC\\Desktop\\Module2\\Day16\\src\\ID9282\\file.txt");
        readerWriterFile.writeFile("C:\\Users\\HDC\\Desktop\\Module2\\Day16\\src\\ID9282\\fileCopy.txt", strings);
    }

}
