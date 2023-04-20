/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.GUI;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import pidev.entities.Menu;
import pidev.services.ServiceMenu;
/**
 *
 * @author lobna
 */
public class AjouterMenu extends Form {
    public AjouterMenu(Form previous  , Resources res){
    this.getAllStyles().setBgImage(res.getImage("elitegym.jpg"));

   setTitle("Ajouter Menu");
        setLayout(BoxLayout.y());
        TextField tfnom = new TextField("","Nom de Menu !!");
        TextField tfDescription = new TextField("","Description de menu");
      /*  TextField tfCalorie = new TextField("","les calories disponibles"); */
        CheckBox cb = new CheckBox("Disponibilite");

        Button btnadd =new Button("add menu !!");


        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //tester si le champs nom est vide
                if(tfnom.getText().length()==0 && tfDescription.getText().length()==0 && cb.getText().length()==0){
                    Dialog.show("Alert","please fill all the fiels","ok",null);
                }
                else{

                    
                    int disponibilite =0 ; 
                    if(cb.isSelected())
                       disponibilite = 1 ;

                    Menu c = new Menu(tfnom.getText(),tfDescription.getText());
                    if(ServiceMenu.getinstance().addTask(c)){
                        Dialog.show("Alert","ajouté avec succés","ok",null);
                    }else {
                        Dialog.show("Alert","erreur ","ok",null);
                    }}

                }
            
        });
        addAll(tfnom,tfDescription,cb,btnadd);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_KEYBOARD_ARROW_LEFT, ev->previous.show());


    }


}