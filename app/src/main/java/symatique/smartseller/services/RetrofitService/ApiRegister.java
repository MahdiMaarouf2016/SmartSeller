package symatique.smartseller.services.RetrofitService;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import symatique.smartseller.data.Article;
import symatique.smartseller.data.AuthenticationResponse;
import symatique.smartseller.data.Banque;
import symatique.smartseller.data.BonDeSortie;
import symatique.smartseller.data.CategorieArticle;
import symatique.smartseller.data.Client;
import symatique.smartseller.data.Commande;
import symatique.smartseller.data.Entreprise;
import symatique.smartseller.data.EtatCommande;
import symatique.smartseller.data.NatureVente;
import symatique.smartseller.data.PrefixBL;
import symatique.smartseller.data.PrefixFacture;
import symatique.smartseller.data.TypeEncaissementVente;


public interface ApiRegister {

    public final  String CODE_LIVREUR = "379101";
    public final  String DATE_SYNCHRO = "DATE_SYNCHRO";
    public final  String ID_LIVREUR = "ID_LIVREUR";
    public final  String ID_ENTREPRISE = "ID_ENTREPRISE";
    public final  String ID_DOMAINE = "ID_DOMAINE";
    public final  String PWD_LIVREUR = "1234";
    public final  String IMEI = "IMEI";
    public final  String APP_VERSION = "APP_VERSION";
    public final  String PREMIER_UTILISATION = "PREMIER_UTILISATION";
    public final  String DOMAIN =  "SmartSeller/RetrofitGet";

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/
//______________________________ AUTHENTICATION ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/autentification/379101/81dc9bdb52d04dc20036dbd8313ed055/0000/1.0     DONE

    @GET(DOMAIN + "autentification.php?codelivreur=" + CODE_LIVREUR + "&pwdlivreur=" + PWD_LIVREUR + "&imei=" + IMEI + "&appversion=" + APP_VERSION + "")
    Call<AuthenticationResponse> getAuthentificated(@Query(CODE_LIVREUR) String code, @Query(PWD_LIVREUR) String pwd, @Query(IMEI) String imei, @Query(APP_VERSION) String appVersion) ;

//______________________________ get ALL Bon Sortie ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/bonSorties/379101/378701/PREMIER_UTILISATION"    DONE with NO DATA

    @GET(DOMAIN + "bonSorties.php?idlivreur=" + ID_LIVREUR + "&identreprise=" + ID_ENTREPRISE + "&premierutilisation=" + PREMIER_UTILISATION + "")
    Call<BonDeSortie> getBonSortie(@Query(ID_LIVREUR) String idLivreur, @Query(ID_ENTREPRISE) long idEntreprise, @Query(PREMIER_UTILISATION) boolean premier_utilisation);

//______________________________ update Prix Article ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/updatePrixArticle/379101/123313123       ERROR

    @GET(DOMAIN + "updatePrixArticle.php?idlivreur=" + ID_LIVREUR + "&datesynchro=" + DATE_SYNCHRO + "")
    Call<List<String>> updatePrixArticle(@Query(ID_LIVREUR) long idLivreur, @Query(DATE_SYNCHRO) long dateSynchro);

//______________________________ Get Prefixes Factures ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/prefixeFacture/379101/378701     VIDE

    @GET(DOMAIN + "prefixeFacture.php?idlivreur=" + ID_LIVREUR + "&identreprise=" + ID_ENTREPRISE + "")
    Call<List<PrefixFacture>> getPrefixsFacture(@Query(ID_LIVREUR) long idLivreur, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ Get Prefixes BL ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/prefixBonLivraison/379101/378701     VIDE

    @GET(DOMAIN + "prefixBonLivraison.php?idlivreur=" + ID_LIVREUR + "&identreprise=" + ID_ENTREPRISE + "")
    Call<List<PrefixBL>> getPrefixsBL(@Query(ID_LIVREUR) long idLivreur, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ update client ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/clients/123313123/378701

    @GET(DOMAIN + "clients.php?datesynchro=" + DATE_SYNCHRO + "&identreprise=" + ID_ENTREPRISE + "")
    Call<List<Client>> getClients(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ update entreprise ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/domaines/123313123/378701   VIDE

    @GET(DOMAIN + "domaines.php?datesynchro=" + DATE_SYNCHRO + "?identreprise=" + ID_ENTREPRISE + "")
    Call<List<Entreprise>> synchDomaine(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ Articles ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/articles/123313123/378701    DONE with SOME HTML RESPONSE

    @GET(DOMAIN + "articles?datesynchro=" + DATE_SYNCHRO + "&identreprise=" + ID_ENTREPRISE + "")
    Call<List<Article>> getArticles(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ Categories Articles ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/categorieArticles/123313123/378701

    @GET(DOMAIN + "categorieArticles.php?datesynchro=" + DATE_SYNCHRO + "&identreprise=" + ID_ENTREPRISE + "")
    Call<List<CategorieArticle>> getAllCategory(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ Etat Commande ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/etatCommandes/123313123/378701

    @GET(DOMAIN + "etatCommandes.php?datesynchro=" + DATE_SYNCHRO + "&identreprise=" + ID_ENTREPRISE + "")
    Call<List<EtatCommande>> getEtatCommande(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ Nature VISITE ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/synchroniserNatureVentes/123313123/378701

    @GET(DOMAIN + "synchroniserNatureVentes.php?datesynchro=" + DATE_SYNCHRO + "&identreprise=" + ID_ENTREPRISE + "")
    Call<List<NatureVente>> synchroniserNatureVentes(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ SYNCHRO Type EncaissementVente ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/SynchroniserTypeEncaissementVente/123313123/378701

    @GET(DOMAIN + "SynchroniserTypeEncaissementVente.php?datesynchro=" + DATE_SYNCHRO + "&identreprise=" + ID_ENTREPRISE + "")
    Call<List<TypeEncaissementVente>> synchroniserTypeEncaissementVente(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ SYNCHRO Synchroniser Banque ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/SynchroniserBanque/123313123/378701

    @GET(DOMAIN + "SynchroniserBanque.php?datesynchro=" + DATE_SYNCHRO + "&identreprise=" + ID_ENTREPRISE + "")
    Call<List<Banque>> synchroniserBanque(@Query(DATE_SYNCHRO) long date, @Query(ID_ENTREPRISE) long idEntreprise);

//______________________________ SYNCHRO Commande ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/synchroniserVendeurCommande/378701/123313123     VIDE

    @GET(DOMAIN + "synchroniserVendeurCommande.php?idlivreur=" + ID_LIVREUR + "&datesynchro=" + DATE_SYNCHRO + "")
    Call<List<Commande>> synchroniserVendeurCommande(@Query(ID_LIVREUR) long id, @Query(DATE_SYNCHRO) long date);

//______________________________ SYNCHRO Paquets Supprime ____________________________________________________

    //http://192.168.1.16:8080/ss/faces/rest/SmartSellerWS/synchroniserPaquetsSupprime/378701   VIDE

    @GET(DOMAIN + "synchroniserPaquetsSupprime.php?idlivreur=" + ID_LIVREUR + "")
    Call<List<BonDeSortie>> synchroniserPaquetSupprimer(@Query(ID_LIVREUR) long id_Livreur);

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
    Call<BonDeSortie> getBonSortie(@Query(ID_LIVREUR) String idLivreur, @Query(ID_ENTREPRISE) long idEntreprise, @Query(PREMIER_UTILISATION) boolean premier_utilisation);

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
    Call<List<BonDeSortie>> synchroniserPaquetSupprimer(@Query(ID_LIVREUR) long id_Livreur);
 */