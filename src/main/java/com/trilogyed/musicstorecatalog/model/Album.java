package com.trilogyed.musicstorecatalog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "album")
public class Album implements Serializable {
    public Album() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private long id;
    @NotNull
    private String title;

    @NotNull
    @Column(name = "artist_id")
    private long artistId;

    @NotNull
    @Column(name = "release_date")
    private Date releaseDate;

    @NotNull
    @Column(name = "label_id")
    private long labelId;

    @NotNull
    @Column(name = "list_price")
    private BigDecimal listPrice;

    public Album(long id, String title, long artistId, Date releaseDate, long labelId, BigDecimal listPrice) {
        this.id = id;
        this.title = title;
        this.artistId = artistId;
        this.releaseDate = releaseDate;
        this.labelId = labelId;
        this.listPrice = listPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getArtistId() {
        return artistId;
    }

    public void setArtistId(long artistId) {
        this.artistId = artistId;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getLabelId() {
        return labelId;
    }

    public void setLabelId(long labelId) {
        this.labelId = labelId;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;
        Album album = (Album) o;
        return getId() == album.getId() && getArtistId() == album.getArtistId() && getLabelId() == album.getLabelId() && Objects.equals(getTitle(), album.getTitle()) && Objects.equals(getReleaseDate(), album.getReleaseDate()) && Objects.equals(getListPrice(), album.getListPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getArtistId(), getReleaseDate(), getLabelId(), getListPrice());
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artistId=" + artistId +
                ", releaseDate=" + releaseDate +
                ", labelId=" + labelId +
                ", listPrice=" + listPrice +
                '}';
    }
}
