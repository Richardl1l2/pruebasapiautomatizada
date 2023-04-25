package com.productoscredito.utils.Task;


public class Constantes  {
    private static final String usuario = "1128277898";
    public static String getUsuario() {
        return usuario;
    }
    private static final String contrasena = "2435";
    public static String getContrasena() {
        return contrasena;
    }
    private static final String scope = "solapp solapp.credits.read solapp.credits.write solapp.personaldata.read solapp.personaldata.write solapp.accounts.read solapp.auth solapp.inbox.read solapp.inbox.write solapp.accounts.write solapp.insurance.write preneq preneq.accounts.write preneq.accounts.read preme.accounts.write preme.accounts.read preme";
    public static String getScope() {
        return scope;
    }

    private static final String cedula = "RVWXPTTXRQQ2";
    public static String getCedula() {return cedula;}
    private static final String basicEncodeClient =  "dXg5SE9PZEJmUk53bzRxc21yb19mcE10YmtNYToyMXZ6V0ZmQlVsUndhU2xYVU80Nmk1bXVIelFh";
    public static String getBasicEncodeClient() {
        return basicEncodeClient;
    }

    private static final String token =  PostCrearToken.getToken();
    public static String getToken() {
        return token;
    }

    static final String LinkAPI = "https://gatewaypru.am.presente.com.co/creditoDigital/v1/";
    public static String getLinkAPI() {
        return LinkAPI;
    }
    static final String LinkAPI1 = "https://gatewaypru.am.presente.com.co/AdelantoDeNomina/v1/";
    public static String getLinkAPI1(String obtenerLineasCredito) {
        return LinkAPI1;
    }

    /*variables usadas en los assert*/
    static final String departamento = "AMAZONAS";
    public static String getDepartamento(String departamento) {
        return departamento;
    }
    static final String k_transa = "1605138763004";
    public static String gek_transa() {
        return k_transa;
    }


    static final String k_numdoc = "10050316";
    public static String getk_numdoc() {
        return k_numdoc;
    }

    }

