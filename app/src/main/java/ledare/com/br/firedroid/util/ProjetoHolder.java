package ledare.com.br.firedroid.util;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import ledare.com.br.firedroid.databinding.ItemProjetoBinding;
import ledare.com.br.firedroid.model.Projeto;

/**
 * Created by ultrabook on 15/09/2016.
 */
public class ProjetoHolder extends RecyclerView.ViewHolder{
    ItemProjetoBinding mBinding;

    public ProjetoHolder(View view) {
        super(view);
        mBinding = DataBindingUtil.bind(view);
    }

    public void setProjeto(Projeto projeto) {
        mBinding.setProjeto(projeto);
    }

}