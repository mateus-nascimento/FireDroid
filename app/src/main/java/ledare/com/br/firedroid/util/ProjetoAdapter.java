package ledare.com.br.firedroid.util;

import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

import ledare.com.br.firedroid.R;
import ledare.com.br.firedroid.model.Projeto;

/**
 * Created by mateus on 16/09/2016.
 */
public class ProjetoAdapter extends FirebaseRecyclerAdapter<Projeto, ProjetoHolder> {

    private ProjetoListner mListner;

    public ProjetoAdapter(Query ref, ProjetoListner listner) {
        super(Projeto.class, R.layout.item_projeto, ProjetoHolder.class, ref);
        mListner = listner;
    }

    @Override
    protected void populateViewHolder(ProjetoHolder viewHolder, Projeto model, int position) {
        viewHolder.setProjeto(model);
    }

    @Override
    public ProjetoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final ProjetoHolder holder = super.onCreateViewHolder(parent, viewType);

        holder.mBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListner != null){
                    int position = holder.getAdapterPosition();
                    Projeto projeto = getItem(position);
                    projeto.setId(getRef(position).getKey());
                    mListner.onProjetoSelected(projeto);
                }
            }
        });
        return holder;
    }
}
