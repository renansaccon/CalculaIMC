package saccon.renan.br.calculaimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText peso;
    private EditText altura;
    private TextView imc;
    private Button btLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // o onCreate é onde tudo é inicializado antes do usuário utilizar o programa
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //diz que ele está comandando a tela do aplicativo

        peso = findViewById(R.id.peso); //recupera o valor que foi inserido na tela
        altura = findViewById(R.id.altura);
        imc = findViewById(R.id.imc);
        btLimpar = findViewById(R.id.btLimpar);



        btLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btLimparOnClick();
            }
        });

    }

    public void btCalcularOnClick(View v) {

        if (peso.getText().toString().isEmpty()) {
            peso.setError("Favor preencher o peso");
            peso.requestFocus();
            return;
        }

        if (altura.getText().toString().isEmpty()) {
            altura.setError("Favor preencher a altura");
            altura.requestFocus();
            return;
        }

        double vlPeso = Double.parseDouble(peso.getText().toString());
        double vlAltura = Double.parseDouble(altura.getText().toString());
        double vlImc = (vlPeso / (vlAltura * vlAltura));

        DecimalFormat df = new DecimalFormat("0.00"); //define a forma que será mostrado
        imc.setText(df.format(vlImc));

    }

    private void btLimparOnClick() {
        peso.setText("");
        altura.setText("");
        imc.setText("0.0");
        peso.requestFocus();
    }

}
    