package com.example.superpharm;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EyesList extends ArrayAdapter<Eyes> {
    private Activity context;
    private List<Eyes> eyesList;
    public EyesList(Activity context, List<Eyes> eyes){
        super(context,R.layout.listitem, eyes);
        this.context=context;
        this.eyesList=eyes;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listviewItem = inflater.inflate(R.layout.listitem,null,true);
        ImageView img = listviewItem.findViewById(R.id.imageView);
        TextView txtPrice = listviewItem.findViewById(R.id.txPrice);
        TextView txtType = listviewItem.findViewById(R.id.txType);
        Eyes eye = eyesList.get(position);
        txtPrice.setText(eye.getType());
        txtType.setText(eye.getType());
        img.setImageBitmap(eye.getBt());
        return listviewItem;
    }
}
