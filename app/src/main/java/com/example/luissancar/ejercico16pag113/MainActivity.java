package com.example.luissancar.ejercico16pag113;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText etCodigo, etNombre, etPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etCodigo=(EditText)findViewById(R.id.etCodigo);
        etNombre=(EditText)findViewById(R.id.etNombre);
        etPrecio=(EditText)findViewById(R.id.etPrecio);
    }

    public void alta(View view){


        String codigo=etCodigo.getText().toString();
        String nombre=etNombre.getText().toString();
        String precio=etPrecio.getText().toString();

        Exception ex = null;
        SQLiteDatabase db = null;
        boolean bTrans = false;
        try {
            AdminSQL admin = new AdminSQL(this, "basenombres", null, 1);
            db = admin.getWritableDatabase();
            db.beginTransaction();
            //bTrans = true;
            ContentValues registro = new ContentValues();
            registro.put("codigo", codigo);
            registro.put("descripcion", nombre);
            registro.put("precio", precio);
            db.insert("articulos", null, registro);

            db.setTransactionSuccessful();
            db.close();
            Toast.makeText(this,"Insertado",Toast.LENGTH_LONG).show();
        }
        catch ( android.database.sqlite.SQLiteConstraintException e){
            Toast.makeText(this,"Erro:"+e.getMessage().toString(),Toast.LENGTH_LONG).show();
            ex=e;
        }

        if (db != null) {
            if (bTrans != false)
                db.endTransaction();

            db.close();
        }

        if (ex != null)
            Toast.makeText(this,"Erro:"+ex.getMessage().toString(),Toast.LENGTH_LONG).show();;
            etCodigo.setText("");
            etNombre.setText("");
            etPrecio.setText("");





    }

    public void consulCodigo(View view){

    }

    public void consulDescripcion(View view){

    }
    public void baja(View view){

    }
    public void modificacion(View view){

    }
}
