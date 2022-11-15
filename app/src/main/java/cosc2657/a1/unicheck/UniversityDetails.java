package cosc2657.a1.unicheck;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import cosc2657.a1.unicheck.model.University;

public class UniversityDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_details);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        University university = (University) getIntent().getSerializableExtra("University");
//        System.out.println(university);
        TextView titleView = (TextView) findViewById(R.id.universityFullName);
        TextView descriptionView = (TextView) findViewById(R.id.universityDescription);
        Button linkButton = (Button) findViewById(R.id.link_button);
        linkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(university.getLink()));
                startActivity(intent);
            }
        });

        titleView.setText(university.getName());
        descriptionView.setText(university.getDescription());

    }
}