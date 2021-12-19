module com.domrowka.javafx_wreszcie_to_zrobie {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.domrowka.javafx_wreszcie_to_zrobie to javafx.fxml;
    exports com.domrowka.javafx_wreszcie_to_zrobie;
}