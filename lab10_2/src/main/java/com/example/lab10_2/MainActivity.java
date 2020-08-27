package com.example.lab10_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<DriveVo> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab10_2);
        ListView listView = findViewById(R.id.custom_listview);
        this.jsonParsing(getJsonString());

        DriveAdapter adapter = new DriveAdapter(this, R.layout.custom_item, datas);
        listView.setAdapter(adapter);
    }


    private String getJsonString()
    {
        String json = "";

        try {
            InputStream is = getAssets().open("drive.json");
            int fileSize = is.available();

            byte[] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return json;
    }

    private void jsonParsing(String json)
    {
        try{
            JSONObject jsonObject = new JSONObject(json);

            JSONArray driveArray = jsonObject.getJSONArray("drives");

            for(int i=0; i<driveArray.length(); i++)
            {
                JSONObject movieObject = driveArray.getJSONObject(i);

                DriveVo driveVo = new DriveVo();
                driveVo.type = (movieObject.getString("type"));
                driveVo.title = (movieObject.getString("title"));
                driveVo.date = (movieObject.getString("date"));

                datas.add(driveVo);
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
