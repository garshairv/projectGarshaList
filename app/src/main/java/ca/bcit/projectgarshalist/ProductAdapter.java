package ca.bcit.projectgarshalist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private Context context;

    private ArrayList<Data> data;

    private LayoutInflater inflater;


    public ProductAdapter(Context context, ArrayList<Data> data) {

        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int position) {

        View view = inflater.inflate(R.layout.list_view, parent, false);

        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {
        int previousPosition = 0;

        myViewHolder.textview.setText(data.get(position).prodName);
        myViewHolder.imageView.setImageResource(data.get(position).img);

        AnimationCard.animate(myViewHolder, position > previousPosition);

        previousPosition = position;

        final int currentPosition = position;
        final Data infoData = data.get(position);

        myViewHolder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeItem(infoData);
            }
        });

        myViewHolder.buttonDuplicate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(currentPosition, infoData);
            }
        });


        myViewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(currentPosition, infoData);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

class MyViewHolder extends RecyclerView.ViewHolder{

    TextView textview;
    ImageView imageView;
    Button buttonDelete;
    Button buttonDuplicate;

    public MyViewHolder(View itemView) {
        super(itemView);

        textview = (TextView) itemView.findViewById(R.id.productName);
        imageView = (ImageView) itemView.findViewById(R.id.imgView);
        buttonDelete = (Button) itemView.findViewById(R.id.btnDelete);
        buttonDuplicate = (Button) itemView.findViewById(R.id.btnDuplicate);
    }
}

    private void removeItem(Data infoData) {

        int currPosition = data.indexOf(infoData);
        data.remove(currPosition);
        notifyItemRemoved(currPosition);
    }

    private void addItem(int position, Data infoData) {

        data.add(position, infoData);
        notifyItemInserted(position);
    }
}

