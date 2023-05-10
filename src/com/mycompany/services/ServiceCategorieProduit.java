/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

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
import com.mycompany.entities.CategorieProduit;
import com.mycompany.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;



/**
 *
 * @author Andrew
 */
public class ServiceCategorieProduit {

    ArrayList<CategorieProduit> categorie;
    ConnectionRequest req;
    boolean resultOk;
    public boolean test;
    //créer un attribut instance de type de la classe en question (static)
    public static ServiceCategorieProduit instance = null;

    // rendre le constructeur private pour instancier une seule fois
    private ServiceCategorieProduit() {
        req = new ConnectionRequest();
    }
    //s'il est null donc elle crée une instance
    public static ServiceCategorieProduit getinstance(){
        if(instance == null){
            instance = new ServiceCategorieProduit();
        }
        return instance;
    }

    public boolean addCategorie(CategorieProduit r){
        String nom=r.getNom();
        String Desc=r.getDescription();
        String url = Statics.BASE_URL+"categorie/addnewcat?nom="+ r.getNom() + "&description="+ r.getDescription();
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

    
    
 public boolean UpdateProduit(CategorieProduit cp){
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



    public ArrayList<CategorieProduit> parseTasks(String jsonText) {
        try {
            categorie = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            System.out.println("map="+tasksListJson);

            java.util.List<Map<String, Object>> list = (java.util.List<Map<String, Object>>) tasksListJson.get("root");
            System.out.println("map="+list);


            for (Map<String, Object> obj : list) {
                CategorieProduit a = new CategorieProduit();
                float id = Float.parseFloat(obj.get("id").toString());

                System.out.println(id);

                a.setId((int)id);

                a.setNom(obj.get("nom").toString());
                a.setDescription(obj.get("description").toString());

                categorie.add(a);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return categorie;
    }


    //methode d'affichage
    public ArrayList<CategorieProduit> getAllCategories(){
        String url = Statics.BASE_URL+"categorie/Allcategories";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                categorie = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);


        return categorie;
    }

 public boolean UpdateCategorie(CategorieProduit e){
        String nom=e.getNom();
        String description=e.getDescription();
     
        int id = e.getId();
        
        String url = Statics.BASE_URL+"categorie/updatecat/"+id+"/"+nom+"/"+description;
        
        
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
}