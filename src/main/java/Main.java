import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, JSONException {
        System.out.println("Задание 1");
        Task1_FileRoot task1 = new Task1_FileRoot();
        task1.viewDrives();
//        task1.viewAllDevices(); //Для Linux

        System.out.println("-----");
        System.out.println("Задание 2");
        Task2_Files task2 = new Task2_Files("newFile.txt");
        Scanner in = new Scanner(System.in);
        System.out.print("Вводите текст: ");
        task2.writeToFile(in.nextLine());
        System.out.println("Полученные данные из файла: "+task2.readFile());
        task2.deleteFile();
        System.out.println("Файл удален");

        System.out.println("-----");
        System.out.println("Задание 3");
        //Подготовка
        Task3_Json task3 = new Task3_Json();
        List<Map<String, String>> persons = getPersons(2);

        //Создание json файла
        JSONArray json = task3.createJSONFromMap(persons);
        Task2_Files file = new Task2_Files("task3.json");
        file.writeToFile(json.toString());

        //Вывод данных из файла
        Task2_Files fileIn = new Task2_Files("task3.json");
        System.out.println(fileIn.readFile());
        fileIn.deleteFile();

        System.out.println("-----");
        System.out.println("Задание 4");

        //Подготовка
        Task4_XML task4 = new Task4_XML();
        List<XmlMap> addList = getXmlMaps(2);

        //Создание файла
        String[] toAdd = task4.createXmlData(addList);
        Task2_Files outFile = new Task2_Files("newXml.xml");
        List<String> fileList = outFile.readFileToList();
        for (String s : toAdd) fileList.add(s);
        outFile.writeToFile(fileList);

        System.out.println("-----");
        System.out.println("Задание 5");

        //Создание архива
        Task5_Zip task5 = new Task5_Zip();
        task5.createZipArchive("newXml.xml");

        //Распаковка архива
        System.out.println(task5.unzipFile("newXml.xml.zip"));
    }

    private static List<XmlMap> getXmlMaps(final int count) {
        List<XmlMap> addList = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < count; i++) {
            XmlMap line = new XmlMap();
            System.out.println("Введите тег");
            String key = in.nextLine();
            System.out.println("Введите значение");
            String value = in.nextLine();
            line.property = key;
            line.value = value;
            addList.add(line);
        }
        return addList;
    }

    private static ArrayList<Map<String, String>> getPersons(final int count) {
        Scanner in = new Scanner(System.in);
        ArrayList<Map<String, String>> persons = new ArrayList<>();
        String[] questions = {"имя", "фамилию", "возраст"};
        String[] questionsForJson = {"Имя", "Фамилия", "Возраст"};

        for (int i = 0; i < count; i++) {
            Map<String, String> personInfo = new HashMap<>();
            for (int j = 0; j < questions.length; j++) {
                String question = questions[j];
                System.out.println("Введите " + question + ": ");
                String answer = in.nextLine();

                personInfo.put(questionsForJson[j], answer);
            }
            persons.add(personInfo);
            if (i != 1)
                System.out.println("\nСледующий...");
        }
        return persons;
    }

}
