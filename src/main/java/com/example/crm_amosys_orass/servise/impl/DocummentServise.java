package com.example.crm_amosys_orass.servise.impl;
import com.example.crm_amosys_orass.mapper.DocumentMapper;
import com.example.crm_amosys_orass.model.ClientEntity;
import com.example.crm_amosys_orass.model.DocumentationEntity;
import com.example.crm_amosys_orass.repository.ClientRepository;
import com.example.crm_amosys_orass.repository.DocumentationRepository;
import com.example.crm_amosys_orass.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocummentServise {
    @Autowired
    private DocumentationRepository documentationRepository;
    @Autowired
    private DocumentMapper documentMapper ;
    @Autowired
    private ClientEntity clientEntity;

    @Autowired
    private ClientRepository clientRepository ;
   /* public String uploadImage(MultipartFile file) throws IOException {
        DocumentationEntity documentationEntity = new DocumentationEntity();
        documentationEntity.setFils(FileUtils.compressFile(file.getBytes()));
        documentationEntity.setName(file.getOriginalFilename());
        ProduitEntity produit =produitRepository.findById(idDocument).get();
        produit.setId(3L);
        documentationEntity.setProduits(produit);
        documentationEntity.setType(file.getContentType());
        DocumentationEntity imageData = documentationRepository.save(documentationEntity);
        ProduitEntity encadrantPFE =produitRepository.findById(idDocument).get();
        encadrantPFE.setListe(FileUtils.compressFile(file.getBytes()));
        ProduitEntity g = produitRepository.save(encadrantPFE);
     //
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }
    //*/
    public byte[] downloadImage(String fileName){
        Optional<DocumentationEntity> dbImageData = documentationRepository.findByName(fileName);
        byte[] images= FileUtils.decompressFile(dbImageData.get().getFils());
        return images;
    }


 /*   public DocumentationEntity createDocumentForClient(Long idClient, String name, String type, byte[] file) {
        ClientEntity client = clientRepository.findById(idClient).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        DocumentationEntity document = DocumentationEntity.builder()
                .name(name)
                .type(type)
                .fils(file)
                .client(client)
                .build();
        return documentationRepository.save(document);
    }*/



}
