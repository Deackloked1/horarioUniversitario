package com.stomas.horariouniversitario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    //Declaro Variables que el usuario utilizara
    private EditText usuarioEditText;
    private EditText contraseñaEditText;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlazo las variables con los id correspondientes del activity_main
        usuarioEditText = findViewById(R.id.usuario);
        contraseñaEditText = findViewById(R.id.contraseña);
        spinner = findViewById(R.id.spinnerRoles);
        //Arreglo de elementos que apareceran en mis Spinner
        String[] roles = {"Administrador", "Usuario"};
        //Creamos un ArrayAdapter para poblar el spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roles);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Asigna el Arrayadapter al Spinner
        spinner.setAdapter(adapter);
    }

    //Este metodo sera llamado cuando se haga clic en el boton de ligin tiene que ser el mismo nombre del onClick
    public void onClickAcceder(View view) {
        //Declaramos variables para obtener los valores ingresados en los campos
        String user = usuarioEditText.getText().toString().trim();
        String pass = contraseñaEditText.getText().toString().trim();
        String rol =spinner.getSelectedItem().toString();
        //Si esta vacio saltara un Toast
        if(user.isEmpty()) {
            Toast.makeText(this, "El campo de usuario esta vacio", Toast.LENGTH_SHORT).show();
            return;
        }
        //Si esta vacio saltara un Toast
        if(pass.isEmpty()) {
            Toast.makeText(this, "el campo de contraseña esta vacio", Toast.LENGTH_SHORT);
        }
        //Verifico las credeciales y dependiendo del usuario me enviara a diferentes activitys
        if(user.equals("usuario1") && pass.equals("1234") && rol.equals("Usuario")) {
            //Inicio una actividad que se realizara en la clase AccesoActivity
            Intent intent = new Intent(this, AccesoActivity.class);
            startActivity(intent);
        }
        //Si nada es valido, saltara una alerta
        else {
            Toast.makeText(this, "Credenciales Incorrectas", Toast.LENGTH_SHORT).show();
        }
    }
}