module com.github.alvader01 {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;
    requires java.desktop;

    opens com.github.alvader01 to javafx.fxml;
    opens com.github.alvader01.Utils to java.xml.bind;
    opens com.github.alvader01.Model.entity to java.xml.bind;

    exports com.github.alvader01;
    exports com.github.alvader01.Model.entity;
    exports com.github.alvader01.Test;
}
