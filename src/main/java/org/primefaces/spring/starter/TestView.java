package org.primefaces.spring.starter;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class TestView implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String string;
    private Integer integer;
    private BigDecimal decimal;
    private LocalDateTime localDateTime;
    private List<SampleData> sampleData;
    private boolean notificationsEnabled = true;
    private String theme = "light";

    @PostConstruct
    public void init() {
        string = "Always bet on Prime!";
        integer = 42;
        decimal = new BigDecimal("99.99");
        localDateTime = LocalDateTime.now();
        
        createSampleData();
    }

    private void createSampleData() {
        sampleData = new ArrayList<>();
        sampleData.add(new SampleData(1, "Project Alpha", "Active", "success"));
        sampleData.add(new SampleData(2, "Project Beta", "Pending", "warning"));
        sampleData.add(new SampleData(3, "Project Gamma", "Completed", "info"));
        sampleData.add(new SampleData(4, "Project Delta", "Cancelled", "danger"));
        sampleData.add(new SampleData(5, "Project Epsilon", "Active", "success"));
        sampleData.add(new SampleData(6, "Project Zeta", "Active", "success"));
        sampleData.add(new SampleData(7, "Project Eta", "Pending", "warning"));
    }

    public void addSuccessMessage() {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Operation completed successfully."));
    }

    public void addInfoMessage() {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Information", "This is an informational message."));
    }

    public void addWarningMessage() {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning", "Please pay attention to this warning."));
    }

    public void addErrorMessage() {
        FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "An unexpected error has occurred."));
    }

    // Getters and Setters
    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public BigDecimal getDecimal() {
        return decimal;
    }

    public void setDecimal(BigDecimal decimal) {
        this.decimal = decimal;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public List<SampleData> getSampleData() {
        return sampleData;
    }

    public void setSampleData(List<SampleData> sampleData) {
        this.sampleData = sampleData;
    }

    public boolean isNotificationsEnabled() {
        return notificationsEnabled;
    }

    public void setNotificationsEnabled(boolean notificationsEnabled) {
        this.notificationsEnabled = notificationsEnabled;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    // Inner Class for Sample Data
    public static class SampleData implements Serializable {
        private static final long serialVersionUID = 1L;
        
        private int id;
        private String name;
        private String status;
        private String severity;

        public SampleData(int id, String name, String status, String severity) {
            this.id = id;
            this.name = name;
            this.status = status;
            this.severity = severity;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getSeverity() {
            return severity;
        }

        public void setSeverity(String severity) {
            this.severity = severity;
        }
    }
}
