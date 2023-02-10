package com.example.service;

import com.example.model.EmailSetting;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SettingService {
    static final Map<Integer, EmailSetting> settingList = new HashMap<>();
    static {

        settingList.put(1,new EmailSetting("設定","言語","ページサイズ","スパムフィルター","サイン","アップデート","キャンセル"));
        settingList.put(2,new EmailSetting("Cài đặt","Ngôn ngữ","Kích thước trang","Lọc thư rác","Chữ Ký","Cập nhật","Hủy"));
        settingList.put(3,new EmailSetting("Settings","Languages","Page Size","Spams filter","Signature","Update","Cancel"));
        settingList.put(4,new EmailSetting("Paramètre","langue","Taille de la page","Filtrage des spams","Signature", "Mise à jour","Annuler"));
    }

    public EmailSetting getSetting(int id){
        return settingList.get(id);
    }
}
