import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public class Task3_Json {
    public JSONArray createJSONFromMap(final List<Map<String, String>> personInfo) throws JSONException {
        JSONArray result = new JSONArray();
        int i = 1;
        for (var map : personInfo ) {
            JSONObject personData = new JSONObject();
            for (var key : map.keySet()) {
                personData.put(key, map.get(key));
            }
            JSONObject person = new JSONObject();
            person.put("Человек " + i++, personData);
            result.put(person);
        }
        return result;
    }

    public JSONArray parseJsonFromString(final String fileData) throws JSONException {
        return new JSONArray(fileData);
    }
}
