package com.example.superpharm;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class MainAdapter extends ArrayAdapter {
    private Activity context;
    private List itemsList;
    public MainAdapter(Activity context, List items){
        super(context,R.layout.item, items);
        this.context=context;
        this.itemsList=items;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listviewItem = inflater.inflate(R.layout.item,null,true);
        ImageView img = listviewItem.findViewById(R.id.imgg);
        TextView txtPrice = listviewItem.findViewById(R.id.pricee);
        BagItem bg = (BagItem) itemsList.get(position);
        txtPrice.setText(bg.getPc().toString());
        img.setImageBitmap(bg.getBt());
        return listviewItem;
    }
}
