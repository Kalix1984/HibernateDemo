package hu.kalix.hibernatedemo;

public enum EnviromentVariables {
    EMK_DB_URL("EMK_DB_URL"),
    EMK_DB_USER("EMK_DB_USER"),
    EMK_DB_PASSWORD("EMK_DB_PASSWORD");

    private String value;

    EnviromentVariables(String value) {
        this.value = value;
    }

    public String getValue() {
        return System.getenv(value) ;
    }
}
