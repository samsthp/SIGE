public class Documento {
    private int id;
    private String titulo;
    private String conteudo;
    private StatusDocumento status;

    public Documento(int id, String titulo, String conteudo) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.status = StatusDocumento.PENDENTE;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getConteudo() { return conteudo; }
    public StatusDocumento getStatus() { return status; }

    public void setStatus(StatusDocumento status) {
        this.status = status;
    }
}