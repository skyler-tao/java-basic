package skyler.tao.jackson.serializationignore;

import com.fasterxml.jackson.annotation.JsonProperty;

public class People {
    private String name;
//    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String company;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
