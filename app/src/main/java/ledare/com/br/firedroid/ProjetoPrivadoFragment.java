package ledare.com.br.firedroid;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import ledare.com.br.firedroid.databinding.FragmentProjetoPrivadoBinding;
import ledare.com.br.firedroid.model.Projeto;
import ledare.com.br.firedroid.util.ProjetoAdapter;
import ledare.com.br.firedroid.util.ProjetoHolder;
import ledare.com.br.firedroid.util.ProjetoListner;

public class ProjetoPrivadoFragment extends Fragment {
    public ProjetoPrivadoFragment(){}

    private FirebaseAuth mAuth;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private FragmentProjetoPrivadoBinding mBinding;
    private FirebaseRecyclerAdapter<Projeto, ProjetoHolder> mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate( inflater, R.layout.fragment_projeto_privado, container, false);
        if(mAuth.getCurrentUser() != null){
            initialize();
        }
        return mBinding.getRoot();
    }

    private void initialize() {
        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference(getString(R.string.projetos_privados));
        mBinding.recyclerViewPrivado.setHasFixedSize(true);
        mBinding.recyclerViewPrivado.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new ProjetoAdapter(mReference, new ProjetoListner() {
            @Override
            public void onProjetoSelected(Projeto projeto) {
                Intent intent = new Intent(getContext(), ProjetoActivity.class);
                intent.putExtra(ProjetoActivity.projeto_detail, projeto);
                startActivity(intent);
            }
        });
        mBinding.recyclerViewPrivado.setAdapter(mAdapter);
        mBinding.floatActionButton.setOnClickListener(new AdicionarProjeto());
    }

    private class AdicionarProjeto implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), "Adicionado", Toast.LENGTH_SHORT).show();
        }
    }
}
