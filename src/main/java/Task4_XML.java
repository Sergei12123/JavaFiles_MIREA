import java.util.List;

public class Task4_XML {
    public String[] createXmlData(List<XmlMap> data) {
        String[] result = new String[data.size()];
        for (int i = 0; i < data.size(); i++) {
            result[i] = "  <" +
                    data.get(i).property +
                    ">" + data.get(i).value +
                    "</" + data.get(i).property +
                    ">";
        }
        return result;
    }
}
