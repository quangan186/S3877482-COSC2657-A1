package cosc2657.a1.unicheck.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import cosc2657.a1.unicheck.R;

public class Home extends AppCompatActivity {
    private final static String INTERNAL_PATH = Environment.getDataDirectory().getPath() + "/data/cosc2657.a1.unicheck/";
    private final static String USERNAME_FILE = "user.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        TextView usernameView = (TextView) findViewById(R.id.username);
        usernameView.setText("Hello " + showUsername()); // display input's name from internal storage

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav);

        // set onClick for the bottom navigation bar items
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.list:
                        Intent intent = new Intent(Home.this, UniversityList.class);
                        startActivity(intent);
                        return true;
                    case R.id.home:
                        return false;
                }
                return true;
            }
        });
    }

    // show the input name
    private String showUsername(){
        String data = getData();
        if (data.isEmpty()){
            return null;
        }
        String[] usernames = data.split("\n");
        return usernames[usernames.length - 1].split(":")[1];
    }

    // get the input's name from internal storage
    private String getData(){
        String path = INTERNAL_PATH + USERNAME_FILE;
        File file = new File(path);
        if (!file.exists()){
            Toast.makeText(this, "No directory found!", Toast.LENGTH_SHORT).show();
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            String data = "";
            int length;
            byte[] buff = new byte[1024];
            while ((length = fileInputStream.read(buff)) > 0){
                data += new String(buff, 0, length);
            }
            fileInputStream.close();
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}