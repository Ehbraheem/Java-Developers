package ehbraheem.javadevelopers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

/**
 * Created by Ehbraheem on 15/03/2017.
 */

//TODO: Resolve constructor
public class DevelopersAdapter extends ArrayAdapter<Developer> {

    Context mContext;
    int mLayoutResourceId;
    Developer mData[] = null;

    public DevelopersAdapter(Context context, int resource, Developer[] data) {
        super(context, resource, data);

        this.mContext = context;
        this.mData = data;
        this.mLayoutResourceId = resource;
    }

    @Override
    public Developer getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {


        View row = convertView;


        LayoutInflater inflater = LayoutInflater.from(mContext);
        row = inflater.inflate(mLayoutResourceId, parent, false);

        TextView nameView = (TextView) row.findViewById(R.id.developerName);
        ImageView imageView = (ImageView) row.findViewById(R.id.developerImage);

        Developer developer = mData[position];

        nameView.setText(developer.name);


        ProgressBar progressBar = (ProgressBar) row.findViewById(R.id.imageLoading);
        ImageDownloader imageDownloader = new ImageDownloader(progressBar, imageView);

        imageDownloader.execute(developer.avatar);


//            holder  = new PlaceHolder();
//
//            holder.nameView = (TextView) row.findViewById(R.id.developerName);
//            holder.imageView = (ImageView) row.findViewById(R.id.developerImage);
//            holder.


        return row;


    }


    private static class PlaceHolder {

        TextView nameView;
        ImageView imageView;
        TextView urlTextView;
        ProgressBar progressBar;
    }
}
