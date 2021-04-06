package com.example.exercise035;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    Context mContext;
    LayoutInflater inflater;
    private ArrayList<ClassNama> arrayList;

    public ListViewAdapter(Context context) {
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<ClassNama>();
        this.arrayList.addAll(DataKontak.classNamaArrayList);
    }
    public class ViewHolder {
        TextView name;
    }
    @Override
    public int getCount() {
        return DataKontak.classNamaArrayList.size();
    }
    @Override
    public Object getItem(int i) {
        return DataKontak.classNamaArrayList.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder holder;

        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.item_list, null);
            holder.name = (TextView) view.findViewById(R.id.Nama);
            //Menyimpan data dalam tampilan tanpa menggunakan struktur data lain
            view.setTag(holder);
        } else {
            //Mengatur holder untuk mengembalikan nilai dari view tag
            holder = (ViewHolder) view.getTag();
        }
        //Set item ke TextView
        holder.name.setText(DataKontak.classNamaArrayList.get(i).getNama());
        //Mengembalikan nilai ke variabel view
        return view;
    }
    public void SearchNama(String query) {
        DataKontak.classNamaArrayList.clear();
        if (query.isEmpty()) {
            DataKontak.classNamaArrayList.addAll(arrayList);
        }
        else {
            query = query.toLowerCase();
            for (ClassNama SearchData : arrayList) {
                if (SearchData.getNama().toLowerCase().contains(query)) {
                    DataKontak.classNamaArrayList.add(SearchData);
                }
            }
        }
        notifyDataSetChanged();
    }
}
