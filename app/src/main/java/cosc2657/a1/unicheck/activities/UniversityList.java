package cosc2657.a1.unicheck.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import cosc2657.a1.unicheck.R;
import cosc2657.a1.unicheck.adapter.UniversityListAdapter;
import cosc2657.a1.unicheck.model.University;

public class UniversityList extends AppCompatActivity {
    private ArrayList<University> universityList = new cosc2657.a1.unicheck.data.UniversityList().getUniversities();
    BottomNavigationView bottomNavigationView;
    SearchView searchView;
    ListView listView;
    UniversityListAdapter universityListAdapter;
    Intent intent;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNav);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.list:
                        return false;
                    case R.id.home:
                        intent = new Intent(UniversityList.this, Home.class);
                        startActivity(intent);
                        return true;
                }
                return true;
            }
        });

        listView = (ListView) findViewById(R.id.universities);
        universityListAdapter = new UniversityListAdapter(UniversityList.this, universityList);
        listView.setAdapter(universityListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                University university = (University) listView.getItemAtPosition(i);
                Intent intent = new Intent(UniversityList.this, UniversityDetails.class);
                intent.putExtra("University",university);
                System.out.println(university);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        try {
            MenuItem menuItem = menu.findItem(R.id.action_search);
            MenuItem sortItem = menu.findItem(R.id.sort);
            searchView = (SearchView) menuItem.getActionView();

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    ArrayList<University> filteredList = new ArrayList<>();
                    if (s.isEmpty()) {
                        filteredList.addAll(universityList);

                    } else {
                        for (University university : universityList) {
                            if (university.getName().toLowerCase().contains(s.toLowerCase()) ||
                                    university.getTitle().toLowerCase().contains(s.toLowerCase())) {
                                filteredList.add(university);
                            }
                        }
                    }
                    UniversityListAdapter filteredListAdapter =
                            new UniversityListAdapter(getApplicationContext(), filteredList);
                    listView.setAdapter(filteredListAdapter);
                    return true;
                }
            });

            sortItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    count++;
                    Collections.sort(universityList, nameAscending);
                    if (count % 2 == 0){
                        Collections.reverse(universityList);
                    }
                    universityListAdapter =
                            new UniversityListAdapter(getApplicationContext(), universityList);
                    listView.setAdapter(universityListAdapter);
                    return true;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Comparator<University> nameAscending = new Comparator<University>() {
        @Override
        public int compare(University university, University t1) {
            return university.getName().compareToIgnoreCase(t1.getName());
        }
    };
}