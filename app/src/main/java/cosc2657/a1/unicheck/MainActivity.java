package cosc2657.a1.unicheck;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import cosc2657.a1.unicheck.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView navigationView;

    private HomeFragment homeFragment = new HomeFragment();
    private LikedFragment likedFragment = new LikedFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.bottomNav);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

        navigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        return;
                    case R.id.liked:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, likedFragment).commit();
                        return;
                    default:
                }
            }
        });
    }

}