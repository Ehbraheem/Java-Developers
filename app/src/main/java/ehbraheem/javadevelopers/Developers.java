package ehbraheem.javadevelopers;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

public class Developers extends AppCompatActivity {

    private ListView mListView;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mListView = (ListView) findViewById(R.id.developerList);

        mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);

        String language = "Java";
        String location = "Lagos";
        String access_token = "6908229a5a07571742d7dce1c1feb66cda986ae3";

        String url = String.format("https://api.github.com/search/users?access_token=%s&q=language:%s+location:%s", access_token,language,location);
        AsyncTask.Status go = new GetDevelopers(getApplicationContext(), mListView, mProgressBar).execute(url).getStatus();
        Log.i("Async Task", go.name());

    }

}
