package cosc2657.a1.unicheck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import androidx.appcompat.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import cosc2657.a1.unicheck.R;
import cosc2657.a1.unicheck.adapter.UniversityListAdapter;
import cosc2657.a1.unicheck.data.FavoriteList;
import cosc2657.a1.unicheck.data.UniversityList;
import cosc2657.a1.unicheck.model.University;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;
    private ArrayList<University> universityList = new UniversityList().getUniversities();

    SearchView searchView;
    ListView listView;
    UniversityListAdapter universityListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottomNav);

//        FrameLayout layout = (FrameLayout)findViewById(R.id.container);
//        layout.setVisibility(View.GONE);
        listView = (ListView) findViewById(R.id.universities);
        universityListAdapter = new UniversityListAdapter(MainActivity.this, universityList);
        listView.setAdapter(universityListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if (TextUtils.isEmpty(s)){
                    universityListAdapter.filter("");
                    listView.clearTextFilter();
                }else{
                    universityListAdapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }

    public void goToDetailsActivity(View view){
        Intent intent = new Intent(MainActivity.this, UniversityDetails.class);
//        System.out.println(R.id.universityId);
//        System.out.println(view.getId());
        for(University university : universityList){
            if (university.getId() == view.getId()){
                intent.putExtra("University", university);
                startActivity(intent);
                break;
            }
        }
    }
}