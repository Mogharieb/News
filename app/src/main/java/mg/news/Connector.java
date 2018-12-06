package mg.news;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;

public class Connector extends AsyncTask<String,String,String> {

    HttpURLConnection URLConnection = null;
    BufferedReader Reader = null;
    String data;

    @Override
    protected String doInBackground(String... params) {
        try {
            StringBuffer buffer = new StringBuffer();
            URL url = new URL(params[0]);
            URLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream =new BufferedInputStream(URLConnection.getInputStream());
            Reader=new BufferedReader(new InputStreamReader(inputStream));
            String line =" ";
            while ((line=Reader.readLine())!=null)
            {
                 buffer.append(line+"\n");
            }
            data=buffer.toString();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return data;
    }
}
