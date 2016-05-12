package com.foodheaven.foodheaven.foodheaven;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.xml.sax.Parser;

import java.util.Random;

public class Custom_adapter extends ArrayAdapter<String> {

    int index;
    private final Activity context;
    private final String[] itemname;
    private final String[] prices;
    Random random;
    int tpbq;

    public Custom_adapter(String[] itemname, Activity context, String[] prices) {
        super(context, R.layout.customlist, itemname);

        this.context=context;
        this.itemname=itemname;
        this.prices = prices;

    }

    public View getView(final int position,View view,ViewGroup parent) {

        random = new Random();
        index = random.nextInt(8);

        LayoutInflater inflater=context.getLayoutInflater();
        final View rowView=inflater.inflate(R.layout.customlist, parent, false);


        final CheckBox checkbox = (CheckBox) rowView.findViewById(R.id.checkBox);
        TextView dishtitle = (TextView) rowView.findViewById(R.id.textView16);
        TextView pricestxt = (TextView) rowView.findViewById(R.id.textView26);
        final EditText quantityedit = (EditText) rowView.findViewById(R.id.editText13);


        checkbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!TextUtils.isEmpty(quantityedit.getText().toString()))
                {

                    tpbq = Integer.parseInt(quantityedit.getText().toString()) * Integer.parseInt(prices[position]);


                    new SetGetValues().setPopulateTotalOrders(itemname[position]+"\t\tQuantity: " +quantityedit.getText().toString()+"\tPrice:  " + prices[position] +" RM");

                    new SetGetValues().setTotalprices(tpbq);

                    ((CheckBox) rowView.findViewById(R.id.checkBox)).setEnabled(false);

                }
                else
                {
                    checkbox.setChecked(false);
                    Toast.makeText(getContext(),"Please take quantity",Toast.LENGTH_SHORT).show();

                }

            }
        });
        pricestxt.setText(prices[position]);
        dishtitle.setText(itemname[position]);

        return rowView;

    };


}
