package mg.news;

public class Datacaps {
    private String title;
    private String descrption;
    private String url;
    private String img;
    private String date;

    public Datacaps()
    {

    }

    public Datacaps(String title, String descrption, String url, String img,String date) {
        this.title = title;
        this.descrption = descrption;
        this.url = url;
        this.img = img;
        this.date=date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescrption() {
        return descrption;
    }

    public String getUrl() {
        return url;
    }

    public String getImg() {
        return img;
    }

    public String getDate() {
        return date;
    }
}
