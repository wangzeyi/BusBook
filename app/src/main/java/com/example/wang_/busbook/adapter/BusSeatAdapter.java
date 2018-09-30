package com.example.wang_.busbook.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.wang_.busbook.R;

import java.util.List;

public class BusSeatAdapter extends RecyclerView.Adapter<BusSeatAdapter.MyViewHolder>{

    List<BusSeat> seatlist;
    int[] image_array = {R.drawable.seat_free, R.drawable.seat_reserved, R.drawable.seat_selected};

    public BusSeatAdapter(List<BusSeat> seatlist) {
        this.seatlist = seatlist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.seat_layout, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {

        BusSeat busSeat = seatlist.get(position);
        int type = busSeat.getType();
        holder.imageView_seat.setImageResource(image_array[type]);


    }

    @Override
    public int getItemCount() {
        return seatlist.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView_seat;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView_seat =itemView.findViewById(R.id.imageView_seat);
        }

        public void bind(final BusSeat busSeat, final SeatOnClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onitemclick(busSeat);
                }
            });

        };
    }

    public interface SeatOnClickListener{
        void onitemclick(BusSeat busSeat);
    }

}
