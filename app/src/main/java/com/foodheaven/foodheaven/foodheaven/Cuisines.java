package com.foodheaven.foodheaven.foodheaven;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class Cuisines extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cuisines);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);


        Button button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String radiovalue = ((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
                Toast.makeText(getApplicationContext(),radiovalue + " ",Toast.LENGTH_SHORT).show();

                if (!radiovalue.equals(" ") || radiovalue != null)
                {
                    new SetGetValues().setCuisineSelection(radiovalue);

                    Intent i = new Intent(Cuisines.this, cusine_details.class);
                    startActivity(i);

                }
                else
                    Toast.makeText(getApplicationContext(),"Please select dishes first",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
