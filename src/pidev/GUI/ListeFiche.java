/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;
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

import java.io.IOException;
import java.util.ArrayList;
import pidev.entities.Fiche;
import pidev.GUI.ServiceFiche;

/**
 *
 * @author Andrew
 */
public class ListeFiche extends Form {
    public ListeFiche(Form previous){
        setTitle("Liste fiche");
        setLayout(BoxLayout.y());

        ArrayList<Fiche> fiche = ServiceFiche.getinstance().getAllFiche();


        for (Fiche i :fiche){
            addFiche(i);
        }
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_KEYBOARD_ARROW_LEFT, ev->previous.show());




    }

   public void addFiche(Fiche f) {
    Button b2 = new Button(f.getNom());
    b2.getAllStyles().setBgColor(0xADD8E6); // fond rouge
    b2.getAllStyles().setFgColor(0x000000); // texte blanc
    b2.getAllStyles().setBorder(Border.createDashedBorder(2, 0xffffff)); // bordure arrondie
    b2.getAllStyles().setPaddingUnit(Style.UNIT_TYPE_DIPS);
    b2.getAllStyles().setPadding(2, 2, 2, 2);
    b2.requestFocus();

    Button b1 = new Button(f.getNom());
    // paddin

    b2.addActionListener(evt -> {
Dialog.show(f.getNom(),"Description : " + f.getDescription(), "Ok",null  );    });
    add(b2);
}
}