package cosc2657.a1.unicheck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import cosc2657.a1.unicheck.R;
import cosc2657.a1.unicheck.data.UniversityList;
import cosc2657.a1.unicheck.model.University;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;

    private HomeFragment homeFragment = new HomeFragment();
    private LikedFragment likedFragment = new LikedFragment();

    private UniversityList universityList = new UniversityList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottomNav);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        return true;
                    case R.id.liked:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, likedFragment).commit();
                        return true;
                    default:
                }
                return false;
            }
        });
    }

    public void goToDetailsActivity(View view){
        Intent intent = new Intent(MainActivity.this, UniversityDetails.class);
//        System.out.println(R.id.universityId);
//        System.out.println(view.getId());
        for(University university : universityList.getUniversities()){
            if (university.getId() == view.getId()){
                intent.putExtra("University", university);
                startActivity(intent);
                break;
            }
        }
    }
}