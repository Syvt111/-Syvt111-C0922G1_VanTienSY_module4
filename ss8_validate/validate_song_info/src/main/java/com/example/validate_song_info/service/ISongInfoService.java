package com.example.validate_song_info.service;

import com.example.validate_song_info.model.SongInfo;

import java.util.List;

public interface ISongInfoService {
    void save(SongInfo songInfo);
    List<SongInfo> findAll();
    void edit(SongInfo songInfo);
}
