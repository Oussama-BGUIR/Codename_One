package pidev.services;


import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.List;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.StyleParser;
import com.codename1.util.BigDecimal;
import pidev.entities.Menu;
import pidev.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;



/**
 *
 * @author Andrew
 */
public class ServiceMenu {

    ArrayList<Menu> menu;
    ConnectionRequest req;
    boolean resultOk;
    public boolean test;
    //créer un attribut instance de type de la classe en question (static)
    public static ServiceMenu instance = null;

    // rendre le constructeur private pour instancier une seule fois
    private ServiceMenu() {
        req = new ConnectionRequest();
    }
    //s'il est null donc elle crée une instance
    public static ServiceMenu getinstance(){
        if(instance == null){
            instance = new ServiceMenu();
        }
        return instance;
    }

    //methode d'ajout
    public boolean addTask(Menu r){


        String nom=r.getNom();
        String description=r.getDescription();
        int calorie = r.getCalorie();
        int disponibilite = r.getDisponibilite() ;
        System.err.println(disponibilite);

        String url = Statics.BASE_URL+"menu/addmenu?nom="+ r.getNom() + "&description="+ r.getDescription() + "&calorie="+ r.getCalorie() + "&disponibilite="+ r.getDisponibilite();
        String requestBody = "  {\"nom\":\""+nom+"\",\"description\":\""+description+"\",\"calorie\":\""+calorie+"\",\"disponibilite\":\""+disponibilite+"\"}  ";

        req.setUrl(url);
        req.setPost(true);
        req.setHttpMethod("POST");
        req.setRequestBody(requestBody);

        System.out.println(req.getRequestBody());
        req.setContentType("application/json");

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200;
                //
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOk;



    }




    public ArrayList<Menu> parseTasks(String jsonText) {
        try {
            menu = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            System.out.println("map="+tasksListJson);

            java.util.List<Map<String, Object>> list = (java.util.List<Map<String, Object>>) tasksListJson.get("root");
            System.out.println("map="+list);


            for (Map<String, Object> obj : list) {
                Menu a = new Menu();
                float id = Float.parseFloat(obj.get("id").toString());

                System.out.println(id);

                a.setId((int)id);

                a.setNom(obj.get("nom").toString());

                menu.add(a);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return menu;
    }


    //methode d'affichage
    public ArrayList<Menu> getAllMenus(){
        String url = Statics.BASE_URL+"menu/allmenu";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                menu = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);


        return menu;
    }


}