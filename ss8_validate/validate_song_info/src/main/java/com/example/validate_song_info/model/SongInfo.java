package com.example.validate_song_info.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class SongInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Must not be empty !")
    @Size(max = 800, message = "Can't exceed 800 characters !")
    @Pattern(regexp = "^[^@;,\\.=\\-\\+]+$",message = "Must not contain special characters like @ ; , . = - + , ….")
    private String songName;

    @NotEmpty(message = "Must not be empty !")
    @Size(max = 300, message = "Can't exceed 800 characters !")
    @Pattern(regexp = "^[^@;,\\.=\\-\\+]+$",message = "Must not contain special characters like @ ; , . = - + , ….")
    private String artist;

    @NotEmpty(message = "Must not be empty !")
    @Size(max = 300, message = "Can't exceed 800 characters !")
    @Pattern(regexp = "^[^@;\\.=\\-\\+]+$",message = "Must not contain special characters like @ ; , . = - + , ….")
    private String type;

    public SongInfo() {
    }

    public SongInfo(int id, String songName, String artist, String type) {
        this.id = id;
        this.songName = songName;
        this.artist = artist;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
