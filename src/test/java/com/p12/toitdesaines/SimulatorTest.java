package com.p12.toitdesaines;

import com.p12.toitdesaines.services.impl.SimServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.p12.toitdesaines.entity.Simapa;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})

public class SimulatorTest {

    @InjectMocks
    SimServiceImpl simService;
    @Test
    void getValueShouldReturnEnEstimationOf0whenGirIsSuperiorTo5(){
        //GIVEN
        Simapa simapa = new Simapa( 6,false,0,0,0,0);

        //WHEN
        simService.getValue(simapa);

        //THEN
        assertThat(simapa.getEstimation()).isEqualTo(0.0);


    }
    @Test
    void updateAloneWhenPplisInCoupleShouldDivideRevenusByOnePointSeven(){
        //GIVEN
        Simapa simapa = new Simapa( 4,false,10000,0,0,0);

        //WHEN
        simService.updateAlone(simapa);
        int estimationDivided = (int) (10000/1.7);

        //THEN
        assertThat(simapa.getRevenus()).isEqualTo(estimationDivided);

    }
    @Test
    void updateAloneWhenPplisAloneShouldNotDivideRevenusByOnePointSeven(){
        //GIVEN
        Simapa simapa = new Simapa( 4,true,10000,0,0,0);

        //WHEN
        simService.updateAlone(simapa);
        int estimationDivided = (10000);

        //THEN
        assertThat(simapa.getRevenus()).isEqualTo(estimationDivided);

    }
    @Test
    void setSShouldReturnTheMaxBeetweenRevenuAndPalierHereRevenu(){
        //GIVEN
        Simapa simapa = new Simapa( 4,true,10000,0,0,0);

        //WHEN
        double Yolo =  simService.setS(simapa);
        double estimationDivided = (10000*0.4);

        //THEN
        assertThat(Yolo).isEqualTo(estimationDivided);

    }
    @Test
    void setSShouldReturnTheMaxBeetweenRevenuAndPalierHerePalier(){
        //GIVEN
        Simapa simapa = new Simapa( 4,true,100,0,0,0);

        //WHEN
        double Yolo =  simService.setS(simapa);
        double estimationDivided = (1125.29);

        //THEN
        assertThat(Yolo).isEqualTo(estimationDivided);

    }
    @Test
    void participationMensuelShouldReturnZeroForLowRevenus(){
        //GIVEN
        Simapa simapa = new Simapa( 4,true,100,0,0,0);
        //WHEN
        simService.participationMensuel(simapa);
        //THEN
        assertThat(simapa.getParticipation()).isEqualTo(0);
    }
    @Test
    void participationMensuelShouldReturnNinetyForHighRevenus(){
        //GIVEN
        Simapa simapa = new Simapa( 4,true,5000,0,0,0);
        //WHEN
        simService.participationMensuel(simapa);
        //THEN
        assertThat(simapa.getParticipation()).isEqualTo(0.90);
    }
    @Test
    void participationMensuelShouldReturnAPcentForMiddleRevenus(){
        //GIVEN
        Simapa simapa = new Simapa( 4,true,2000,0,672.26,0);
        //WHEN
        simService.participationMensuel(simapa);
        //THEN
        assertThat(simapa.getParticipation()).isEqualTo(0.64);
    }
    @Test
    void getValueForGir1(){
        //GIVEN
        Simapa simapa = new Simapa( 1,true,2000,0,0.00,0.00);
        //WHEN
        simService.getValue(simapa);
        //THEN
        assertThat(simapa.getEstimation()).isEqualTo(433.54);
    }
    @Test
    void getValueForGir2(){
        //GIVEN
        Simapa simapa = new Simapa( 2,true,2000,0,0.00,0.00);
        //WHEN
        simService.getValue(simapa);
        //THEN
        assertThat(simapa.getEstimation()).isEqualTo(432.41);
    }
    @Test
    void getValueForGir3(){
        //GIVEN
        Simapa simapa = new Simapa( 3,true,2000,0,0.00,0.00);
        //WHEN
        simService.getValue(simapa);
        //THEN
        assertThat(simapa.getEstimation()).isEqualTo(423.29);
    }
    @Test
    void getValueForGir4(){
        //GIVEN
        Simapa simapa = new Simapa( 4,true,2000,0,0.00,0.00);
        //WHEN
        simService.getValue(simapa);
        //THEN
        assertThat(simapa.getEstimation()).isEqualTo(430.25);
    }
}
