/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author shini
 */
public class Home extends Form{
    public Home(Resources res){
        this.getAllStyles().setBgImage(res.getImage("logo.jpg"));

        setTitle("Home");
        setLayout(BoxLayout.y());
        add(new Label("Les fiches des nutritionnistes"));
        //ajouter deux boutons d'ajout et d'affichage
        Button b1 = new Button("Ajouter fiche");
        Button b2 = new Button("Afficher fiche");
        //quand on clique sur le bouton de l'ajout, il va nous rediriger vers le formulaire de l'ajout
        b1.addActionListener(l -> new AjouterFiche(this).show());
        //quand on clique sur le bouton de l'affichage il va nous rediriger vers la liste des categories
        b2.addActionListener(l -> new ListeFiche(this ).show());
        addAll(b1,b2);

    }
    
}
