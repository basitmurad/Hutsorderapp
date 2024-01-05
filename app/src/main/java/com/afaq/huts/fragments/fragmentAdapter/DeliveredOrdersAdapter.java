package com.afaq.huts.fragments.fragmentAdapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.afaq.huts.R;
import com.afaq.huts.adapters.ChildAdapter;
import com.afaq.huts.model.OrderData;
import com.afaq.huts.model.OrderDetails;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class DeliveredOrdersAdapter extends RecyclerView.Adapter<DeliveredOrdersAdapter.MyHolder> {
    private Context context;
    private ArrayList<OrderData> orderDataArrayList;
    private ArrayList<OrderDetails> orderDetailsArrayList;
    private DatabaseReference databaseReferenceCancel;
    private boolean[] isChildVisible;

    public DeliveredOrdersAdapter(Context context, ArrayList<OrderData> orderDataArrayList) {
        this.context = context;
        this.orderDataArrayList = orderDataArrayList;
        isChildVisible = new boolean[orderDataArrayList.size()];
    }

    @NonNull
    @Override
    public DeliveredOrdersAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.delivereditem_layout, parent, false);
        return new MyHolder(view);
    }

    @Override
    @SuppressLint("RecyclerView")
    public void onBindViewHolder(@NonNull DeliveredOrdersAdapter.MyHolder holder,  int position) {

        OrderData orderData = orderDataArrayList.get(position);

        holder.deliOrderId.setText(String.valueOf(orderData.getOrderId()));
        holder.deliOrderHut.setText(orderData.getHutName());
        holder.deliOrderPrice.setText(String.valueOf(orderData.getTotalPrice()));
        orderData.getOrderDetailsList();


        ChildAdapter adapter = new ChildAdapter(context, orderData.getOrderDetailsList());


        holder.recyclerView.setAdapter(adapter);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));


        holder.btnDeliverd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isChildVisible[position] = !isChildVisible[position]; // Toggle the flag for this position

                if (isChildVisible[position]) {
                    holder.recyclerView.setVisibility(View.VISIBLE);
                } else {
                    holder.recyclerView.setVisibility(View.GONE);
                }
            }
        });


        holder.recyclerView.setVisibility(isChildVisible[position] ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return orderDataArrayList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView deliOrderId, deliOrderHut, deliOrderPrice;
        ImageView btnDeliverd;

        RecyclerView recyclerView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            deliOrderPrice = itemView.findViewById(R.id.totalDeliveredPrice);
            deliOrderHut = itemView.findViewById(R.id.hutDeliveredName);
            deliOrderId = itemView.findViewById(R.id.orderDeliveredId);
            btnDeliverd = itemView.findViewById(R.id.btnOpenOrderswe);
            recyclerView = itemView.findViewById(R.id.bnms);
        }
    }
}
