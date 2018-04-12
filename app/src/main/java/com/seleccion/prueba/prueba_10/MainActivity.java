package com.seleccion.prueba.prueba_10;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvLibros;
    EditText editB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvLibros=(ListView) this.findViewById(R.id.listLibros);
        ComunicacionTask com=new ComunicacionTask();
        com.execute("https://api.myjson.com/bins/146e79");

    }

    private class ComunicacionTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... params) {
            String cadenaJson="";
            try{
                URL url=new URL(params[0]);
                URLConnection con=url.openConnection();
                String s; //?
                InputStream is=con.getInputStream();
                BufferedReader bf=new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                while((s=bf.readLine())!=null){
                    cadenaJson+=s;
                }

            }catch (Exception ex){
                ex.printStackTrace();
            }
            return cadenaJson;
        }

        protected void onPostExecute(String result){
            ArrayList<String> datosLibros=new ArrayList<String>();
            try {
                JSONObject jobj=new JSONObject(result);
                JSONArray jarray=jobj.getJSONArray("libro");

                for(int i=0; i<jarray.length();i++){
                    JSONObject job=jarray.getJSONObject(i);
                    String data = job.getString("titulo") + "|";
                    data += job.getString("editorial") + "|";
                    data += job.getInt("paginas");
                    datosLibros.add(data);
                }
                cargarLista(datosLibros);

            }catch (Exception ex){
                ex.printStackTrace();
            }

        }

        private void cargarLista(ArrayList<String> datos){
            ArrayAdapter<String> adp=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, datos);
            lvLibros.setAdapter(adp);
        }
    }

}
