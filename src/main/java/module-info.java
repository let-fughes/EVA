module com.protect.data.eva {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.eva to javafx.fxml;
    exports com.eva;
    exports com.eva.src;
    opens com.eva.src to javafx.fxml;
}