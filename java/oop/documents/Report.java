package oop.documents;

public class Report extends DocumentoAstratto{
    String[] objectives;
    Boolean[] checked;
    Boolean isPublico;
    String destnazione;



    public Report(String[] objectives, Boolean[] checked, Boolean isPublico, String destnazione,String testo,
                  String proprietario, String nomeFirma, int codice) {
        super(testo, proprietario, nomeFirma, codice);
        this.objectives = objectives;
        this.checked = checked;
        this.isPublico = isPublico;
        this.destnazione = destnazione;
        if(objectives.length != checked.length){
            System.exit(-1);
        }
    }
    public Report(Report r, String nomeFirma, int codice){
        super(r.getTesto(),r.getProprietario(),nomeFirma,codice);
        this.objectives = objectives;
        this.checked = checked;
        this.isPublico = isPublico;
        this.destnazione = destnazione;
        if(r.isSigned()){
            System.exit(-1);
        }
        if(objectives.length != checked.length) {
            System.exit(-1);
        }

    }

    public Report(String[] objectives, Boolean[] checked, Boolean isPublico, String destnazione,String testo,
                  String proprietario) {
        super(testo, proprietario);
        this.objectives = objectives;
        this.checked = checked;
        this.isPublico = isPublico;
        this.destnazione = destnazione;
        if(objectives.length != checked.length){
            System.exit(-1);
        }
    }

    @Override
    protected boolean checkSign() {
        if(isPublico){
            int cod=super.getCodice();
            if(cod > 100 && super.getProprietario().equals("Direttore") && super.getNomeFirma().equals("Direttore"));
                return true;
        }
        else {
            return (super.getCodice() < 1000 && !super.getNomeFirma().equals("Direttore"));
        }
    }

    @Override
    public void invia() {
        if(super.isInviabile()) {
            System.out.println("A " + "Destinazione");
            System.out.println("Testo:"+getTesto());
            for (int i = 0; i < checked.length; i++) {
                System.out.println(" OBJ:"+i+" :"+objectives[i]+" "+checked[i]);
            }
        }

    }

    public String[] getObjectives() {
        return objectives;
    }

    public Boolean[] getChecked() {
        return checked;
    }

    public Boolean getPublico() {
        return isPublico;
    }

    public String getDestnazione() {
        return destnazione;
    }

    public void setObjectives(String[] objectives) {
        this.objectives = objectives;

    }

    public void setChecked(Boolean[] checked) {
        this.checked = checked;
    }
}
