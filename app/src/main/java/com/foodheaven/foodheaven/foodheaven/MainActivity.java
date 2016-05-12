package com.foodheaven.foodheaven.foodheaven;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText username,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView5);
        TextView textView7 = (TextView) findViewById(R.id.textView7);

        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        Button button = (Button) findViewById(R.id.button);



        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                forgotPassword();



            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                authentication (username.getText().toString(), password.getText().toString());




            }
        });











        ///---------------------- SIGNUP ------------------------------//
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final Dialog dialog1 = new Dialog(MainActivity.this);
                dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog1.setContentView(R.layout.signup_dialog);

                final EditText username_edt = (EditText) dialog1.findViewById(R.id.editText3);
                final EditText password_edt = (EditText) dialog1.findViewById(R.id.editText4);
                final EditText reppassword_edt = (EditText) dialog1.findViewById(R.id.editText5);
                final EditText email_address_edt = (EditText) dialog1.findViewById(R.id.editText6);
                final EditText phoneno_edt = (EditText) dialog1.findViewById(R.id.editText7);


                Button done = (Button) dialog1.findViewById(R.id.button2);


                done.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        if (!password_edt.getText().toString().equals(reppassword_edt.getText().toString()))
                        {
                            Toast.makeText(getApplicationContext(), "Password is not same!",Toast.LENGTH_SHORT).show();
                            dialog1.show();

                        }


                        else
                        {

                            SharedPreferences pref = getApplicationContext().getSharedPreferences("foodheaven_db", MODE_PRIVATE);
                            SharedPreferences.Editor editor = pref.edit();


                            /**************** Storing data as KEY/VALUE pair *******************/

                            editor.putString("username", username_edt.getText().toString());
                            editor.putString("password", password_edt.getText().toString());
                            editor.putString("emailaddress", email_address_edt.getText().toString());
                            editor.putString("phoneno", phoneno_edt.getText().toString());



                            editor.commit(); // commit changes

                            Toast.makeText(getApplicationContext(), "Account created!",Toast.LENGTH_SHORT).show();


                            dialog1.dismiss();

                        }



                    }

                });

                dialog1.show();

            }

        });

    }

    public void authentication (String username , String Password)
    {


        SharedPreferences pref = getApplicationContext().getSharedPreferences("foodheaven_db", MODE_PRIVATE);


        if (pref.getString("username", null).equals(username) && pref.getString("password", null).equals(Password))
        {

            Intent intent = new Intent(MainActivity.this,Cuisines.class);
            startActivity(intent);

        }
        else
        {

        Toast.makeText(getApplicationContext(),"Username/Password - Incorrect", Toast.LENGTH_SHORT).show();

        }




    }

    private void forgotPassword()
    {



        final Dialog dialog1 = new Dialog(MainActivity.this);
        dialog1.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog1.setContentView(R.layout.forgotpassword_dialog);
        Button execute = (Button) dialog1.findViewById(R.id.execute);

        ImageView imageView = (ImageView) dialog1.findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
            }
        });
        execute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText18 = (EditText) dialog1.findViewById(R.id.editText8);

                TextView textView15 = (TextView) dialog1.findViewById(R.id.textView15);



                SharedPreferences pref = getApplicationContext().getSharedPreferences("foodheaven_db", MODE_PRIVATE);

                if (pref.getString("username",null).equals(editText18.getText().toString()))
                {


                    textView15.setText("Password found: "+pref.getString("password",null).toString());

                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Password not found! Check Username",Toast.LENGTH_SHORT).show();
                }

            }
        });

        dialog1.show();

    }
}
