package com.example.afdal.fragmenttablet;

public class Resep
{
    private String brand;
    private String merk;
    private String warna;
    private String harga;
    private int gambar;


    public static final Resep[] resepmakanan=
            {
            new Resep("YAMAHA", "MERK : R25","WARNA : BIRU", "HARGA : 67 JT",R.drawable.yamaha),
            new Resep("KAWASAKI", "MERK : Versys-X 250 Tourer",
                    "WARNA : HITAM ", "HARGA : 74 JT",R.drawable.kawasaki),
            new Resep("HONDA", "MERK : CBR250RR SE Kabuki",
                    "WARNA : HITAM,PUTIH ", "HARGA : 75 JT",R.drawable.hondo),
            new Resep("SUZUKI", "MERK : SUZUKI GSX-R150",
                    "WARNA : BIRU", "HARGA : 25 JT",R.drawable.suzuki),
            new Resep("DUCATI", "MERK : DUCATI 1200S",
                    "WARNA : MERAH", "HARGA : 490 JT",R.drawable.ducati),

    };

    private Resep(String brand, String merk, String warna, String harga, int Gambar){
        this.brand = brand;
        this.merk = merk;
        this.warna = warna;
        this.harga = harga;
        this.gambar = Gambar ;
    }

    public String getHarga()
    {
        return harga;
    }

    public String getDescription() {
        return brand;
    }
    public int getGambar()
    {
        return gambar;
    }
    public String getmerk() {
        return merk;
    }
    public String getwarna()
    {
        return warna;
    }
    public String getbrand() {
        return brand;
    }
    public String toString() {
        return this.brand;
    }
}
