package com.example.mytestwork;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    public TextView text_json;
    public ImageView imageView ;

    class QueryTask extends AsyncTask<URL, Void, String>{

        @Override
        protected String doInBackground(URL... urls) {
            String responce = null;
            try {
                responce = getResponseFromURL(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return responce;
        }

        @Override
        protected void onPostExecute(String responce){
            text_json.setText(responce);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // ButterKnife.bind(this);

        text_json= findViewById(R.id.text_json);
        //URL url_employee = GenerateURL();
       // new QueryTask().execute(url_employee);

        new ProgressTask().execute("https://gitlab.65apps.com/65gb/static/raw/master/testTask.json");
    }

    public static URL  GenerateURL(){
        Uri uri = Uri.parse("http://gitlab.65apps.com/65gb/static/raw/master/testTask.json").buildUpon().build();
        URL url = null;

        try {
            url = new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

    public static String getResponseFromURL(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
       // urlConnection.getResponseCode();
        try {
            InputStream in = urlConnection.getInputStream();


            Scanner scanner = new Scanner(in);

            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();

            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        }

        finally {
            urlConnection.disconnect();
        }

    }




    private class ProgressTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... path) {

            String content;
            try {
                content = getContent(path[0]);
            } catch (IOException ex) {
                content = ex.getMessage();
            }

            return content;
        }

        @Override
        protected void onPostExecute(String content) {
            //text_json.setText(content);
            String f_name = null;
            String l_name = null;
            String birthday = null;
            String avatr_url = null;
            String specialty_id = null;
            String name = null;
            String outputBirth = null;


            try {
                JSONObject jsonObject = new JSONObject(content);
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                JSONObject employee = jsonArray.getJSONObject(0);

                JSONArray jsonArraySpecialty = employee.getJSONArray("specialty");
                JSONObject specialty = jsonArraySpecialty.getJSONObject(0);
                f_name = convert(employee.getString("f_name"));
                l_name = convert(employee.getString("l_name"));
                birthday = employee.getString("birthday");
                avatr_url = employee.getString("avatr_url");
                specialty_id = specialty.getString("specialty_id");
                name = specialty.getString("name");

                if (birthday.equals(""))
                {
                    outputBirth = "-";
                }
                else {
                    DateFormat inputFormat = new SimpleDateFormat("yyyy-mm-dd");
                    DateFormat outputFormat = new SimpleDateFormat("dd.MM.yyyy");
                    Date date = inputFormat.parse(birthday);
                    outputBirth = outputFormat.format(date);
                }

                int k = 1;
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }


            imageView = findViewById(R.id.image);
            Picasso.get().load(avatr_url).into(imageView);

            String result = "Имя: " + f_name + "\n" + "Фамилия: " + l_name + "\n" + "День рождения: " + outputBirth + "\n" + "Должность: " + name;
            text_json.setText(result);

        }
     /*   @Override
        protected void onPostExecute(String content) {

            contentText=content;
            contentView.setText(content);
            webView.loadData(content, "text/html; charset=utf-8", "utf-8");
            Toast.makeText(getActivity(), "Данные загружены", Toast.LENGTH_SHORT)
                    .show();
        }*/

     private String convert(String in) {
         String upper_case_line = in.substring(0, 1).toUpperCase() + in.substring(1).toLowerCase();
         return upper_case_line;
     }

        private String getContent(String path) throws IOException {
            BufferedReader reader = null;
            try {
                URL url = new URL(path);
                HttpsURLConnection c = (HttpsURLConnection) url.openConnection();
                c.setRequestMethod("GET");
                c.setReadTimeout(10000);
                c.connect();
                reader = new BufferedReader(new InputStreamReader(c.getInputStream()));
                StringBuilder buf = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    buf.append(line + "\n");
                }
                return (buf.toString());
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        }
    }
}
