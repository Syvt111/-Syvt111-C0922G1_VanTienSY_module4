package com.example.validate_song_info.service;

import com.example.validate_song_info.model.SongInfo;
import com.example.validate_song_info.repository.ISongInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongInfoService implements ISongInfoService {

    @Autowired
    private ISongInfoRepository songInfoRepository;

    @Override
    public void save(SongInfo songInfo) {
        songInfoRepository.save(songInfo);
    }

    @Override
    public List<SongInfo> findAll() {
        return songInfoRepository.findAll();
    }

    @Override
    public void edit(SongInfo songInfo) {

    }
}
