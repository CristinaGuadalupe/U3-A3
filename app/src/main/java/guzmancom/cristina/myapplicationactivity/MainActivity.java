package guzmancom.cristina.myapplicationactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


public class MainActivity extends Activity {
public static final int LOGIN_INTENT_CODE=20;
public static final int ALUMNOS_INTENT_CODE=25;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent loginIntent=new Intent(MainActivity.this,Login.class);
        loginIntent.putExtra("titulo","Bienvenido autenticate");
        startActivityForResult(loginIntent,LOGIN_INTENT_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==LOGIN_INTENT_CODE){
            // usuario
            boolean resultado=data.getBooleanExtra("resultado",false);
            if(resultado){
                Toast.makeText(this,"BIENVENIDO USUARIO",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"AUTENTICACION FALLIDA",Toast.LENGTH_LONG).show();
            }

        }
    }
}
