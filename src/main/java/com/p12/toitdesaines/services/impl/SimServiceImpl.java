package com.p12.toitdesaines.services.impl;

import com.p12.toitdesaines.entity.Simapa;
import com.p12.toitdesaines.services.SimService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class SimServiceImpl implements SimService {
    @Override
    public Simapa getValue(Simapa simapa) {


        if (simapa.getGir() < 5)  //Valeur du GIR entre 1 et 6 , 5 et 6 n'apporte le droit a aucune aide

        {
            if (simapa.getGir() == 1){
                simapa.setPlafondGIR(1734.14);
                this.updateAlone(simapa);
                this.participationMensuel(simapa);
                double estimation = simapa.getParticipation()*simapa.getPlafondGIR();
                DecimalFormat df = new DecimalFormat("########.00");
                String str = df.format(estimation);
                estimation = Double.parseDouble(str.replace(',', '.'));


                simapa.setEstimation(estimation);
            }
            if (simapa.getGir() == 2){
                simapa.setPlafondGIR(1394.86);
                this.updateAlone(simapa);
                this.participationMensuel(simapa);
                double estimation = simapa.getParticipation()*simapa.getPlafondGIR();
                DecimalFormat df = new DecimalFormat("########.00");
                String str = df.format(estimation);
                estimation = Double.parseDouble(str.replace(',', '.'));


                simapa.setEstimation(estimation);
            }
            if (simapa.getGir() == 3){
                simapa.setPlafondGIR(1007.83);
                this.updateAlone(simapa);
                this.participationMensuel(simapa);
                double estimation = simapa.getParticipation()*simapa.getPlafondGIR();
                DecimalFormat df = new DecimalFormat("########.00");
                String str = df.format(estimation);
                estimation = Double.parseDouble(str.replace(',', '.'));


                simapa.setEstimation(estimation);
            }
            if (simapa.getGir() == 4){
                simapa.setPlafondGIR(672.26);
                this.updateAlone(simapa);
                this.participationMensuel(simapa);
                double estimation = simapa.getParticipation()*simapa.getPlafondGIR();
                DecimalFormat df = new DecimalFormat("########.00");
                String str = df.format(estimation);
                estimation = Double.parseDouble(str.replace(',', '.'));


                simapa.setEstimation(estimation);
            }

        }
        else{ simapa.setEstimation(0);}
        return simapa;
    }


    public void updateAlone(Simapa simapa) {
        double quotientCouple = 1.7;
        if (simapa.isAlone()) {

        } else {
            simapa.setRevenus((int) (simapa.getRevenus() / quotientCouple));
        }
    }

    /**
     *  lien de la formule de calcul : https://www.legifrance.gouv.fr/jo_pdf.do?id=JORFTEXT000032112672
     * @param simapa
     * P= Participation financière calculée en fonction du plan d'aide
     * S = le montant de la majoration pour aide constante d’une tierce personne
     */

    public void participationMensuel (Simapa simapa){

        int P ;
        double S = this.setS(simapa) ;


        double a1 = 0.317*S;
        double a3=0.498*S;
        double a2=S-(a1+a3);


        if (simapa.getRevenus() <= 810.96) {
            simapa.setParticipation(0);
        }
        else if (simapa.getRevenus()> 810.96 && simapa.getRevenus()<=2986.58) {
            P = (int) ((a1 * ((simapa.getRevenus() - (0.725 * S)) / ((2.67 * S) - (0.725 * S))) * 0.9) +
                                (a2 * ((simapa.getRevenus() - (0.725 * S)) / ((2.67 * S) - (0.725 * S))) * 0.9 *
                                        (((1 - 0.4) / ((2.67 * S) - (0.725 * S))) * (simapa.getRevenus() + (((0.4 * 2.67 * S) - (0.725 * S)) / ((2.67 * S) - (0.725 * S)))))) +
                                (a3 * ((simapa.getRevenus() - (0.725 * S)) / ((2.67 * S) - (0.725 * S))) * 0.9 *
                                        (((1 - 0.2) / ((2.67 * S) - (0.725 * S))) * (simapa.getRevenus() + (((0.2 * 2.67 * S) - (0.725 * S)) / ((2.67 * S) - (0.725 * S)))))));


            double participation = P/simapa.getPlafondGIR();
            DecimalFormat df = new DecimalFormat("########.00");
            String str = df.format(participation);
            participation = Double.parseDouble(str.replace(',', '.'));                  // Pour garder seulement 2 chiffre après la virgule.

             simapa.setParticipation( participation);

        }
        else if (simapa.getRevenus()> 2986.58) {
            simapa.setParticipation(0.90);
        }

    }



     public double setS(Simapa simapa) {
        double S = Math.max(simapa.getRevenus() * 0.4, 1125.29);
        return S;
    }

}
