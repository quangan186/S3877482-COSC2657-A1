package cosc2657.a1.unicheck;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import cosc2657.a1.unicheck.R;
import cosc2657.a1.unicheck.adapter.UniversityListAdapter;
import cosc2657.a1.unicheck.data.UniversityList;
import cosc2657.a1.unicheck.model.University;

public class HomeFragment extends Fragment {
    protected ListView listView;
    protected UniversityList universities = new UniversityList();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        listView = (ListView) rootView.findViewById(R.id.university_list);
        listView.setAdapter(new UniversityListAdapter(getActivity(),universities.getUniversities()));
        return rootView;
    }
}