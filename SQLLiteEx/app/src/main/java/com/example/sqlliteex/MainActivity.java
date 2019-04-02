package com.example.sqlliteex;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {
    EditText id, name, qty;
    ListView listView;
    MyDbAdapter helper;


    Massage massage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText) findViewById(R.id.txtId);
        name= (EditText) findViewById(R.id.txtName);
        qty= (EditText) findViewById(R.id.txtQty);
        helper = new MyDbAdapter(this);

        getProductlist();
    }

    public void addUser(View view)
    {
        Product product=new Product(name.getText().toString(), Integer.parseInt(qty.getText().toString()));
       Long i= helper.insertData(product);
        if(i <0)
        {
            Massage.message(this,"Unsuccessful");
        } else
        {
           getProductlist();
            Massage.message(this,"Successful");

        }
    }


    public void updateUser(View view)
    {
        Product product=new Product(Integer.parseInt(id.getText().toString()), name.getText().toString(), Integer.parseInt(qty.getText().toString()));

        Long i= helper.updateData(product);
        if(i <0)
        {
            Massage.message(this,"Update Unsuccessful");
        } else
        {
            Massage.message(this,"Update Successful");

        }
    }


    public void getProductById(View view){
        int pid=Integer.parseInt(id.getText().toString().trim());
        Product p=helper.findProductById(pid);
        if(p != null){
            name.setText(p.getName());
            qty.setText(String.valueOf(p.getQty()));

        }else {

            Toast.makeText(this, "No data Exixt", Toast.LENGTH_LONG).show();
        }

    }

    public void delete(View view){
        int pid=Integer.parseInt(id.getText().toString().trim());
        helper.deleteProduct(pid);
        getProductlist();
        Toast.makeText(this, "Delete Successfully", Toast.LENGTH_LONG).show();

    }

    public void getProductlist(){
       listView = (ListView) findViewById(R.id.listViews);
        List<Product> list= helper.getList();
        ProductAdapter adapter= new ProductAdapter(this, list);
        listView.setAdapter(adapter);
    }
}
