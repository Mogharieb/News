package mg.news;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Jsonparser {
    ArrayList<Datacaps> data;

    public ArrayList<Datacaps> JsonProcess(String jsonFile) {

        data = new ArrayList<>();

        try {

            JSONObject mainObject = new JSONObject(jsonFile);

            JSONArray jsonArray = mainObject.getJSONArray("articles");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject mainObjectArray = jsonArray.getJSONObject(i);

                Datacaps encap = new Datacaps(mainObjectArray.getString(Keytages.titlekey),
                        mainObjectArray.getString(Keytages.deskey), mainObjectArray.getString(Keytages.urlkey), mainObjectArray.getString(Keytages.imagekey),mainObjectArray.getString(Keytages.datekey));

                data.add(encap);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }

    public ArrayList<Datacaps> getlist()
    {
        return data;
    }
}
