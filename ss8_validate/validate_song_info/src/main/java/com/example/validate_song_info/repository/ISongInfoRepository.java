package com.example.validate_song_info.repository;

import com.example.validate_song_info.model.SongInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongInfoRepository extends JpaRepository<SongInfo, Integer> {

}
