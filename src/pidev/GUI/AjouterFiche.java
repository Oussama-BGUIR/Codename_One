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
import pidev.entities.Fiche;
import pidev.services.ServiceFiche;
/**
 *
 * @author user
 */
public class AjouterFiche extends Form  {
    
    public AjouterFiche(Form previous){

        setTitle("Ajouter Fiche");
        setLayout(BoxLayout.y());
        TextField tfnom = new TextField("","Nom du nutrtionniste");
        TextField tfPrenom = new TextField("","Prenom nutrtionniste");
         TextField tfNumtel = new TextField("","Numero nutrtionniste");
         TextField tfEmail = new TextField("","Email nutrtionniste");
          TextField tfDescription = new TextField("","Description des Fiches");
        Button btnadd =new Button("add Fiche");


        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                //tester si le champs nom est vide
                if(tfnom.getText().length()==0 && tfPrenom.getText().length()==0&& tfNumtel.getText().length()==0 && tfEmail.getText().length()==0&& tfDescription.getText().length()==0){
                    Dialog.show("Alert","please fill all the fiels","ok",null);
                }
                else{




                    Fiche c = new Fiche(tfnom.getText(),tfPrenom.getText(),tfEmail.getText(),tfDescription.getText());
                    if(ServiceFiche.getinstance().addTask(c)){
                        Dialog.show("Alert","ajouté avec succés","ok",null);
                    }else {
                        Dialog.show("Alert","erreur ","ok",null);
                    }

                }
            }
        });
        addAll(tfnom,tfPrenom,tfNumtel,tfEmail,tfDescription, btnadd);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_KEYBOARD_ARROW_LEFT, ev->previous.show());


    }

   
    }


