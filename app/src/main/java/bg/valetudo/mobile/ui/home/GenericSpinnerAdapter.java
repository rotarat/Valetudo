package bg.valetudo.mobile.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import bg.valetudo.mobile.R;

public class GenericSpinnerAdapter<T> extends ArrayAdapter<T> {
    public GenericSpinnerAdapter(Context context, List<T> list, Boolean hasEmpty) {
        super(context, 0, list);
        if(hasEmpty)
            insert(null, 0);
        this.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    public GenericSpinnerAdapter(Context context, T[] list, Boolean hasEmpty) {
        super(context, 0, new LinkedList<>(Arrays.asList(list)));
        if(hasEmpty)
            insert(null, 0);
        this.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    public GenericSpinnerAdapter(Context context, List<T> list) {
        super(context, 0, list);
        this.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    public GenericSpinnerAdapter(Context context, T[] list) {
        super(context, 0, list);
        this.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_item, parent, false);
        }

        TextView textViewName = convertView.findViewById(R.id.spinner_text);
        T currentItem = getItem(position);
        if (currentItem != null) {
            if(currentItem instanceof LocalTime) {
                textViewName.setText(((LocalTime) currentItem).format(DateTimeFormatter.ofPattern("HH:mm")));
            } else {
                textViewName.setText(currentItem.toString());
            }
        } else {
            textViewName.setText(R.string.choose);
        }
        return convertView;
    }
}
