package com.example.superpharm;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class LipList extends ArrayAdapter<Lip> {
    private Activity context;
    private List<Lip> eyesList;
    public LipList(Activity context, List<Lip> lips){
        super(context,R.layout.listitem, lips);
        this.context=context;
        this.eyesList=lips;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listviewItem = inflater.inflate(R.layout.listitem,null,true);
        ImageView img = listviewItem.findViewById(R.id.imageView);
        TextView txtType = listviewItem.findViewById(R.id.txPrice);
        TextView txtPrice = listviewItem.findViewById(R.id.txType);
        Lip lp = eyesList.get(position);
        txtPrice.setText(lp.getType());
        txtType.setText(lp.getType());
        img.setImageBitmap(lp.getBt());
        return listviewItem;
    }
}
