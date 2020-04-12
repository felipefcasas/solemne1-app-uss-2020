package com.example.solemne1ncfvff;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.content.res.ResourcesCompat;

        import android.content.Intent;
        import android.graphics.Typeface;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    public static final String seleccion = "seleccion";
    public static final String metodo = "metodo";

    private Button efectivoButton, tarjetaButton, enviarButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        this.efectivoButton = (Button)findViewById(R.id.efectivoButton);
        this.efectivoButton.setOnClickListener(onEfectivoButtonClicked);

        this.tarjetaButton = (Button)findViewById(R.id.tarjetaButton);
        this.tarjetaButton.setOnClickListener(onTarjetaButtonClicked);

        this.enviarButton = (Button)findViewById(R.id.enviarButton);
        this.enviarButton.setOnClickListener(onEnviarButtonClicked);
        this.enviarButton.setVisibility(View.INVISIBLE);

        Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.leadcoat);

        Intent intent = getIntent();

        String seleccion = intent.getExtras().getString(MainActivity.seleccion);
        TextView seleccionTextView = (TextView)findViewById(R.id.seleccion);
        seleccionTextView.setWidth(60);
        seleccionTextView.setTextSize(30);
        seleccionTextView.setTypeface(typeface);
        seleccionTextView.setText(seleccion);

        TextView metodoTextView = (TextView)findViewById(R.id.metodo);
        metodoTextView.setWidth(60);
        metodoTextView.setTextSize(30);
        metodoTextView.setTypeface(typeface);
        metodoTextView.setText("Por definir");
    }

    private View.OnClickListener onEfectivoButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView metodoTextView = (TextView)findViewById(R.id.metodo);
            metodoTextView.setText("Efectivo");

            Button enviarButton = (Button)findViewById(R.id.enviarButton);
            enviarButton.setVisibility(View.VISIBLE);

            Toast.makeText(getApplicationContext(),"Seleccionaste pago en efectivo!",Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener onTarjetaButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView metodoTextView = (TextView)findViewById(R.id.metodo);
            metodoTextView.setText("Tarjeta");

            Button enviarButton = (Button)findViewById(R.id.enviarButton);
            enviarButton.setVisibility(View.VISIBLE);

            Toast.makeText(getApplicationContext(),"Seleccionaste pago con tarjeta!",Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener onEnviarButtonClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            TextView seleccion = (TextView)findViewById(R.id.seleccion);
            TextView metodoTextView = (TextView)findViewById(R.id.metodo);
            Intent intent = new Intent(view.getContext(), Main3Activity.class);
            intent.putExtra(Main2Activity.seleccion, seleccion.getText());
            intent.putExtra(Main2Activity.metodo, metodoTextView.getText());
            startActivity(intent);
        }
    };
}
