package ehbraheem.javadevelopers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by AppsWorkforce2 on 16/03/2017.
 */

public class ImageDownloader extends AsyncTask<String,Void, Bitmap> {

    private ImageView imageView;

    public ImageDownloader(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        this.imageView.setImageBitmap(bitmap);
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
