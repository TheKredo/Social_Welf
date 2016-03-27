package learner.sukesh.socialwelf.model;

/**
 * Created by Sukesh on 26-03-2016.
 */
//@JsonIgnoreProperties(ignoreUnknown=true)
public class Pojo {
     String title, disc;
     String owner;

    public Pojo(){}

    public Pojo(String title, String disc, String owner) {
        this.title = title;
        this.disc = disc;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public String getDisc() {
        return disc;
    }

    public String getOwner() {
        return owner;
    }
}
