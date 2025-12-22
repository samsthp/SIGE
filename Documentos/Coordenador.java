public class Coordenador {
    private String nome;

    public Coordenador(String nome) {
        this.nome = nome;
    }

    public void aprovarDocumento(Documento documento) {
        documento.setStatus(StatusDocumento.APROVADO);
        System.out.println("Documento \"" + documento.getTitulo() + "\" foi aprovado por " + nome + ".");
    }

    public void reprovarDocumento(Documento documento) {
        documento.setStatus(StatusDocumento.REPROVADO);
        System.out.println("Documento \"" + documento.getTitulo() + "\" foi reprovado por " + nome + ".");
    }

    public void visualizarDocumento(Documento documento) {
        System.out.println("\n==== Documento ====");
        System.out.println("Título: " + documento.getTitulo());
        System.out.println("Conteúdo: " + documento.getConteudo());
        System.out.println("Status atual: " + documento.getStatus());
    }
}