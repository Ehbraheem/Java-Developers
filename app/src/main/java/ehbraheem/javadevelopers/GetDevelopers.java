package ehbraheem.javadevelopers;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by AppsWorkforce2 on 15/03/2017.
 */

public class GetDevelopers extends AsyncTask<String, Void, DevelopersAdapter> {


    private Context mContext;
    private ListView mListView;

    public GetDevelopers(Context context, ListView listView) {
        this.mContext = context;
        this.mListView = listView;
    }

    @Override
    protected DevelopersAdapter doInBackground(String... params) {

        DevelopersAdapter developersAdapter = null;

        try {
            URL url = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();


            InputStream stream = new BufferedInputStream(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));

            StringBuilder builder = new StringBuilder();
            String inputString;

            while ((inputString = bufferedReader.readLine()) != null) {
                builder.append(inputString);
            }

            Developer[] developerArray = new DeveloperParser(builder).parse();
            developersAdapter = new DevelopersAdapter(this.mContext, R.layout.row, developerArray);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("doInBackground", e.getMessage());
        }
        return developersAdapter;

    }

    @Override
    protected void onPostExecute(DevelopersAdapter developersAdapter) {

        if (mListView != null) {
            mListView.setAdapter(developersAdapter);
        }
    }
}