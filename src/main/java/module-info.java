module com.github.alvader01 {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.xml.bind;

    opens com.github.alvader01.Utils to jakarta.xml.bind; // Abre el paquete Utils a JAXB
    opens com.github.alvader01.Model.entity to jakarta.xml.bind; // Abre el paquete entity a JAXB
    exports com.github.alvader01.Model.entity; // Exporta el paquete entity
    exports com.github.alvader01; // Exporta el paquete principal
}
