package symatique.smartseller.services.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import symatique.smartseller.data.Articles.Article;
import symatique.smartseller.data.Articles.Domaine;
import symatique.smartseller.data.Stocks.BonDeSortie;
import symatique.smartseller.data.Stocks.BonDeSortiesResponse;
import symatique.smartseller.data.Utilisateurs.AuthenticationResponse;
import symatique.smartseller.data.Encaissements.Banque;
import symatique.smartseller.data.Articles.CategorieArticle;
import symatique.smartseller.data.Ventes.Client;
import symatique.smartseller.data.Commandes.Commande;
import symatique.smartseller.data.Articles.Entreprise;
import symatique.smartseller.data.Commandes.EtatCommande;
import symatique.smartseller.data.Ventes.NatureVente;
import symatique.smartseller.data.Factures.PrefixBL;
import symatique.smartseller.data.Factures.PrefixFacture;
import symatique.smartseller.data.Encaissements.TypeEncaissementVente;


public interface ApiRegister {

    public final  String CODE_LIVREUR = "codelivreur";
    public final  String DATE_SYNCHRO = "datesynchro";
    public final  String ID_LIVREUR = "idlivreur";
    public final  String ID_ENTREPRISE = "identreprise";
    public final  String ID_DOMAINE = "iddomaine";
    public final  String PWD_LIVREUR = "pwdlivreur";
    public final  String IMEI = "imei";
    public final  String APP_VERSION = "appversion";
    public final  String PREMIER_UTILISATION = "premierutilisation";
    public final  String DOMAIN =  "SmartSeller/RetrofitGet/";
    public final  String DOMAIN2 =  "SmartSeller/RetrofitSet/";

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/
//______________________________ AUTHENTICATION ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/autentification/379101/81dc9bdb52d04dc20036dbd8313ed055/0000/1.0     DONE with DATA

    @GET(DOMAIN + "autentification.php")
    Call<AuthenticationResponse> getAuthentificated(@Query(CODE_LIVREUR) String code, @Query(PWD_LIVREUR) String pwd, @Query(IMEI) String imei, @Query(APP_VERSION) String appVersion) ;

//______________________________ get ALL Bon Sortie ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/bonSorties/379101/378701/PREMIER_UTILISATION"    DONE with NO DATA

    @GET(DOMAIN + "bonSorties.php")
    Call<BonDeSortiesResponse> getBonSortie(@Query(ID_LIVREUR) String idLivreur, @Query(ID_ENTREPRISE) long idEntreprise, @Query(PREMIER_UTILISATION) boolean premier_utilisation);

//______________________________ update Prix Article ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/updatePrixArticle/379101/123313123       ERROR

    @GET(DOMAIN + "updatePrixArticle.php")
    Call<List<String>> updatePrixArticle(@Query(ID_LIVREUR) long idLivreur, @Query(DATE_SYNCHRO) long dateSynchro);

//______________________________ Get Prefixes Factures ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/prefixeFacture/379101/378701     DONE with NO DATA

    @GET(DOMAIN + "prefixeFacture.php")
    Call<List<PrefixFacture>> getPrefixsFacture(@Query(ID_LIVREUR) long idLivreur, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ Get Prefixes BL ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/prefixBonLivraison/379101/378701     DONE with NO DATA

    @GET(DOMAIN + "prefixBonLivraison.php")
    Call<List<PrefixBL>> getPrefixsBL(@Query(ID_LIVREUR) long idLivreur, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ update client ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/clients/123313123/378701

    @GET(DOMAIN + "clients.php")
    Call<List<Client>> getClients(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ update entreprise ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/domaines/123313123/378701   DONE with NO DATA

    @GET(DOMAIN + "domaines.php")
    Call<List<Entreprise>> synchDomaine(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ Articles ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/articles/123313123/378701    DONE with NO DATA with SOME HTML RESPONSE

    @GET(DOMAIN + "articles.php")
    Call<List<Article>> getArticles(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ Categories Articles ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/categorieArticles/123313123/378701

    @GET(DOMAIN + "categorieArticles.php")
    Call<List<CategorieArticle>> getAllCategory(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ Etat Commande ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/etatCommandes/123313123/378701

    @GET(DOMAIN + "etatCommandes.php")
    Call<List<EtatCommande>> getEtatCommande(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ Nature VISITE ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/synchroniserNatureVentes/123313123/378701

    @GET(DOMAIN + "synchroniserNatureVentes.php")
    Call<List<NatureVente>> synchroniserNatureVentes(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ SYNCHRO Type EncaissementVente ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/SynchroniserTypeEncaissementVente/123313123/378701

    @GET(DOMAIN + "SynchroniserTypeEncaissementVente.php")
    Call<List<TypeEncaissementVente>> synchroniserTypeEncaissementVente(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ SYNCHRO Synchroniser Banque ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/SynchroniserBanque/123313123/378701

    @GET(DOMAIN + "SynchroniserBanque.php")
    Call<List<Banque>> synchroniserBanque(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ SYNCHRO Commande ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/synchroniserVendeurCommande/378701/123313123     DONE with NO DATA

    @GET(DOMAIN + "synchroniserVendeurCommande.php")
    Call<List<Commande>> synchroniserVendeurCommande(@Query(ID_LIVREUR) long id, @Query(DATE_SYNCHRO) long date);

//______________________________ SYNCHRO Paquets Supprime ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/synchroniserPaquetsSupprime/378701   DONE with NO DATA

    @GET(DOMAIN + "synchroniserPaquetsSupprime.php")
    Call<List<BonDeSortiesResponse>> synchroniserPaquetSupprimer(@Query(ID_LIVREUR) long id_Livreur);


    @POST(DOMAIN2 + "postdebugger.php")
    Call<BonDeSortie> exportBonDeSorties(@Body BonDeSortie bonDeSortie);
}

/*
    public final  String CODE_LIVREUR = "379101";
    public final  String DATE_SYNCHRO = "DATE_SYNCHRO";
    public final  String ID_LIVREUR = "ID_LIVREUR";
    public final  String ID_ENTREPRISE = "ID_ENTREPRISE";
    public final  String ID_DOMAINE = "ID_DOMAINE";
    public final  String PWD_LIVREUR = "1234";
    public final  String IMEI = "IMEI";
    public final  String APP_VERSION = "APP_VERSION";
    public final  String PREMIER_UTILISATION = "PREMIER_UTILISATION";
    public final  String DOMAIN =  "ss/faces/rest/SmartSellerWS/";
//______________________________ AUTHENTICATION ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/autentification/379101/81dc9bdb52d04dc20036dbd8313ed055/0000/1.0     DONE

    @GET(DOMAIN + "autentification/{" + CODE_LIVREUR + "}/{" + PWD_LIVREUR + "}/{" + IMEI + "}/{" + APP_VERSION + "}")
    Call<AuthenticationResponse> getAuthentificated(@Query(CODE_LIVREUR) String code, @Query(PWD_LIVREUR) String pwd, @Query(IMEI) String imei, @Query(APP_VERSION) String appVersion) ;

//______________________________ get ALL Bon Sortie ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/bonSorties/379101/378701/PREMIER_UTILISATION"    DONE with NO DATA

    @GET(DOMAIN + "bonSorties/{" + ID_LIVREUR + "}/{" + ID_ENTREPRISE + "}/{" + PREMIER_UTILISATION + "}")
    Call<BonDeSortiesResponse> getBonSortie(@Query(ID_LIVREUR) String idLivreur, @Query(ID_ENTREPRISE) long idEntreprise, @Query(PREMIER_UTILISATION) boolean premier_utilisation);

//______________________________ update Prix Article ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/updatePrixArticle/379101/123313123       ERROR

    @GET(DOMAIN + "updatePrixArticle/{" + ID_LIVREUR + "}/{" + DATE_SYNCHRO + "}")
    Call<List<String>> updatePrixArticle(@Query(ID_LIVREUR) long idLivreur, @Query(DATE_SYNCHRO) long dateSynchro);

//______________________________ Get Prefixes Factures ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/prefixeFacture/379101/378701     VIDE

    @GET(DOMAIN + "prefixeFacture/{" + ID_LIVREUR + "}/{" + ID_ENTREPRISE + "}")
    Call<List<PrefixFacture>> getPrefixsFacture(@Query(ID_LIVREUR) long idLivreur, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ Get Prefixes BL ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/prefixBonLivraison/379101/378701     VIDE

    @GET(DOMAIN + "prefixBonLivraison/{" + ID_LIVREUR + "}/{" + ID_ENTREPRISE + "}")
    Call<List<PrefixBL>> getPrefixsBL(@Query(ID_LIVREUR) long idLivreur, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ update client ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/clients/123313123/378701

    @GET(DOMAIN + "clients/{" + DATE_SYNCHRO + "}/{" + ID_ENTREPRISE + "}")
    Call<List<Client>> getClients(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ update entreprise ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/domaines/123313123/378701   VIDE

    @GET(DOMAIN + "domaines/{" + DATE_SYNCHRO + "}/{" + ID_ENTREPRISE + "}")
    Call<List<Entreprise>> synchDomaine(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ Articles ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/articles/123313123/378701    DONE with SOME HTML RESPONSE

    @GET(DOMAIN + "articles/{" + DATE_SYNCHRO + "}/{" + ID_ENTREPRISE + "}")
    Call<List<Article>> getArticles(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ Categories Articles ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/categorieArticles/123313123/378701

    @GET(DOMAIN + "categorieArticles/{" + DATE_SYNCHRO + "}/{" + ID_ENTREPRISE + "}")
    Call<List<CategorieArticle>> getAllCategory(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ Etat Commande ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/etatCommandes/123313123/378701

    @GET(DOMAIN + "etatCommandes/{" + DATE_SYNCHRO + "}/{" + ID_ENTREPRISE + "}")
    Call<List<EtatCommande>> getEtatCommande(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ Nature VISITE ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/synchroniserNatureVentes/123313123/378701

    @GET(DOMAIN + "synchroniserNatureVentes/{" + DATE_SYNCHRO + "}/{" + ID_ENTREPRISE + "}")
    Call<List<NatureVente>> synchroniserNatureVentes(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ SYNCHRO Type EncaissementVente ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/SynchroniserTypeEncaissementVente/123313123/378701

    @GET(DOMAIN + "SynchroniserTypeEncaissementVente/{" + DATE_SYNCHRO + "}/{" + ID_ENTREPRISE + "}")
    Call<List<TypeEncaissementVente>> synchroniserTypeEncaissementVente(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ SYNCHRO Synchroniser Banque ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/SynchroniserBanque/123313123/378701

    @GET(DOMAIN + "SynchroniserBanque/{" + DATE_SYNCHRO + "}/{" + ID_ENTREPRISE + "}")
    Call<List<Banque>> synchroniserBanque(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ SYNCHRO Commande ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/synchroniserVendeurCommande/378701/123313123     VIDE

    @GET(DOMAIN + "synchroniserVendeurCommande/{" + ID_LIVREUR + "}/{" + DATE_SYNCHRO + "}")
    Call<List<Commande>> synchroniserVendeurCommande(@Query(ID_LIVREUR) long id, @Query(DATE_SYNCHRO) long date);

//______________________________ SYNCHRO Paquets Supprime ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/synchroniserPaquetsSupprime/378701   VIDE

    @GET(DOMAIN + "synchroniserPaquetsSupprime/{" + ID_LIVREUR + "}")
    Call<List<BonDeSortiesResponse>> synchroniserPaquetSupprimer(@Query(ID_LIVREUR) long id_Livreur);
 */