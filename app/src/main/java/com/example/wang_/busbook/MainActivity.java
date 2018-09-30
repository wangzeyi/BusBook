package com.example.wang_.busbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SearchEvent;
import android.view.View;
import android.widget.Button;

import com.example.wang_.busbook.seatselect.SeatSelectActivity;

public class MainActivity extends AppCompatActivity {

    Button button_seat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_seat = findViewById(R.id.button_seat);

        button_seat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SeatSelectActivity.class);
                startActivity(i);
            }
        });
    }


}
