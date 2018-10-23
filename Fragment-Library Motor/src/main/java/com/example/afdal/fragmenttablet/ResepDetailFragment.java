package com.example.afdal.fragmenttablet;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResepDetailFragment extends Fragment
{
    private long resepId;

    public ResepDetailFragment()
    {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resep_detail, container, false);

    }

    public void setResep(long id)
    {
        this.resepId = id;
    }

    public void onStart()
    {
        super.onStart();
        View view = getView();

        if (view != null) {
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            final Resep resepmakanan = Resep.resepmakanan[(int) resepId];

            title.setText(resepmakanan.getbrand());

            TextView harga = (TextView) view.findViewById(R.id.textHarga);
            harga.setText(resepmakanan.getHarga());

            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(resepmakanan.getmerk());

            ImageView gambar =(ImageView) view.findViewById(R.id.imgMusik);
            gambar.setImageResource(resepmakanan.getGambar());

            Button btn = (Button) view.findViewById(R.id.edit);
            btn.setOnClickListener(new Button.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
//                    if (resepmakanan.getDescription("YAMAHA"))
//                    {
//                        Intent intent = new Intent(getActivity(),EditGambar.class);
//                        startActivity(intent);
//                    }
                    Intent intent = new Intent(getActivity(),EditGambar.class);
                    startActivity(intent);
                }
            });
        }
    }
}
