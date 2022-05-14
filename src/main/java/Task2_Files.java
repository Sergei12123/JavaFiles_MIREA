import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task2_Files {
    private final File file;

    public Task2_Files(final String fileName) throws IOException {
        file = new File(fileName);
        file.createNewFile();
    }

    public void writeToFile(final String text) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void writeToFile(final List<String> text) {
        StringBuilder toWrite = new StringBuilder();
        for (var line : text) {
            toWrite.append(line).append("\n");
        }
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(toWrite.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String readFile() {
        StringBuilder fileText = new StringBuilder();
        try (FileReader reader = new FileReader(file)) {
            int c;
            while ((c = reader.read()) != -1) {
                fileText.append((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return fileText.toString();
    }

    public List<String> readFileToList() {
        List<String> fileText = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                fileText.add(line);
                line = reader.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return fileText;
    }

    public boolean deleteFile() {
        return file.delete();
    }
}
