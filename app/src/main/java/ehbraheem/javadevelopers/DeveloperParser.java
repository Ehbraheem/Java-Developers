package ehbraheem.javadevelopers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ehbraheem on 15/03/2017.
 */

// TODO: Remove redundant method

public class DeveloperParser {

    private JSONObject rawResponse;
    private JSONArray developersList;

    public DeveloperParser (StringBuilder response) {
        try {
            this.rawResponse = new JSONObject(response.toString());
            this.developersList = rawResponse.getJSONArray("items");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Developer[] parse () {
        JSONArray data = this.developersList;
        Developer[] developersArray = new Developer[data.length()];

        try {
            for (int i = 0; i < data.length(); i++) {
                developersArray[i] = new Developer(data.getJSONObject(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return developersArray;
    }


    public JSONArray getDevelopersList() {
        return developersList;
    }

    public JSONObject getDeveloper(int position) {
        JSONObject developer = null;
        try {
            developer = developersList.getJSONObject(position);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return developer;
    }
}
