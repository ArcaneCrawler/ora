package com.math.epidemic.Controller;

import com.math.epidemic.Application;
import com.math.epidemic.Entities.Dto.JournalDto;
import com.math.epidemic.Entities.Dto.LocalityDto;
import com.math.epidemic.Entities.Dto.VirusDto;
import com.math.epidemic.Entities.Journal;
import com.math.epidemic.Entities.Locacity;
import com.math.epidemic.Entities.Virus;
import com.math.epidemic.Services.JournalService;
import com.math.epidemic.Services.LocacityService;
import com.math.epidemic.Services.VirusService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
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
    public TableColumn<LocalityDto, Float> contactLocacityColumn;
    public TableColumn<LocalityDto, Float> deathLocacityColumn;
    public TableColumn<LocalityDto, Float> birthLocacityColumn;
    public TableColumn<LocalityDto, Float> vaccineLocacityColumn;
    public TableColumn<LocalityDto, Integer> populationLocacityColumn;

    public TableView<JournalDto> journalTableView;
    public TableColumn<JournalDto, Long> idJournalColumn;
    public TableColumn<JournalDto, String> model_typeColumn;
    public TableColumn<JournalDto, String> virusJournalColumn;
    public TableColumn<JournalDto, String> locacityJournalColumn;
    public TableColumn<JournalDto, Float> popul_leftJournalColumn;
    public TableColumn<JournalDto, Float> popul_deadJournalColumn;
    public TableColumn<JournalDto, Float> suspectedJournalColumn;
    public TableColumn<JournalDto, Float> infectedJournalColumn;
    public TableColumn<JournalDto, Float> curedJournalColumn;
    public TableColumn<JournalDto, Float> latentJournalColumn;
    public TableColumn<JournalDto, Float> chemJournalColumn;
    public TableColumn<JournalDto, String> dateJournalColumn;

    private Application app;

    private ObservableList<VirusDto> listVirus = FXCollections.observableArrayList();
    private ObservableList<LocalityDto> listLocacity = FXCollections.observableArrayList();
    private ObservableList<JournalDto> listJournal = FXCollections.observableArrayList();
    private ObservableList<Virus> list1 = FXCollections.observableArrayList();

    @Autowired
    private VirusService virusService;
    @Autowired
    private LocacityService locacityService;
    @Autowired
    private JournalService journalService;


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
        contactLocacityColumn.setCellValueFactory(cellData -> cellData.getValue().contactProperty().asObject());
        deathLocacityColumn.setCellValueFactory(cellData -> cellData.getValue().death_rateProperty().asObject());
        birthLocacityColumn.setCellValueFactory(cellData -> cellData.getValue().birth_rateProperty().asObject());
        vaccineLocacityColumn.setCellValueFactory(cellData -> cellData.getValue().vaccineProperty().asObject());
        locacityTableView.setItems(listLocacity);

        idJournalColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        model_typeColumn.setCellValueFactory(cellData -> cellData.getValue().model_lypeProperty());
        virusJournalColumn.setCellValueFactory(cellData -> cellData.getValue().virusProperty());
        locacityJournalColumn.setCellValueFactory(cellData -> cellData.getValue().locacityProperty());
        popul_leftJournalColumn.setCellValueFactory(cellData -> cellData.getValue().popul_leftProperty().asObject());
        popul_deadJournalColumn.setCellValueFactory(cellData -> cellData.getValue().popul_daedProperty().asObject());
        suspectedJournalColumn.setCellValueFactory(cellData -> cellData.getValue().suspectedProperty().asObject());
        infectedJournalColumn.setCellValueFactory(cellData -> cellData.getValue().infectedProperty().asObject());
        curedJournalColumn.setCellValueFactory(cellData -> cellData.getValue().curedProperty().asObject());
        latentJournalColumn.setCellValueFactory(cellData -> cellData.getValue().latentProperty().asObject());
        chemJournalColumn.setCellValueFactory(cellData -> cellData.getValue().chemProperty().asObject());
        dateJournalColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        journalTableView.setItems(listJournal);

    }

    public void setApp(Application application) {
        this.app = application;
        app.connectVirus();

    }

    public void onClickShow(ActionEvent actionEvent) {
        init();

    }

    public void onClickAdd(ActionEvent actionEvent) {
        app.showAddV();
        init();

    }

    public void onClickDelete(ActionEvent actionEvent) {
        try {
            VirusDto virusDto = virusTableView.getSelectionModel().getSelectedItem();
            Virus virus = new Virus();
            virus.setId(virusDto.getId());
            virusService.delete(virus);
            app.connectVirus();
            deleteAlert();
            init();
        } catch (NullPointerException exception) {
            alert();
        }
    }


    public void onClickUpdate(ActionEvent actionEvent) {
        try {
            VirusDto virusDto = virusTableView.getSelectionModel().getSelectedItem();
            Virus virus = new Virus();
            virus.setId(virusDto.getId());
            virus.setName(virusDto.getName());
            virus.setStrain(virusDto.getStrain());
            virus.setLethal(virusDto.getLethal());
            virus.setInfluence(virusDto.getInfluence());
            virus.setEvol_rate(virusDto.getEvol_rate());
            virus.setEndurance(virusDto.getEndurance());
            virus.setCure_rate(virusDto.getCure_rate());
            virus.setChance(virusDto.getChance());
            app.showUpdV(virus);
            app.connectVirus();
            init();
        } catch (NullPointerException exception) {
            alert();
        }
    }

    public void onClickAddLocacity(ActionEvent actionEvent) {
        app.showAddL();
        init();
    }

    public void onClickUpdateLocacity(ActionEvent actionEvent) {
        try {
            LocalityDto locacityDTO = locacityTableView.getSelectionModel().getSelectedItem();
            Locacity locacity = new Locacity();
            locacity.setId(locacityDTO.getId());

            locacity.setName(locacityDTO.getName());
            locacity.setPopulation(locacityDTO.getPopulation());
            locacity.setContact(locacityDTO.getContact());
            locacity.setVaccine(locacityDTO.getVaccine());
            locacity.setDeath_rate(locacityDTO.getDeath_rate());
            locacity.setBirth_rate(locacityDTO.getBirth_rate());
            app.showUpdL(locacity);
            app.connectVirus();
            init();
        } catch (NullPointerException exception) {
            alert();
        }
    }

    public void onClickDeleteLocacity(ActionEvent actionEvent) {
        try {
            LocalityDto locacityDTO = locacityTableView.getSelectionModel().getSelectedItem();
            Locacity locacity = new Locacity();
            locacity.setId(locacityDTO.getId());
            locacityService.delete(locacity);
            app.connectVirus();
            deleteAlert();
            init();
        } catch (NullPointerException exception) {
            alert();
        }
    }

    private void alert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Warning!");
        alert.setHeaderText("Ошибка:");
        alert.setContentText("Для удаления или изменения записи требуется выбрать запись");
        alert.showAndWait();
        return;
    }

    private void deleteAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success!");
        alert.setHeaderText("Сообщение:");
        alert.setContentText("Запись успешно удалена!");
        alert.showAndWait();
        return;
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

    private void parserJournal(List<Journal> list, ObservableList<JournalDto> obsList) {
        obsList.clear();
        for (Journal journal : list) {
            JournalDto element = new JournalDto();
            element.setId(journal.getId());
            element.setModel_lype(journal.getModel_type());
            element.setPopul_daed(journal.getPopul_daed());
            element.setPopul_left(journal.getPopul_left());
            element.setInfected(journal.getInfected());
            element.setSuspected(journal.getSuspected());
            element.setCured(journal.getCured());
            element.setLatent(journal.getLatent());
            element.setChem(journal.getChem());
            element.setDate(journal.getDate());
            element.setVirus(journal.getVirus());
            element.setLocacity(journal.getLocacity());
           //Locacity locacity = journal.getLocacity();
            //element.setVirus(virus.getName());
           // element.setVirus(locacity.getName());
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
            element.setVaccine(locacity.getVaccine());
            obsList.add(element);
        }
    }

    // прикол в том что initialize у тебя вызывается ДО подключения к базе, просто в момент запуска приложения
    // создаются все лайоуты, и чисто храянтся в памяти
    // так что при вызове окошка приходится отдельно довызывать метод для подсасывания с базы ,
    // ибо initialize уже отработал

    public void init() {
        list1.addAll(virusService.findAll());
        parserVirus(virusService.findAll(), listVirus);
        parser(locacityService.findAll(), listLocacity);
        parserJournal(journalService.findAll(), listJournal);
    }


}
