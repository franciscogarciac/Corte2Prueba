package com.example.parcial;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Paises {
    String pais, urlpais, oeste,este,norte, sur;

    public Paises(String ppais,String purl,String pwest,String peast,String pnorth,String psouth) throws JSONException {
        pais = ppais;
        urlpais ="http://www.geognos.com/api/en/countries/flag/"+purl+".png";
        oeste=pwest;
        este=peast;
        norte=pnorth;
        sur=psouth;
    }


    public static ArrayList<Paises> JsonObjectsBuild(JSONObject datos) throws JSONException {
        ArrayList<Paises> pais = new ArrayList<>();

        JSONObject results=datos.getJSONObject("Results");
        JSONArray datosdb=results.names();

        for (int i = 0; i < datosdb.length(); i++) {

            String bd= datosdb.getString(i);
            JSONObject datosBD=results.getJSONObject(bd);
            String nombre=datosBD.getString("Name");

            JSONObject country =datosBD.getJSONObject("CountryCodes");
            String ruta=country.getString("iso2");

            JSONObject coordenadas = datosBD.getJSONObject("GeoRectangle");
            String west=coordenadas.getString("West");
            String east=coordenadas.getString("East");
            String north=coordenadas.getString("North");
            String south=coordenadas.getString("South");

            pais.add(new Paises(nombre,ruta,west,east,north,south));
        }

        return pais;
    }
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getUrlpais() {
        return urlpais;
    }

    public void setUrlpais(String urlpais) {
        this.urlpais = urlpais;
    }

    public String getOeste() {
        return oeste;
    }

    public void setOeste(String oeste) {
        this.oeste = oeste;
    }

    public String getEste() {
        return este;
    }

    public void setEste(String este) {
        this.este = este;
    }

    public String getNorte() {
        return norte;
    }

    public void setNorte(String norte) {
        this.norte = norte;
    }

    public String getSur() {
        return sur;
    }

    public void setSur(String sur) {
        this.sur = sur;
    }
}
