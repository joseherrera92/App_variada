package com.app_variada;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.widget.Button;
import android.provider.Settings;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    Button google, alarma, llamada, mensaje, wifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        google = findViewById(R.id.Google);
        alarma = findViewById(R.id.Alarma);
        llamada = findViewById(R.id.Telefono);
        mensaje = findViewById(R.id.Mensajetxt);
        wifi = findViewById(R.id.Wifi);

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IraGoogle = new Intent(Intent.ACTION_VIEW);
                IraGoogle.setData((Uri.parse("http://www.googgle.com")));
                startActivity(IraGoogle);

            }
        });

        alarma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent alarma = new Intent(AlarmClock.ACTION_SET_ALARM);
                alarma.putExtra(AlarmClock.EXTRA_MESSAGE,"despierte");
                alarma.putExtra(AlarmClock.EXTRA_HOUR, 18);
                alarma.putExtra(AlarmClock.EXTRA_MINUTES, 30);
                startActivity(alarma);
            }

        });

        llamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IraLlamada = new Intent(Intent.ACTION_DIAL);
                IraLlamada.setData(Uri.parse("tel:" + "3137551014"));
                if (IraLlamada.resolveActivity(getPackageManager()) != null) {
                    startActivity(IraLlamada);
                }
            }
        });

        mensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("smsto:+123456789"));
                intent.putExtra("sms_body", "Hola, ¿cómo estás?");
                startActivity(intent);

            }
        });

        wifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wifi = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(wifi);

        }
    });
    }
}
