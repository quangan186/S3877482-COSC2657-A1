package cosc2657.a1.unicheck.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import cosc2657.a1.unicheck.R;

public class Intro extends AppCompatActivity {
    private EditText nameEditText;
    private final static String INTERNAL_PATH = Environment.getDataDirectory().getPath() + "/data/cosc2657.a1.unicheck/";
    private final static String USERNAME_FILE = "user.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);

        // hide the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        nameEditText = (EditText) findViewById(R.id.input_name);

        Button startButton = (Button) findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // If the input is not empty, the app will direct to the Home activity
                    if (!nameEditText.getText().toString().isEmpty()){
                        Intent intent = new Intent(Intro.this, Home.class);
                        saveData();
                        startActivity(intent);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    // save the input name to internal storage
    private void saveData(){
        try {
            String path = INTERNAL_PATH + USERNAME_FILE;
            File file = new File(path);
            if (!file.exists()){
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            String data = "Username" + ":" + nameEditText.getText().toString() + "\n";
            byte[] buff = data.getBytes();
            fileOutputStream.write(buff, 0, buff.length);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
        }
    }
}