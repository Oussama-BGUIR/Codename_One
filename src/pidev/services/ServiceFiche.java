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
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.List;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.plaf.StyleParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import pidev.entities.Fiche;
import pidev.utils.Statics;



/**
 *
 * @author Andrew
 */
public class ServiceFiche {

    ArrayList<Fiche> fiche;
    ConnectionRequest req;
    boolean resultOk;
    public boolean test;
    //créer un attribut instance de type de la classe en question (static)
    public static ServiceFiche instance = null;

    // rendre le constructeur private pour instancier une seule fois
    private ServiceFiche() {
        req = new ConnectionRequest();
    }
    //s'il est null donc elle crée une instance
    public static ServiceFiche getinstance(){
        if(instance == null){
            instance = new ServiceFiche();
        }
        return instance;
    }

    public boolean addfiche(Fiche r){
        String nom=r.getNom();
        String Desc=r.getDescription();
        String prenom=r.getPrenom();
         String email=r.getEmail();
          int numtel=r.getNumtel();
        String url = Statics.BASE_URL+"addnewFiche?nom="+ r.getNom() + "&prenom="+ r.getPrenom()+"&email="+ r.getEmail()+ "&numero="+ r.getNumtel()+"&description="+ r.getDescription();
        String requestBody = "  {\"nom\":\""+nom+"\",\"description\":\""+Desc+"\"}  ";

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

    
    /*
 public boolean UpdateProduit(Fiche cp){
        String nom=cp.getNom();
        String description=cp.getDescription();
       
        int id = cp.getId();
        
        String url = Statics.BASE_URL+"categorie/updatecat/"+id+"/"+nom+"/"+description+"/";
        
        
        req.setUrl(url);
        //GET =>
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200; //si le code return 200 
                //
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOk;
        
        
        
    }
    */
    /*
    public boolean deleteExercice(int id) {
    String url =  Statics.BASE_URL+"categorie/deleteCategorie/" + id;
    ConnectionRequest request = new ConnectionRequest(url);
    request.setHttpMethod("DELETE");

    request.addResponseListener(e -> {
      
        resultOk = request.getResponseCode() == 200;
        
       
    });

    NetworkManager.getInstance().addToQueue(request);
            return resultOk;

}

*/

    public ArrayList<Fiche> parseTasks(String jsonText) {
        try {
            fiche = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            System.out.println("map="+tasksListJson);

            java.util.List<Map<String, Object>> list = (java.util.List<Map<String, Object>>) tasksListJson.get("root");
            System.out.println("map="+list);


            for (Map<String, Object> obj : list) {
                Fiche a = new Fiche();
                float id = Float.parseFloat(obj.get("id").toString());

                System.out.println(id);

                a.setId((int)id);

                a.setNom(obj.get("nom").toString());
                a.setDescription(obj.get("description").toString());

                fiche.add(a);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return fiche;
    }


    //methode d'affichage
    public ArrayList<Fiche> getAllFiche(){
        String url = Statics.BASE_URL+"AllFiche";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                fiche = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);


        return fiche;
    }
}