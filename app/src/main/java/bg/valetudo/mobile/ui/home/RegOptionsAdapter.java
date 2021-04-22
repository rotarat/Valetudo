package bg.valetudo.mobile.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import bg.valetudo.mobile.R;

public class RegOptionsAdapter extends RecyclerView.Adapter<RegOptionsAdapter.ViewHolder> {
    private ArrayList<RegOptionsElement> regOptionsElements;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public CheckBox mCheckBox;
        public TextView mTextView;

        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            // to do: inicialize mCheckBox, mTextView
//            mCheckBox = itemView.findViewById(R.id.);
//            mTextView = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public RegOptionsAdapter(ArrayList<RegOptionsElement> elementsList) {
        regOptionsElements = elementsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.reg_option, parent, false);
       ViewHolder vh = new ViewHolder(v, mListener);
       return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RegOptionsElement currItem = regOptionsElements.get(position);

        // to do: set checkbox
        holder.mTextView.setText(currItem.getElementText());
    }

    @Override
    public int getItemCount() {
        return regOptionsElements.size();
    }
}
