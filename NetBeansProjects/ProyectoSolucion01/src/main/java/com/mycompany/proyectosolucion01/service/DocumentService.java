/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectosolucion01.service;

import com.mycompany.proyectosolucion01.data.entity.Asignatura;
import com.mycompany.proyectosolucion01.data.entity.Directorio;
import com.mycompany.proyectosolucion01.data.entity.Disco;
import com.mycompany.proyectosolucion01.data.entity.Documento;
import com.mycompany.proyectosolucion01.data.entity.Programa;
import com.mycompany.proyectosolucion01.data.entity.TipoDisco;
import com.mycompany.proyectosolucion01.data.entity.TipoDocumento;
import com.mycompany.proyectosolucion01.data.repository.AsignaturaRespository;
import com.mycompany.proyectosolucion01.data.repository.DirectorioRepository;
import com.mycompany.proyectosolucion01.data.repository.DocumentoRepository;
import com.mycompany.proyectosolucion01.data.repository.ProgramaRepository;
import com.mycompany.proyectosolucion01.data.repository.TipoDocumentoRepository;
import java.util.List;

/**
 *
 * @author fercholeiva
 */
public class DocumentService {

    private DocumentoRepository documentoRepository = new DocumentoRepository();
    private DirectorioRepository directorioRepository=new DirectorioRepository();
    private TipoDocumentoRepository tipoDocumentoRepository=new TipoDocumentoRepository();
    private ProgramaRepository programaRepository=new ProgramaRepository();
    private AsignaturaRespository asignaturaRespository=new AsignaturaRespository();

  
    public Documento save(int idDisco, String nombreDirectorio, String  nombreTipoDocumento,
            String nombrePrograma, String nombreAsignatura, String nombreDocumento, 
            String fechaCreacion, String fechaModificaion, String comentario, String bytes) {
        
        Directorio directorio = directorioRepository.findByNombre(nombreDirectorio); 
        Asignatura asignatura = asignaturaRespository.findByNombre(nombreAsignatura);
        Programa programa= programaRepository.findByNombre(nombrePrograma);
        TipoDocumento tipoDocumento = tipoDocumentoRepository.findByNombre(nombreTipoDocumento);
  
        Documento documento=new Documento();
        documento.setDisco(new Disco(idDisco));
        documento.setDirectorio(directorio);    
        documento.setTipoDocumento(tipoDocumento);
        documento.setPrograma(programa);
        documento.setAsignatura(asignatura);
        documento.setNombre(nombreDocumento);
        documento.setFechacreacion(fechaCreacion);
        documento.setFechamodificacion(fechaModificaion);
        documento.setComentario(comentario);
        documento.setTamañobytes(bytes);
        
        System.out.println("saving document");
        documento = documentoRepository.save(documento);
        System.out.println("document saved with id:" + documento.getIdDOCUMENTO());
        return documento;
    }

    public List<Documento> getDocumentos() {
        System.out.println("getting documents");
        List<Documento> documentos=documentoRepository.findAll();
        System.out.println(documentos.size()+" documents found");
        return documentos;
    }

    /*
     int idDisco = Integer.parseInt(jComboBox1.getSelectedItem() + "");
        int idDirectorio = directorioDataBaseHandler.getIdByNameDirectorio(directorios, jComboBox2.getSelectedItem() + "");
        int idtipoDocumento = tipoDocumentoDataBaseHandler.getIdByNameTipoDocumento(tipoDocumentos, jComboBox5.getSelectedItem() + "");
        int idPrograma = programaDataBaseHandler.getIdByNamePrograma(programas, jComboBox3.getSelectedItem() + "");
        int idAsignatura = asignaturaDataBaseHandler.getIdByNameAsignatura(asignaturas, jComboBox4.getSelectedItem() + "");
       
       
    */
    
    
}
