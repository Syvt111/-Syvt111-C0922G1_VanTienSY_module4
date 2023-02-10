package com.example.validate_song_info.repository;

import com.example.validate_song_info.model.SongInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongInfoRepository extends JpaRepository<SongInfo, Integer> {
Page<SongInfo> findSongInfoBySongNameContaining(String songName, Pageable pageable);

}
