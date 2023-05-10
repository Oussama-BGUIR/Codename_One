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
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.IconHolder;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.mycompany.entities.CategorieProduit;
import com.mycompany.services.ServiceCategorieProduit;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class ListeCategorie extends Form {
    public ListeCategorie(Form previous){
        setTitle("Liste categorie");
        setLayout(BoxLayout.y());

        ArrayList<CategorieProduit> categorie = ServiceCategorieProduit.getinstance().getAllCategories();


        for (CategorieProduit i :categorie){
            addCategorie(i);
        }
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_KEYBOARD_ARROW_LEFT, ev->previous.show());




    }

    public void addCategorie(CategorieProduit t) {
        Button b = new Button(t.getNom());
        b.getAllStyles().setBgColor(0xADD8E6); // fond rouge
        b.getAllStyles().setFgColor(0x000000); // texte blanc
        b.getAllStyles().setBorder(Border.createDashedBorder(2, 0xffffff)); // bordure arrondie
        b.getAllStyles().setPaddingUnit(Style.UNIT_TYPE_DIPS);
        b.getAllStyles().setPadding(2, 2, 2, 2);
        b.requestFocus();

        Button b1 = new Button(t.getNom());
// paddin

        b.addActionListener(evt -> {

          
    
    
    
    
    Dialog.show(t.getNom(),"Description : " + t.getDescription(), "Ok",null  );
   
        });
        add(b);
    }


    }