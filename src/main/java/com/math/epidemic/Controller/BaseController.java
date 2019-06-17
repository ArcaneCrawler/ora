package com.math.epidemic.Controller;

import com.math.epidemic.Entities.Dto.LocalityDto;
import com.math.epidemic.Entities.Dto.VirusDto;
import com.math.epidemic.Entities.Locacity;
import com.math.epidemic.Entities.Virus;
import com.math.epidemic.Services.LocacityService;
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

    public TableView<LocalityDto> locacityTableView;
    public TableColumn<LocalityDto, Long> idLocacityColumn;
    public TableColumn<LocalityDto, String> nameLocacityColumn;
    public TableColumn<LocalityDto, Float> densityLocacityColumn;
    public TableColumn<LocalityDto, Float> deathLocacityColumn;
    public TableColumn<LocalityDto, Float> birthLocacityColumn;
    public TableColumn<LocalityDto, Integer> populationLocacityColumn;

    private Application app = null;

    private ObservableList<VirusDto> listVirus = FXCollections.observableArrayList();
    private ObservableList<LocalityDto> listLocacity = FXCollections.observableArrayList();

    @Autowired
    private VirusService virusService;
    @Autowired
    private LocacityService locacityService;


    public void initialize() {

        /**
         * тут магия конечно, но если примерно, setCellValueFactory() - метод, который указывает
         * какие данные будут ОТОБРАЖАТЬСЯ в ячейках определенного столбца в таблице
         */
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

        idLocacityColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nameLocacityColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        populationLocacityColumn.setCellValueFactory(cellData -> cellData.getValue().populationProperty().asObject());
        densityLocacityColumn.setCellValueFactory(cellData -> cellData.getValue().contactProperty().asObject());
        deathLocacityColumn.setCellValueFactory(cellData -> cellData.getValue().death_rateProperty().asObject());
        birthLocacityColumn.setCellValueFactory(cellData -> cellData.getValue().birth_rateProperty().asObject());

        locacityTableView.setItems(listLocacity);
    }

    public void onClickAdd(ActionEvent actionEvent) {
        AddLocacityController add = new AddLocacityController();

        init();

    }
    public void setApp(com.math.epidemic.Application application) {
        this.app = application;
    }

    public void onClickDelete(ActionEvent actionEvent) {

        init();
    }

    private void parserVirus(List<Virus> list, ObservableList<VirusDto> obsList) {
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

    private void parser(List<Locacity> list, ObservableList<LocalityDto> obsList) {
        obsList.clear();
        for (Locacity locacity : list) {
            LocalityDto element = new LocalityDto();
            element.setId(locacity.getId());
            element.setName(locacity.getName());
            element.setPopulation(locacity.getPopulation());
            element.setContact(locacity.getContact());
            element.setDeath_rate(locacity.getDeath_rate());
            element.setBirth_rate(locacity.getBirth_rate());
            obsList.add(element);
        }
    }

    // прикол в том что initialize у тебя вызывается ДО подключения к базе, просто в момент запуска приложения
    // создаются все лайоуты, и чисто храянтся в памяти
    // так что при вызове окошка приходится отдельно довызывать метод для подсасывания с базы ,
    // ибо initialize уже отработал

    public void init() {
        parserVirus(virusService.findAll(), listVirus);
        parser(locacityService.findAll(), listLocacity);
    }
}
