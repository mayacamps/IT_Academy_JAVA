package n1ex05;

import java.io.Serializable;

public class ObjectSer implements Serializable {
    private String name;
    private String type;
    private String modDate;

    public ObjectSer(String name, String type, String modDate) {
        this.name = name;
        this.type = type;
        this.modDate = modDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModDate() {
        return modDate;
    }

    public void setModDate(String modDate) {
        this.modDate = modDate;
    }

    public String toString(){
        return "File name: " + this.getName() +"\n" +
                "Type: " + this.getType() + "\n" +
                "Modification Date: " + this.getModDate() + "\n";
    }
}
