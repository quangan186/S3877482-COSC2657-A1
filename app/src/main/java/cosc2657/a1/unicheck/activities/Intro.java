package cosc2657.a1.unicheck.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cosc2657.a1.unicheck.R;

public class Intro extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        EditText name = (EditText) findViewById(R.id.input_name);

        Button startButton = (Button) findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (!name.getText().toString().isEmpty()){
                        Intent intent = new Intent(Intro.this, Home.class);
                        intent.putExtra("Username", name.getText().toString());
                        startActivity(intent);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }
}