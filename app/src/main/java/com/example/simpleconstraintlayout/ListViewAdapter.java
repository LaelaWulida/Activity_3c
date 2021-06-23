package com.example.simpleconstraintlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    //deklarasi variable dengan jenis data conext
    Context mContext;

    //deklarasi variable dengan jenis data layout inflater
    LayoutInflater inflater;

    //deklarasi variable dengan jenis data ArrayList
    private ArrayList<ClassNama> arrayList;

    //membuat konstruktor Listviewadapter
    public ListViewAdapter(Context context) {
        //memberi nilai mContext dengan context
        mContext = context;

        //mengatur Layoutflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);

        //memberikan nilai arrayList dari class ClassNama
        this.arrayList = new ArrayList<ClassNama>();

        //menambahkan semua elemen ke arrayList
        this.arrayList.addAll(Home_Activity.classNamaArrayList);
    }

    //membuat class untuk mendeklarasikan tempat untuk meletakkan isi kedalam listview
    public class ViewHolder {
        //mendeklarasikan variable dengan jenis TextView
        TextView name;
    }

    //fungsi getCount() mengembalikan jumlah item yang akan ditampilkan dalam list
    @Override
    public int getCount() {

        return Home_Activity.classNamaArrayList.size();
    }

    //Fungsi ini digunakan untuk mendapatkan data item yang terkait dengan posisi
    //tertentu dalam kumpulan data untuk mendapatkan dta yang sesuai dari lokasi
    //tertentu dalam pengumpulan data item.
    @Override
    public Object getItem(int i) {
        //mengembalikan nilai berupa jumlah data array data
        return Home_Activity.classNamaArrayList.get(i);
    }

    //fungsi mengembalikan "nilai" dari posisi item ke adaptor
    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //deklarasi variable dengan jenis data ViewHolder
        final ViewHolder holder;

        //membuat kondisi apakal view null atau tidak
        if (view == null) {
            //membuat objek view holder
            holder = new ViewHolder();

            //mengatur layout untuk menampilkan item
            view = inflater.inflate(R.layout.item_listview, null);

            //set id untuk textview
            holder.name = (TextView) view.findViewById(R.id.tvnama_item);

            //menyimpan data dalam tampilan tanpa menggunakan struktur data lain.
            view.setTag(holder);
        } else {
            //mengatur holder untuk mengembalikan nilai dari view tag
            holder = (ViewHolder) view.getTag();
        }
        //set item ke textviewa
        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getName());

        //mengembalikan nilai ke variable view
        return view;
    }
}
