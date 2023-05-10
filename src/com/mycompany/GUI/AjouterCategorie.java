/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

/**
 *
 * @author LENOVO
 */
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entities.CategorieProduit;
import com.mycompany.services.ServiceCategorieProduit;


/**
 *
 * @author Andrew
 */
public class AjouterCategorie  extends Form{
    public AjouterCategorie(Form previous){

        setTitle("Ajouter categorie");
        setLayout(BoxLayout.y());
        TextField tfnom = new TextField("","Nom de catégorie");
        TextField tfDescription = new TextField("","Description de catégorie");
        Button btnadd =new Button("Ajouter ");


        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //tester si le champs nom est vide
                if(tfnom.getText().length()==0 && tfDescription.getText().length()==0){
                    Dialog.show("Alert","please fill all the fiels","ok",null);
                }
                else{




                    CategorieProduit c = new CategorieProduit(tfnom.getText(),tfDescription.getText());
                    if(ServiceCategorieProduit.getinstance().addCategorie(c)){
                        Dialog.show("Succes","Categorie ajoutée avec succes","ok",null);
                    }else {
                        Dialog.show("Alert","erreur ","ok",null);
                    }

                }
            }
        });
        addAll(tfnom,tfDescription,btnadd);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_KEYBOARD_ARROW_LEFT, ev->previous.show());


    }


}