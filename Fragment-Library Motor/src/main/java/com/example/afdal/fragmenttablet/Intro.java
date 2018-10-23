package com.example.afdal.fragmenttablet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intro extends AppCompatActivity implements View.OnClickListener
{
  Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        findAllViewId();
        button.setOnClickListener(this);


    }

    private void findAllViewId()
    {
        button=(Button) findViewById(R.id.btnNext);

    }

    @Override
    public void onClick(View v)
    {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        Bundle b = new Bundle();
        intent.putExtras(b);
        startActivity(intent);
    }
}
