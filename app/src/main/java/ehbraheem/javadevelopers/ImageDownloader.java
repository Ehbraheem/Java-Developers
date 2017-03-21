package ehbraheem.javadevelopers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Ehbraheem on 16/03/2017.
 */

public class ImageDownloader extends AsyncTask<String,Void, Bitmap> {

    private ProgressBar mProgressBar;
    private ImageView mImageView;

    public ImageDownloader(ProgressBar progressBar, ImageView imageView) {
        this.mProgressBar = progressBar;
        this.mImageView = imageView;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        mProgressBar.setVisibility(View.GONE);
        mImageView.setImageBitmap(bitmap);
    }

    @Override
    protected void onPreExecute() {
        mProgressBar.setVisibility(View.VISIBLE);
        super.onPreExecute();
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        Bitmap avatar = null;
        try {
            URL imageUrl = new URL(params[0]);
            HttpURLConnection connection = (HttpURLConnection) imageUrl.openConnection();
            avatar = BitmapFactory.decodeStream(connection.getInputStream());
            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return avatar;
    }


}
