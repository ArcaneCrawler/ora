package com.math.epidemic.Controller;

import com.math.epidemic.Entities.Virus;
import com.math.epidemic.Entities.VirusDto;
import com.math.epidemic.Services.VirusService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseController {




    public TableView<VirusDto> virusTableView;
    public TableColumn<VirusDto, Long> idVirusColumn;
    public TableColumn<VirusDto, String> nameVirusColumn;
    public TableColumn<VirusDto, String> stainVirusColumn;
    public TableColumn<VirusDto, Float> lethalVirusColumn;
    public TableColumn<VirusDto, Float> influenceVirusColumn;
    public TableColumn<VirusDto, Float> chanceVirusColumn;
    public TableColumn<VirusDto, Float> evolVirusColumn;
    public TableColumn<VirusDto, Float> enduranceVirusColumn;
    public TableColumn<VirusDto, Float> cureVirusColumn;


    Application app = null;

    private ObservableList<VirusDto> listVirus = FXCollections.observableArrayList();

    @Autowired
    private VirusService virusService;


    public void initialize(){
        /**
         * тут магия конечно, но если примерно, setCellValueFactory() - метод, который указывает
         * какие данные будут ОТОБРАЖАТЬСЯ в ячейках определенного столбца в таблице
         */
        System.out.println(this);
        idVirusColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nameVirusColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        stainVirusColumn.setCellValueFactory(cellData -> cellData.getValue().strainProperty());
        lethalVirusColumn.setCellValueFactory(cellData -> cellData.getValue().lethalProperty().asObject());
        influenceVirusColumn.setCellValueFactory(cellData -> cellData.getValue().influenceProperty().asObject());
        chanceVirusColumn.setCellValueFactory(cellData -> cellData.getValue().chanceProperty().asObject());
        evolVirusColumn.setCellValueFactory(cellData -> cellData.getValue().evol_rateProperty().asObject());
        enduranceVirusColumn.setCellValueFactory(cellData -> cellData.getValue().cure_rateProperty().asObject());
        cureVirusColumn.setCellValueFactory(cellData -> cellData.getValue().enduranceProperty().asObject());

        virusTableView.setItems(listVirus);

        /*
        parser(refractoryService.findAll());

        */

        //parser(refractoryService.findAll(), listRefractory);

    }

    public void onClickAdd(ActionEvent actionEvent) {
       // app.showLayoutAdd();

    }

    private void parser(List<Virus> list, ObservableList<VirusDto> obsList) {
        obsList.clear();
        for (Virus virus : list) {
            VirusDto element = new VirusDto();
            element.setId(virus.getId());
            element.setName(virus.getName());

            element.setStrain(virus.getStrain());
            element.setLethal(virus.getLethal());
            element.setInfluence(virus.getInfluence());
            element.setChance(virus.getChance());
            element.setEvol_rate(virus.getEvol_rate());
            element.setCure_rate(virus.getCure_rate());
            element.setEndurance(virus.getEndurance());

            obsList.add(element);
        }
    }



    public void onClickDelete(ActionEvent actionEvent) {
    }

    public void setApp(com.math.epidemic.Application application) {
    }
   /* public void setApp(Application app) {
        this.app = app;
        System.out.println("test");
        System.out.println(this);
    }*/
}
