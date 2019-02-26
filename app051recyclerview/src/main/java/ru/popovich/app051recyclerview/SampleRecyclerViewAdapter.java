package ru.popovich.app051recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SampleRecyclerViewAdapter extends RecyclerView.Adapter<SampleRecyclerViewAdapter.SampleViewHolder> {

    private String[] sampleDataset;

    // Статический класс как ссылка на представление для каждого элемента списка
    public static class SampleViewHolder extends RecyclerView.ViewHolder{

        private final TextView textView;

        private final Context context;

        public SampleViewHolder(@NonNull View itemView) {
            super(itemView);

            context = itemView.getContext();

            textView = (TextView) itemView.findViewById(R.id.sample_text);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    // Конструктор с данными
    public SampleRecyclerViewAdapter(String[] sampleDataset) {
        this.sampleDataset = sampleDataset;
    }

    // Создание нового представления (view) элемента списка (запускается layout manager)
    @NonNull
    @Override
    public SampleRecyclerViewAdapter.SampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Создаем новое представление текстового типа элемента списка
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_view_raw, parent, false);

        SampleViewHolder viewHolder = new SampleViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SampleRecyclerViewAdapter.SampleViewHolder holder, int position) {

        holder.textView.setText(sampleDataset[position]);
    }

    @Override
    public int getItemCount() {
        return sampleDataset.length;
    }
}
