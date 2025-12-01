package qa.data.utils;

public class TestCaseProperties {
    public String ScenarioName;
    private int severity;
    private int priority;

    public TestCaseProperties() {
    }

    public void setScenarioName(String scenarioName) {
        this.ScenarioName = scenarioName;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getScenarioName() {
        return this.ScenarioName;
    }

    public int getSeverity() {
        return this.severity;
    }

    public int getPriority() {
        return this.priority;
    }
}
