package ehbraheem.javadevelopers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

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
        PlaceHolder holder = null;

        // currently we don't have a row view to reuse
        if (row == null) {
            // Create a new row
            LayoutInflater inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(mLayoutResourceId, parent, false);

            holder  = new PlaceHolder();

            holder.nameView = (TextView) row.findViewById(R.id.developerName);
            holder.imageView = (ImageView) row.findViewById(R.id.developerImage);
            holder.urlTextView = (TextView) row.findViewById(R.id.urlView);

            row.setTag(holder);
        } else {
            // using existing view
            holder = (PlaceHolder) row.getTag();
        }

        // Get data from data array
        Developer developer = mData[position];

        // Setting the view to reflect the data we need to display
        holder.nameView.setText(developer.name);
        holder.urlTextView.setText(developer.url);

        // resolving the avatar
        try {
            URL imageUrl = new URL(developer.avatar);
            Bitmap avatar = BitmapFactory.decodeStream(imageUrl.openConnection().getInputStream());
            holder.imageView.setImageBitmap(avatar);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return row;


    }

    private static class PlaceHolder {

        TextView nameView;
        ImageView imageView;
        TextView urlTextView;
    }
}