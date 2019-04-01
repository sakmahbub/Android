package com.example.sqlliteex;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText id, name, qty;
    MyDbAdapter helper;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name= (EditText) findViewById(R.id.txtName);
        qty= (EditText) findViewById(R.id.txtQty);
        helper = new MyDbAdapter(this);
    }

    public void addUser(View view)
    {
       Product product=new Product(name.getText().toString(), Integer.parseInt(qty.getText().toString()));
       Long i= helper.insertData(product);
        if(i <0)
        {
            Massage.message(context,"Unsuccessful");
        } else
        {
            Massage.message(context,"Successful");
        }
    }


    public void getProductById(View view){
        int pid=Integer.parseInt(id.getText().toString().trim());
        Product p=helper.findProductById(pid);
        if(p != null){
            name.setText(p.getName());
            qty.setText(String.valueOf(p.getQty()));

        }else {

            Toast.makeText(context, "No data Exixt", Toast.LENGTH_LONG).show();
        }

    }

    public void delete(View view){
        int pid=Integer.parseInt(id.getText().toString().trim());
        helper.deleteProduct(pid);
        Toast.makeText(context, "Delete Successfully", Toast.LENGTH_LONG).show();

    }
}
