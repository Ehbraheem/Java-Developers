package ehbraheem.javadevelopers;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Ehbraheem on 15/03/2017.
 */

public class Developer {

    public String name;
    public String url;
    public String avatar;

    public Developer(JSONObject object) {
        try {
            this.name = object.getString("login");
            this.avatar = object.getString("avatar_url");
            this.url = object.getString("url");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
