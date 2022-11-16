package cosc2657.a1.unicheck.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import cosc2657.a1.unicheck.R;
import cosc2657.a1.unicheck.model.ImageNote;
import cosc2657.a1.unicheck.model.University;

public class ImageNotesAdapter extends BaseAdapter {
    protected Context context;
    protected ImageNote[] imageNotes;
    LayoutInflater layoutInflater;

    public ImageNotesAdapter(Context context, ImageNote[] imageNotes) {
        this.context = context;
        this.imageNotes = imageNotes;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return imageNotes.length;
    }

    @Override
    public Object getItem(int i) {
        return imageNotes[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.image_note, null);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.child_image) ;
        TextView noteView = (TextView) convertView.findViewById(R.id.note);

        imageView.setImageResource(imageNotes[position].getImage());
        noteView.setText(imageNotes[position].getNote());

        return convertView;
    }
}
