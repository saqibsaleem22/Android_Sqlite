package edu.cftic.sql_app.dto;

import android.os.Parcel;
import android.os.Parcelable;



/**
 * Created by vale on 1/06/16.
 */
public class Coche implements Comparable, Parcelable {

    private int id;
    private String modelo;
    private Persona persona;

    /**
     *
     * @param o es un coche
     * @return número negativo si o es mayor que this
     *         número positivo si this es mayor que o
     *         0 si son iguales
     */
    @Override
    public int compareTo(Object o) {
        int resultado = 0;

            Coche c = (Coche)o;
            resultado = this.modelo.compareTo(c.modelo);

        return resultado;
    }

    public Coche (int id, String modelo)
    {
        this.id = id;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


    public Coche (String modelo)
    {
        this.modelo = modelo;
    }

    public Persona getPersona() {
        return persona;
    }

    public Coche () {}

    public Coche (String modelo, Persona persona)
    {
        this.modelo = modelo;
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(modelo);
        parcel.writeParcelable(persona, 0);

    }

    public static final Parcelable.Creator<Coche> CREATOR = new Parcelable.Creator<Coche>(){

        @Override
        public Coche createFromParcel(Parcel parcel) {
            return new Coche(parcel);
        }

        @Override
        public Coche[] newArray(int size) {
            return new Coche[size];
        }
    };

    public Coche (Parcel parcel)
    {
        this.id = parcel.readInt();
        this.modelo = parcel.readString();
        this.persona = parcel.readParcelable(Persona.class.getClassLoader());

    }


}
