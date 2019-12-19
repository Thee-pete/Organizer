package com.apps.pete.organizer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DoesAdapter extends RecyclerView.Adapter<DoesAdapter.MyViewHolder> {

    Context context;
    ArrayList<Mydoes> myDoes;

    public DoesAdapter(Context c, ArrayList<Mydoes> p)
    {
        context = c;
        myDoes =p;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_does,viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder viewHolder, int i) {

        viewHolder.titledoes.setText(myDoes.get(i).getTitledoes());
        viewHolder.descdoes.setText(myDoes.get(i).getDescdoes());
        viewHolder.datedoes.setText(myDoes.get(i).getDatedoes());
        viewHolder.keydoes.setText(myDoes.get(i).getKeydoes());

        final String getTitleDoes = myDoes.get(i).getTitledoes();
        final String getDescDoes = myDoes.get(i).getDescdoes();
        final String getDateDoes = myDoes.get(i).getDatedoes();
        final String getKeyDoes = myDoes.get(i).getKeydoes();



        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aa = new Intent(context, EditTaskDesk.class);
                aa.putExtra("titledoes", getTitleDoes);
                aa.putExtra("descdoes", getDescDoes);
                aa.putExtra("datedoes", getDateDoes);
                aa.putExtra("keydoes", getKeyDoes);

                context.startActivity(aa);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myDoes.size();
    }

    class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView titledoes, descdoes, datedoes, keydoes;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titledoes = (TextView) itemView.findViewById(R.id.titledoes);
            descdoes = (TextView) itemView.findViewById(R.id.descdoes);
            datedoes = (TextView) itemView.findViewById(R.id.datedoes);

        }
    }
}
