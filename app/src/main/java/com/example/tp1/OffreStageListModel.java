package com.example.tp1;

public class OffreStageListModel {
 private String companyName;
 private String email;
 private String contact;
 private String poste;
 private String adresse;
 private String ville;
 private String codePostal;
 private int telephone;


 public OffreStageListModel(String companyName, String email,String contact,int telephone, String codePostal, String adresse,String ville,String poste){
     this.companyName = companyName;
     this.email = email;
     this.contact = contact;
     this.codePostal = codePostal;
     this.ville = ville;
     this.adresse = adresse;
     this.poste = poste;
     this.telephone = telephone;
 }
    public OffreStageListModel(String companyName,String poste){
        this.companyName = companyName;

        this.poste = poste;

    }

 public String getCompanyName() {return companyName;}

 public String getEmail(){return  email;}

 public  String getContact(){return contact;}

    public  String getVille(){return ville;}

    public String getPoste(){return poste;}

    public String getCodePostal(){return codePostal;}

    public int getTelephone(){return telephone;}

    public String getAdresse(){return adresse;}

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
