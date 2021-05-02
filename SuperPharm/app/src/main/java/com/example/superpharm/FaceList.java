package com.example.superpharm;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FaceList extends ArrayAdapter<Face> {
    private Activity context;
    private List<Face> eyesList;
    public FaceList(Activity context, List<Face> faces){
        super(context,R.layout.listitem, faces);
        this.context=context;
        this.eyesList=faces;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listviewItem = inflater.inflate(R.layout.listitem,null,true);
        ImageView img = listviewItem.findViewById(R.id.imageView);
        TextView txtPrice = listviewItem.findViewById(R.id.txPrice);
        TextView txtType = listviewItem.findViewById(R.id.txType);
        TextView quant = listviewItem.findViewById(R.id.txQuant);
        Face fc = eyesList.get(position);
        txtPrice.setText(fc.getType());
        txtType.setText(fc.getType());
       // quant.setText(fc.quantity);
        img.setImageBitmap(fc.bt);
        return listviewItem;
    }
}
