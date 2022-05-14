import java.io.*;
import java.util.Objects;
import java.util.stream.Collectors;

public class Task1_FileRoot {
    public void viewDrives() {
        File[] roots = File.listRoots();
        for (File root : roots) {
            long totalSpace = root.getTotalSpace() / (1024 * 1024 * 1024);
            long freeSpace = root.getFreeSpace() / (1024 * 1024 * 1024);
            float percentFree = (float) freeSpace / totalSpace * 100;
            int filesCount = Objects.requireNonNull(root.listFiles()).length;

            System.out.println("Имя: " + root.getName());
            System.out.println("Путь: " + root.getAbsolutePath());

            System.out.println("Размер: " + totalSpace + " GB");
            System.out.println("Свободное место: " + freeSpace + " GB");
            System.out.println("Свободное место в процентах: " + percentFree + " %");
            System.out.println("Количество файлов на диске: " + filesCount);

            System.out.println("---\n");
        }
    }

    public void viewAllDevices() throws IOException, InterruptedException {
        /* for Linux */
        Process process = Runtime.getRuntime().exec("df -h");
        process.waitFor();

        InputStream is = process.getInputStream();

        String result
                = new BufferedReader(new InputStreamReader(is))
                .lines()
                .collect(Collectors.joining("\n"));
        System.out.println(result);
    }
}
