package com.foodheaven.foodheaven.foodheaven;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Owais on 5/1/2016.
 */
public class orderview extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orderview);


        TextView textView = (TextView) findViewById(R.id.textView34);
        textView.setText(new SetGetValues().getPopulateTotalOrders());

        TextView textView1 = (TextView) findViewById(R.id.textView35);
        textView1.setText(new SetGetValues().getTotalprices() + " RM");


    }
}
