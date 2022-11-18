package cosc2657.a1.unicheck.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import cosc2657.a1.unicheck.R;

import cosc2657.a1.unicheck.model.University;

public class UniversityListAdapter extends BaseAdapter implements Filterable {
    protected Context context;
    protected ArrayList<University> universities;
    protected ArrayList<University> filteredList;
    LayoutInflater layoutInflater;

    public UniversityListAdapter(Context context, ArrayList<University> universities) {
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

        LinearLayout universityRowLayout = (LinearLayout) convertView.findViewById(R.id.university_id);
        TextView universityTitleView = (TextView) convertView.findViewById(R.id.university_title) ;
        TextView universityNameView = (TextView) convertView.findViewById(R.id.university_name);
        ImageView logoView = (ImageView) convertView.findViewById(R.id.logo);

        universityRowLayout.setId(universities.get(position).getId());
        universityTitleView.setText(universities.get(position).getTitle());
        universityNameView.setText(universities.get(position).getName());
        logoView.setImageResource(universities.get(position).getLogo());

        return convertView;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults oReturn = new FilterResults();
                ArrayList<University> results = new ArrayList<>();
                if (filteredList == null)
                    filteredList = universities;
                if (charSequence != null) {
                    if (filteredList != null && filteredList.size() > 0) {
                        for (final University university : filteredList) {
                            if (university.getName().toLowerCase()
                                    .contains(charSequence.toString()))
                                results.add(university);
                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;

            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                universities = (ArrayList<University>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        filteredList.clear();
        if (charText.length()==0){
            filteredList.addAll(universities);
        }
        else {
            for (University university : universities){
                if (university.getTitle().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    filteredList.add(university);
                }
            }
        }
        notifyDataSetChanged();
    }
}
