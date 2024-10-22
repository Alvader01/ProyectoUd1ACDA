package com.github.alvader01.view;

public enum Scenes {
    LAYOUT("view/layout.fxml"),
    MAIN("view/Main.fxml"),
    REGISTER("view/Register.fxml"),
    SPECIESCONFIG("view/SpeciesConfig.fxml"),
    FISHTANKCONFIG("view/FishTankConfig.fxml"),
    USERCONFIG("view/UserConfig.fxml"),
    CREATEFISHTANK("view/CreateFishTank.fxml"),
    DELETEFISHTANK("view/DeleteFishTank.fxml"),
    DELETEUSER("view/DeleteUser.fxml"),
    CREATESPECIES("view/CreateSpecies.fxml"),
    DELETESPECIES("view/DeleteSpecies.fxml"),
    ADDSPECIESTOTANK("view/AddSpeciesToTank.fxml"),
    LOGIN("view/Login.fxml");

    private String url;

    Scenes(String url) {
        this.url = url;
    }

    public String getURL() {
        return url;
    }
}
