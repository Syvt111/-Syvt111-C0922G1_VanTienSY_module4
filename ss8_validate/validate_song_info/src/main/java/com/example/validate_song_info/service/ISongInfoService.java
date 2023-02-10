package com.example.validate_song_info.service;

import com.example.validate_song_info.model.SongInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ISongInfoService {
    void save(SongInfo songInfo);
    List<SongInfo> findAll();

    SongInfo findById(int id);

    void delete(int id);

    Page<SongInfo> findSongInfoBySongNameContaining(String songName, Pageable pageable);
}
