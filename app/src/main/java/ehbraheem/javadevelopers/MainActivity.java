package ehbraheem.javadevelopers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private DevelopersAdapter mDeveloperAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.developerList);

        if (mListView != null) {
            mListView.setAdapter(mDeveloperAdapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
