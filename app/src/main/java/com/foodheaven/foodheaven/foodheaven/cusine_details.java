package com.foodheaven.foodheaven.foodheaven;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class cusine_details extends Activity {

    String[] itemname = null;
    String[] prices = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cusine_details);

        AlertDialog.Builder builder = new AlertDialog.Builder(cusine_details.this);
        builder.setMessage("Once the dish is selected you cannot change it!")
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();


        TextView textView = (TextView) findViewById(R.id.textView13);
        textView.setText(new SetGetValues().getCuisineSelection() + " Cusines");

        if (new SetGetValues().getCuisineSelection().equals("Pakistani"))
        {
            itemname = getResources().getStringArray(R.array.Pakistani);
            prices = getResources().getStringArray(R.array.prices3);

        }
        else if (new SetGetValues().getCuisineSelection().equals("Turkish"))
        {
            itemname = getResources().getStringArray(R.array.Turkish);
            prices = getResources().getStringArray(R.array.prices4);

        }
        else if (new SetGetValues().getCuisineSelection().equals("Arabic"))
        {
            itemname = getResources().getStringArray(R.array.Arabic);
            prices = getResources().getStringArray(R.array.prices2);

        }
        else if (new SetGetValues().getCuisineSelection().equals("Fast Food"))
        {
            textView.setText(new SetGetValues().getCuisineSelection());
            itemname = getResources().getStringArray(R.array.Fast_Food);
            prices = getResources().getStringArray(R.array.prices5);


        }
        else if (new SetGetValues().getCuisineSelection().equals("Juices")) {
            textView.setText(new SetGetValues().getCuisineSelection());
            itemname = getResources().getStringArray(R.array.Juices);
            prices = getResources().getStringArray(R.array.prices);

        }
        else if (new SetGetValues().getCuisineSelection().equals("Hot Drinks"))
        {
            textView.setText(new SetGetValues().getCuisineSelection());
            itemname = getResources().getStringArray(R.array.HotDrinks);
            prices = getResources().getStringArray(R.array.prices5);


        }
        else if (new SetGetValues().getCuisineSelection().equals("Malay"))
        {
            itemname = getResources().getStringArray(R.array.Malay);
            prices = getResources().getStringArray(R.array.prices3);

        }



        Custom_adapter custom_adapter = new Custom_adapter(itemname,this, prices);
        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(custom_adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem = itemname[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });

        Button next_btn = (Button) findViewById(R.id.button4);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(cusine_details.this,order_details.class);
                startActivity(i);

            }
        });
        Button back_btn = (Button) findViewById(R.id.button5);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
