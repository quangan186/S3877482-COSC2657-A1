package cosc2657.a1.unicheck.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import cosc2657.a1.unicheck.R;
import cosc2657.a1.unicheck.adapter.ImageNotesAdapter;
import cosc2657.a1.unicheck.model.University;

public class UniversityDetails extends AppCompatActivity {
    private boolean isLiked = false;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_university_details);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        University university = (University) getIntent().getSerializableExtra("University");

        TextView acronymView = (TextView) findViewById(R.id.acronym);
        ImageView introImageView = (ImageView) findViewById(R.id.intro_image);
        TextView titleView = (TextView) findViewById(R.id.university_fullname);
        TextView descriptionView = (TextView) findViewById(R.id.university_description);
        TextView tuitionView = (TextView) findViewById(R.id.tuition_fee);
        TextView addressView = (TextView) findViewById(R.id.address) ;
        Button linkButton = (Button) findViewById(R.id.link_button);
        ListView imageNotesView = (ListView) findViewById(R.id.image_notes);

        acronymView.setText(university.getTitle());
        introImageView.setImageResource(university.getIntroImage());
        titleView.setText(university.getName());
        descriptionView.setText(university.getDescription());
        tuitionView.setText(String.format("Tuition fee annual: %,2f", university.getTuitionFee()));
        addressView.setText("Address: " + university.getAddress());
        imageNotesView.setAdapter(new ImageNotesAdapter(getApplicationContext(), university.getImageNotes()));
        getListViewSize(imageNotesView);

        linkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(university.getLink()));
                startActivity(intent);
            }
        });
    }

    public void backToPreviousPage(View view){
        finish();
    }

    public static void getListViewSize(ListView myListView) {
        ListAdapter myListAdapter=myListView.getAdapter();
        if (myListAdapter==null) {
            //do nothing return null
            return;
        }
        //set listAdapter in loop for getting final size
        int totalHeight=0;
        for (int size=0; size < myListAdapter.getCount(); size++) {
            View listItem=myListAdapter.getView(size, null, myListView);
            listItem.measure(0, 0);
            totalHeight+=listItem.getMeasuredHeight();
        }
        //setting listview item in adapter
        ViewGroup.LayoutParams params=myListView.getLayoutParams();
        params.height=totalHeight + (myListView.getDividerHeight() * (myListAdapter.getCount() - 1));
        myListView.setLayoutParams(params);
        // print height of adapter on log
        Log.i("height of listItem:", String.valueOf(totalHeight));
    }
}