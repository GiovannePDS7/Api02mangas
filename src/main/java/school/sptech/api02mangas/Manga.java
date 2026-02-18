package school.sptech.api02mangas;

public class Manga {

    private String nome;
    private String autor;
    private Integer qtdVolumes;
    private String editora;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getQtdVolumes() {
        return qtdVolumes;
    }

    public void setQtdVolumes(Integer qtdVolumes) {
        this.qtdVolumes = qtdVolumes;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}
