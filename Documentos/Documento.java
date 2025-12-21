import jakarta.persistence.*;

@Entity
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String conteudo;

    @Enumerated(EnumType.STRING)
    private StatusDocumento status = StatusDocumento.PENDENTE;

    public Documento() {}

    public Documento(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.status = StatusDocumento.PENDENTE;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getConteudo() { return conteudo; }
    public StatusDocumento getStatus() { return status; }

    public void setStatus(StatusDocumento status) {
        this.status = status;
    }
}
