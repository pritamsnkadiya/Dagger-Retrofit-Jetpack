package com.example.pritamsankadiya.androiddagger2.model;

import java.util.List;

public class Songs {

    private Boolean status;
    private List<SongsList> Song = null;
    private List<ImageShow> ImageShow = null;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<SongsList> getSong() {
        return Song;
    }

    public void setSong(List<SongsList> song) {
        this.Song = song;
    }

    public List<ImageShow> getImageShow() {
        return ImageShow;
    }

    public void setImageShow(List<com.example.pritamsankadiya.androiddagger2.model.ImageShow> imageShow) {
        ImageShow = imageShow;
    }
}
