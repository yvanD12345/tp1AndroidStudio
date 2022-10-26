package com.example.tp1;

public class OffreStageListModel {
 private String companyName;
 private String email;
 private String contact;

 public OffreStageListModel(String companyName, String email,String contact){
     this.companyName = companyName;
     this.email = email;
     this.contact = contact;
 }
 public String getCompanyName() {return companyName;}

 public String getEmail(){return  email;}

 public  String getContact(){return contact;}



}
