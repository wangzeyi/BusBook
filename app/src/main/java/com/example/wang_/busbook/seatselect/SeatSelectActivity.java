package com.example.wang_.busbook.seatselect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.wang_.busbook.R;
import com.example.wang_.busbook.adapter.BusSeat;
import com.example.wang_.busbook.adapter.BusSeatAdapter;

import java.util.ArrayList;
import java.util.List;

public class SeatSelectActivity extends AppCompatActivity {

    RecyclerView recyclerView_seat;
    BusSeatAdapter myAdapter;
    List<BusSeat> myList;
    int columns = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_select);

        recyclerView_seat = findViewById(R.id.recyclerview_seat);
        myList = new ArrayList<>();
        //myAdapter = new BusSeatAdapter(myList);

        for(int i=1; i<13; i++){
            BusSeat busSeat = new BusSeat(0,i);
            myList.add(busSeat);
        }
        myAdapter = new BusSeatAdapter(myList, new BusSeatAdapter.SeatOnClickListener() {
            @Override
            public void onitemclick(BusSeat busSeat) {
               if(busSeat.getType() == 0) {
                   busSeat.setType(2);
               }
               else if(busSeat.getType() == 2){
                   busSeat.setType(0);
               }
               myAdapter.notifyDataSetChanged();
            }
        });

        GridLayoutManager manager = new GridLayoutManager(this, columns);
        recyclerView_seat.setLayoutManager(manager);
        recyclerView_seat.setAdapter(myAdapter);



    }


}
