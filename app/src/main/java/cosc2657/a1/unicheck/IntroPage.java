package cosc2657.a1.unicheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IntroPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
    public void goToHomePage(View view){
        Intent intent = new Intent(IntroPage.this, MainActivity.class);
        startActivity(intent);
    }
}