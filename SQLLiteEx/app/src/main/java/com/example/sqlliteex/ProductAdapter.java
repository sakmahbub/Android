package com.example.sqlliteex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    Context context;
    List<Product> productList;
    LayoutInflater inflater;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
        this.inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return productList.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.list,null);
        TextView pid=view.findViewById(R.id.pid);
        TextView pname=view.findViewById(R.id.pName);
        TextView pqty=view.findViewById(R.id.pQty);
        pid.setText(String.valueOf(productList.get(position).getId()));
        pname.setText(productList.get(position).getName());
        pqty.setText(String.valueOf(productList.get(position).getQty()));
        return view;
    }
}
