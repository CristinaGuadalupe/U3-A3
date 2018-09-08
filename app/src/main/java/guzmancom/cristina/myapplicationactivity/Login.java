package guzmancom.cristina.myapplicationactivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import guzmancom.cristina.myapplicationactivity.daos.UsuariosDao;
import  guzmancom.cristina.myapplicationactivity.models.Usuario;

public class Login extends Activity {
    EditText usuario,password;
    Button btnLogin;
    TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario=(EditText) findViewById(R.id.txtUsuario);
        password=(EditText)findViewById(R.id.txtpassword);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        titulo=(TextView)findViewById(R.id.txtTitulo);
        titulo.setText(getIntent().getStringExtra("titulo"));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UsuariosDao dao=new UsuariosDao();
                boolean resultado = dao.usuarioExist(new Usuario(usuario.getText().toString(),password.getText().toString()));
                Intent respuesta=new Intent();
                respuesta.putExtra("resultado",resultado);
                setResult(MainActivity.LOGIN_INTENT_CODE,respuesta);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}
