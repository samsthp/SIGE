package com.sigecertificado.sige_emissao_certificado_estagio.emitircertificado;

import com.sigecertificado.sige_emissao_certificado_estagio.model.Certificado;
import com.sigecertificado.sige_emissao_certificado_estagio.repository.CertificadoRepository;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmitirCertificado {
    @Autowired
    private CertificadoRepository repository;
    
    public byte[] emitirPdf(Long Id) {
        Certificado certificado = repository.getById(Id);
        ByteArrayOutputStream armazenar = new ByteArrayOutputStream();
        try{
            PDDocument documento = new PDDocument();
            PDPage pagina = new PDPage(PDRectangle.A4);
            documento.addPage(pagina);
            PDPageContentStream conteudo = new PDPageContentStream(documento, pagina);
            conteudo.beginText();
            conteudo.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 12);
            conteudo.newLineAtOffset(20, 750);
            conteudo.showText(certificado.getEmpresa() + "confere este certificado a " + certificado.getNome() + "por ter concluído seu estágio com sucesso." );
            conteudo.newLineAtOffset(0, -20);
            conteudo.showText(certificado.getDataEmissao().toString());
            conteudo.endText();
            conteudo.close();   
            documento.save(armazenar);
            return armazenar.toByteArray();
        }catch(IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }  
}
