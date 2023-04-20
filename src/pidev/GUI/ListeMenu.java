package pidev.GUI;

import com.codename1.ui.CheckBox;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import pidev.entities.Menu;
import pidev.services.ServiceMenu;

import java.util.ArrayList;

public class ListeMenu extends Form {
    public ListeMenu(Form previous , Resources res){
        
                this.getAllStyles().setBgImage(res.getImage("elitegym.jpg"));

        setTitle("Liste menu");
        setLayout(BoxLayout.y());

        ArrayList<Menu> menu = ServiceMenu.getinstance().getAllMenus();


        for (Menu i :menu){
            addMenu(i);
        }
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_KEYBOARD_ARROW_LEFT, ev->previous.show());




    }

    public void addMenu(Menu t) {
        CheckBox cb = new CheckBox(t.getNom());
        cb.setEnabled(false);
        if(t.getId()!=0){
            cb.setEnabled(true);

        }
        add(cb);


    }}