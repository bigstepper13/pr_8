package com.example.pr4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class SecondFragment extends Fragment {
    public SecondFragment() {super(R.layout.fragment_second);}
    private final static String TAG = "SecondFragmentLog";
    private static class Item {
        private String text_field;
        private Drawable image_field;
        public Item(String text_field, Drawable image_field) {
            this.text_field = text_field;
            this.image_field = image_field;
        }
        public String getText_field() {
            return text_field;
        }
        public void setText_field(String text_field) {
            this.text_field = text_field;
        }
        public Drawable getImage_field() {return this.image_field;}
        public void setImage_field(Drawable image_field) {this.image_field = image_field;}
    }
    public class FistFragmentListViewAdapter extends ArrayAdapter<Item> {
        private LayoutInflater inflater;
        private int layout;
        private List<Item> items;
        public FistFragmentListViewAdapter(Context context, int resource,
                                           List<Item> items) {
            super(context, resource, items);
            this.items = items;
            this.layout = resource;
            this.inflater = LayoutInflater.from(context);
        }
        public View getView(int position, View convertView,
                            ViewGroup parent) {

            View view = inflater.inflate(this.layout, parent, false);

            ImageView imageView = view.findViewById(R.id.second_fragment_listview_item_imageview);
            TextView textView = view.findViewById(R.id.second_fragment_listview_item_textview);
            Item item = items.get(position);
            textView.setText(item.getText_field());
            imageView.setImageDrawable(item.getImage_field());
            return view;
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Item> items = new ArrayList<>();

        for (int i = 1; i < 213; i++) {
            items.add(new Item("Мужской аромат №" + i, getActivity().getDrawable(R.drawable.men)));
        }

        ListView itemsList = getActivity().findViewById(R.id.second_fragment_list_view);

        FistFragmentListViewAdapter adapter = new FistFragmentListViewAdapter(this.getContext(),
                R.layout.fragment_item, items);
        itemsList.setAdapter(adapter);

        itemsList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View
                    v, int position, long id)
            {
                Item item = (Item) itemsList.getItemAtPosition(position);
                String item_str = item.getText_field();

                Toast.makeText(getActivity(), "Item '" + item_str + "' pressed!", Toast.LENGTH_SHORT).show();
                Log.d(TAG, ("onListViewItemPressed: " + item_str));
            }
        });
    }
}
