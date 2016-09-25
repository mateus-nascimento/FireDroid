package ledare.com.br.firedroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import ledare.com.br.firedroid.model.Projeto;

public class ProjetoActivity extends AppCompatActivity {

    public static final String projeto_detail = "details";

    @Bind(R.id.textViewTitulo)
    TextView mTextTitulo;
    @Bind(R.id.textViewDescricao)
    TextView mTextDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projeto);
        ButterKnife.bind(this);

        Projeto projeto = (Projeto) getIntent().getSerializableExtra(projeto_detail);
        mTextTitulo.setText(projeto.getTitulo());
        mTextDescricao.setText(projeto.getDescricao());
        Log.d("Teste", projeto.getImagem());
    }
}
