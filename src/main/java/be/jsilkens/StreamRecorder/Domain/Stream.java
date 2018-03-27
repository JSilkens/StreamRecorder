package be.jsilkens.StreamRecorder.Domain;

import javax.persistence.*;

/*
    A webstream class.
 */
@Entity
public class Stream {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false, name = "streamid")
    private Long id;

    private String name;

    private String link;

    private String mimeType;

    private String description;

    public Stream(String name, String link, String mimeType, String description) {
        this.name = name;
        this.link = link;
        this.mimeType = mimeType;
        this.description = description;
    }

    public Stream() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Stream{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                ", mimeType='" + mimeType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
