package ledare.com.br.firedroid.model;

import java.io.Serializable;

/**
 * Created by mateus on 15/09/2016.
 */
public class Projeto implements Serializable {
    public Projeto() {}

    private String id;
    private String titulo;
    private String descricao;
    private String imagem;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
