/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
/**
 *
 * @author Erick Cruz
 */
public class InformeProduccion {

    private String IdProduccion;
    private int AtenIndivisual;
    private int AtenGrupo;
    private int VisDom;
    private int TotalAten;
    private double Recolectado;
    private double Distribuido;
    private int DonantesP;
    private int ReceptoresP;
    private double Microbiologia;
    private double FisQui;
    private double Crematocrito;
    private double AcidezDornic;
    private double TotAnaFQ;
    private double TotGenAna;
    
    public InformeProduccion(){
        IdProduccion="";
        AtenIndivisual=0;
        AtenGrupo=0;
        VisDom=0;
        TotalAten=0;
        Recolectado=0;
        Distribuido=0;
        DonantesP=0;
        ReceptoresP=0;
        Microbiologia=0;
        FisQui=0;
        Crematocrito=0;
        AcidezDornic=0;
        TotAnaFQ=0;
        TotGenAna=0;
    }
    
    public InformeProduccion(String IdProduccion, int AtenIndividual, int AtenGrupo, int VisDom, int TotalAten, double Recolectado, double Distribuido, int DonantesP, int ReceptoresP, double Microbriologia, double FisQui, double Crematocrito, double AcidezDornic, double TotAnaFQ, double TotGenAna){
        this.IdProduccion=IdProduccion;
        this.AtenIndivisual=AtenIndividual;
        this.AtenGrupo=AtenGrupo;
        this.VisDom=VisDom;
        this.TotalAten=TotalAten;
        this.Recolectado=Recolectado;
        this.Distribuido=Distribuido;
        this.DonantesP=DonantesP;
        this.ReceptoresP=ReceptoresP;
        this.Microbiologia=Microbriologia;
        this.FisQui=FisQui;
        this.Crematocrito=Crematocrito;
        this.AcidezDornic=AcidezDornic;
        this.TotAnaFQ=TotAnaFQ;
        this.TotGenAna=TotGenAna;
    }

    /**
     * @return the IdProduccion
     */
    public String getIdProduccion() {
        return IdProduccion;
    }

    /**
     * @param IdProduccion the IdProduccion to set
     */
    public void setIdProduccion(String IdProduccion) {
        this.IdProduccion = IdProduccion;
    }

    /**
     * @return the AtenIndivisual
     */
    public int getAtenIndivisual() {
        return AtenIndivisual;
    }

    /**
     * @param AtenIndivisual the AtenIndivisual to set
     */
    public void setAtenIndivisual(int AtenIndivisual) {
        this.AtenIndivisual = AtenIndivisual;
    }

    /**
     * @return the AtenGrupo
     */
    public int getAtenGrupo() {
        return AtenGrupo;
    }

    /**
     * @param AtenGrupo the AtenGrupo to set
     */
    public void setAtenGrupo(int AtenGrupo) {
        this.AtenGrupo = AtenGrupo;
    }

    /**
     * @return the VisDom
     */
    public int getVisDom() {
        return VisDom;
    }

    /**
     * @param VisDom the VisDom to set
     */
    public void setVisDom(int VisDom) {
        this.VisDom = VisDom;
    }

    /**
     * @return the TotalAten
     */
    public int getTotalAten() {
        return TotalAten;
    }

    /**
     * @param TotalAten the TotalAten to set
     */
    public void setTotalAten(int TotalAten) {
        this.TotalAten = TotalAten;
    }

    /**
     * @return the Recolectado
     */
    public double getRecolectado() {
        return Recolectado;
    }

    /**
     * @param Recolectado the Recolectado to set
     */
    public void setRecolectado(double Recolectado) {
        this.Recolectado = Recolectado;
    }

    /**
     * @return the Distribuido
     */
    public double getDistribuido() {
        return Distribuido;
    }

    /**
     * @param Distribuido the Distribuido to set
     */
    public void setDistribuido(double Distribuido) {
        this.Distribuido = Distribuido;
    }

    /**
     * @return the DonantesP
     */
    public int getDonantesP() {
        return DonantesP;
    }

    /**
     * @param DonantesP the DonantesP to set
     */
    public void setDonantesP(int DonantesP) {
        this.DonantesP = DonantesP;
    }

    /**
     * @return the ReceptoresP
     */
    public int getReceptoresP() {
        return ReceptoresP;
    }

    /**
     * @param ReceptoresP the ReceptoresP to set
     */
    public void setReceptoresP(int ReceptoresP) {
        this.ReceptoresP = ReceptoresP;
    }

    /**
     * @return the Microbiologia
     */
    public double getMicrobiologia() {
        return Microbiologia;
    }

    /**
     * @param Microbiologia the Microbiologia to set
     */
    public void setMicrobiologia(double Microbiologia) {
        this.Microbiologia = Microbiologia;
    }

    /**
     * @return the FisQui
     */
    public double getFisQui() {
        return FisQui;
    }

    /**
     * @param FisQui the FisQui to set
     */
    public void setFisQui(double FisQui) {
        this.FisQui = FisQui;
    }

    /**
     * @return the Crematocrito
     */
    public double getCrematocrito() {
        return Crematocrito;
    }

    /**
     * @param Crematocrito the Crematocrito to set
     */
    public void setCrematocrito(double Crematocrito) {
        this.Crematocrito = Crematocrito;
    }

    /**
     * @return the AcidezDornic
     */
    public double getAcidezDornic() {
        return AcidezDornic;
    }

    /**
     * @param AcidezDornic the AcidezDornic to set
     */
    public void setAcidezDornic(double AcidezDornic) {
        this.AcidezDornic = AcidezDornic;
    }

    /**
     * @return the TotAnaFQ
     */
    public double getTotAnaFQ() {
        return TotAnaFQ;
    }

    /**
     * @param TotAnaFQ the TotAnaFQ to set
     */
    public void setTotAnaFQ(double TotAnaFQ) {
        this.TotAnaFQ = TotAnaFQ;
    }

    /**
     * @return the TotGenAna
     */
    public double getTotGenAna() {
        return TotGenAna;
    }

    /**
     * @param TotGenAna the TotGenAna to set
     */
    public void setTotGenAna(double TotGenAna) {
        this.TotGenAna = TotGenAna;
    }
    
}
