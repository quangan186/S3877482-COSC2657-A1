package cosc2657.a1.unicheck;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import cosc2657.a1.unicheck.R;
import cosc2657.a1.unicheck.adapter.UniversityListAdapter;
import cosc2657.a1.unicheck.data.UniversityList;
import cosc2657.a1.unicheck.model.University;

public class HomeFragment extends Fragment {
    protected ListView listView;
    protected ArrayList<University> universities = new UniversityList().getUniversities();
    protected ArrayList<University> filteredList = new ArrayList<>();
    SearchView searchView;
    private View rootView;
    private UniversityListAdapter universityListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        listView = (ListView) rootView.findViewById(R.id.university_list);
        searchView = (SearchView) rootView.findViewById(R.id.search_university);

        universityListAdapter = new UniversityListAdapter(getActivity(), universities);
        listView.setAdapter(universityListAdapter);

//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String s) {
//                filter(s);
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String s) {
//                filter(s);
//                return false;
//            }
//        });

//        search = (EditText) rootView.findViewById(R.id.search_university);
//
//        search.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                filteredList.clear();
//                if (editable.toString().isEmpty()){
//                    listView.setAdapter(new UniversityListAdapter(getActivity(), universities));
//                    universityListAdapter.notifyDataSetChanged();
//                }else {
//                    filter(editable.toString());
//                }
//            }
//        });


        return rootView;
    }


//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        setHasOptionsMenu(true);
//        super.onCreate(savedInstanceState);
//    }
//

//    private void doSearch() {
//        EditText searchTextView = (EditText) rootView.findViewById(R.id.search_university);
//        searchTextView.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                filteredList.clear();
//                if (editable.toString().isEmpty()){
//                    listView.setAdapter(new UniversityListAdapter(getActivity(), filteredList));
//                    universityListAdapter.notifyDataSetChanged();
//                }
//                filter(editable.toString());
//            }
//        });
//    }

    public void filter(String text) {
        for (University university : universities) {
            if (university.getName().toLowerCase().contains(text)) {
                filteredList.add(university);
            }
        }
        listView.setAdapter(new UniversityListAdapter(getActivity(), filteredList));
        universityListAdapter.notifyDataSetChanged();
    }
}