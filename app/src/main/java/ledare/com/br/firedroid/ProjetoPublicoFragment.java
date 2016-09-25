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

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import ledare.com.br.firedroid.databinding.FragmentProjetoPublicoBinding;
import ledare.com.br.firedroid.model.Projeto;
import ledare.com.br.firedroid.util.ProjetoAdapter;
import ledare.com.br.firedroid.util.ProjetoHolder;
import ledare.com.br.firedroid.util.ProjetoListner;


public class ProjetoPublicoFragment extends Fragment {
    public ProjetoPublicoFragment() {}

    private FirebaseAuth mAuth;
    private FirebaseStorage mStorage;
    private FirebaseDatabase mDatabase;
    private StorageReference mStorageRef;
    private DatabaseReference mReference;
    private FragmentProjetoPublicoBinding mBinding;
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
        mBinding = DataBindingUtil.inflate( inflater, R.layout.fragment_projeto_publico, container, false);
        if(mAuth.getCurrentUser() != null){
            initialize();
        }
        return mBinding.getRoot();
    }

    private void initialize() {
        mStorage = FirebaseStorage.getInstance();
        mStorageRef = mStorage.getReferenceFromUrl("gs://firedroid-e9e32.appspot.com");
        mDatabase = FirebaseDatabase.getInstance();
        mReference = mDatabase.getReference(getString(R.string.projetos_publicos));
        mBinding.recyclerViewPublico.setHasFixedSize(true);
        mBinding.recyclerViewPublico.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new ProjetoAdapter(mReference, new ProjetoListner() {
            @Override
            public void onProjetoSelected(Projeto projeto) {
                Intent intent = new Intent(getContext(), ProjetoActivity.class);
                intent.putExtra(ProjetoActivity.projeto_detail, projeto);
                startActivity(intent);
            }
        });
        mBinding.recyclerViewPublico.setAdapter(mAdapter);
    }
}
