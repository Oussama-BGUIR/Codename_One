package pidev.GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

public class Home extends Form {
       

    public Home(Resources res){
        
        
        
        this.getAllStyles().setBgImage(res.getImage("elitegym.jpg"));
        
        
        
        

        setTitle("Home");
        setLayout(BoxLayout.y());
        add(new Label("EliteGymCenter"));
        //ajouter deux boutons d'ajout et d'affichage
        Button b1 = new Button("Ajouter menu");
        Button b2 = new Button("Afficher menus");
        //quand on clique sur le bouton de l'ajout, il va nous rediriger vers le formulaire de l'ajout
        b1.addActionListener(l -> new AjouterMenu(this, res).show());
        //quand on clique sur le bouton de l'affichage il va nous rediriger vers la liste des categories
        b2.addActionListener(l -> new ListeMenu(this, res).show());
        addAll(b1,b2);

    }

}
