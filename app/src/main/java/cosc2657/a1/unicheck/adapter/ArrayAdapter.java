package cosc2657.a1.unicheck.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import cosc2657.a1.unicheck.R;
import cosc2657.a1.unicheck.UniversityDetails;
import cosc2657.a1.unicheck.model.University;

public class ArrayAdapter extends BaseAdapter {
    protected Context context;
    protected ArrayList<University> universities;
    LayoutInflater layoutInflater;

    public ArrayAdapter(Context context, ArrayList<University> universities) {
        this.context = context;
        this.universities = universities;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return universities.size();
    }

    @Override
    public Object getItem(int i) {
        return universities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.university_row, null);

        LinearLayout universityRowLayout = (LinearLayout) convertView.findViewById(R.id.universityId);
        TextView universityTitleView = (TextView) convertView.findViewById(R.id.universityTitle) ;
        TextView universityNameView = (TextView) convertView.findViewById(R.id.universityName);
        ImageView logoView = (ImageView) convertView.findViewById(R.id.logo);

        universityRowLayout.setId(universities.get(position).getId());
        universityTitleView.setText(universities.get(position).getTitle());
        universityNameView.setText(universities.get(position).getName());
        logoView.setImageResource(universities.get(position).getLogo());

        return convertView;
    }
}
